package com.eu.fpms.invibes;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UserAreaActivity2 extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Cursor c;
    TextView _TminValue,_TmaxValue,_HminValue,_HmaxValue,_BminValue,_BmaxValue,_PhoneValue,_tvUsername;
    Button _bBack,_bGoA,_bGoB;
    String TminValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area_2);

        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();

        System.out.println(DatabaseHelper.COL_5);

        _TminValue=(TextView)findViewById(R.id.TminValue);
        _TmaxValue=(TextView)findViewById(R.id.TmaxValue);
        _HminValue=(TextView)findViewById(R.id.HminValue);
        _HmaxValue=(TextView)findViewById(R.id.HmaxValue);
        _BminValue=(TextView)findViewById(R.id.BminValue);
        _BmaxValue=(TextView)findViewById(R.id.BmaxValue);
        _PhoneValue=(TextView)findViewById(R.id.PhoneValue);
        _tvUsername=(TextView)findViewById(R.id.tvUsername);

        System.out.println(DatabaseHelper.COL_5);

        Bundle bundle=getIntent().getExtras();

        final String username=bundle.getString("username");

        _tvUsername.setText(username + ", plusieurs choix s'offrent à vous !");

        //Cursor c = db.rawQuery("select " + DatabaseHelper.COL_5 + " from " + DatabaseHelper.TABLE_NAME + " where " + DatabaseHelper.COL_3 + "=?", new String[]{username});
        //if (c.moveToFirst()) {
        //    TminValue = c.getString(c.getColumnIndex("content"));
        //}
        //_TminValue.setText(TminValue);


    }
}
