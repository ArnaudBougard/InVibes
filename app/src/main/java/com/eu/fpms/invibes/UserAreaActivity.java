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

public class UserAreaActivity extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    TextView _tvUsername;
    EditText _etTm, _etTM, _etHm, _etHM, _etBm, _etBM, _etPhone;
    Button _bSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        openHelper = new DatabaseHelper(this);

        _etTm = (EditText)findViewById(R.id.etTm);
        _etTM = (EditText)findViewById(R.id.etTM);
        _etHm = (EditText)findViewById(R.id.etHm);
        _etHM = (EditText)findViewById(R.id.etHM);
        _etBm = (EditText)findViewById(R.id.etBm);
        _etBM = (EditText)findViewById(R.id.etBM);
        _etPhone = (EditText)findViewById(R.id.etPhone);
        _bSave = (Button)findViewById(R.id.bSave);


        _tvUsername=(TextView)findViewById(R.id.tvUsername);

        Bundle bundle=getIntent().getExtras();

        final String username=bundle.getString("username");

        _tvUsername.setText("Bonjour, " + username + " !");

        _bSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                db=openHelper.getWritableDatabase();

                String Tmin=_etTm.getText().toString();
                String Tmax=_etTM.getText().toString();
                String Hmin=_etHm.getText().toString();
                String Hmax=_etHM.getText().toString();
                String Bmin=_etBm.getText().toString();
                String Bmax=_etBM.getText().toString();
                String Phone=_etPhone.getText().toString();

                //insertdata2(username,Tmin, Tmax, Hmin, Hmax, Bmin, Bmax, Phone);

                Toast.makeText(getApplicationContext(), "Enregistré avec succès !", Toast.LENGTH_LONG).show();

                Bundle bundle = new Bundle();
                bundle.putString("username", username);
                Intent intent = new Intent(UserAreaActivity.this, UserAreaActivity2.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }

        });



    }

    public void insertdata2(String username, String Tmin, String Tmax, String Hmin, String Hmax, String Bmin, String Bmax, String Phone) {

        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COL_5,Tmin);
        //cv.put(DatabaseHelper.COL_6,Tmax);
        //cv.put(DatabaseHelper.COL_7,Hmin);
        //cv.put(DatabaseHelper.COL_8,Hmax);
        //cv.put(DatabaseHelper.COL_9,Bmin);
        //cv.put(DatabaseHelper.COL_10,Bmax);
        //cv.put(DatabaseHelper.COL_11,Phone);

        System.out.println(DatabaseHelper.COL_5);


        //long id = db.insert(DatabaseHelper.TABLE_NAME, null, cv);
        db.update(DatabaseHelper.TABLE_NAME, cv,"DatabaseHelper.COL_3=" + username,null);

        System.out.println(DatabaseHelper.COL_5);
    }



}
