package com.eu.fpms.invibes;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Cursor cursor;
    Button _bLogin;
    EditText _etUsername, _etPassword;
    TextView _tvRegisterHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _etUsername = (EditText)findViewById(R.id.etUsername);
        _etPassword = (EditText)findViewById(R.id.etPassword);
        _bLogin=(Button)findViewById(R.id.bLogin);
        _tvRegisterHere=(TextView)findViewById(R.id.tvRegisterHere);
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();

        _bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = _etUsername.getText().toString();
                String password = _etPassword.getText().toString();

                cursor = db.rawQuery("SELECT *FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_3 + "=? AND " + DatabaseHelper.COL_4 + "=?", new String[]{username, password});
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        Toast.makeText(getApplicationContext(), "Login Success !", Toast.LENGTH_SHORT).show();
                        Bundle bundle = new Bundle();
                        bundle.putString("username", username);
                        Intent intent = new Intent(LoginActivity.this, UserAreaActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);

                    } else {
                        Toast.makeText(getApplicationContext(), "Error, wrong combination of Username and Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        _tvRegisterHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

}
