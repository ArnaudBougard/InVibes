package com.eu.fpms.invibes;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _bRegister;
    EditText _etName, _etUsername, _etPassword;
    TextView _tvGoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        openHelper = new DatabaseHelper(this);
        _etName = (EditText)findViewById(R.id.etName);
        _etUsername = (EditText)findViewById(R.id.etUsername);
        _etPassword = (EditText)findViewById(R.id.etPassword);
        _bRegister=(Button)findViewById(R.id.bRegister);
        _tvGoLogin=(TextView)findViewById(R.id.tvGoLogin);

        _bRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                db=openHelper.getWritableDatabase();
                String name=_etName.getText().toString();
                String username=_etUsername.getText().toString();
                String password=_etPassword.getText().toString();
                insertdata(name,username,password);
                Toast.makeText(getApplicationContext(), "register successfully", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);

            }

        });

        _tvGoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    public void insertdata(String name, String username, String password) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, name);
        contentValues.put(DatabaseHelper.COL_3, username);
        contentValues.put(DatabaseHelper.COL_4, password);

        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);

    }

}

