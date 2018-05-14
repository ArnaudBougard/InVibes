package com.eu.fpms.invibes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Arnaud on 07-05-18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="register.db";
    public static final String TABLE_NAME="user";

    public static final String COL_1="ID";
    public static final String COL_2="Name";
    public static final String COL_3="Username";
    public static final String COL_4="Password";
    public static String COL_5="Tmin";
    public static String COL_6="Tmax";
    public static String COL_7="Hmin";
    public static String COL_8="Hmax";
    public static String COL_9="Bmin";
    public static String COL_10="Bmax";
    public static String COL_11="Phone";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT NOT NULL,Username TEXT NOT NULL,Password TEXT NOT NULL,Tmin TEXT,Tmax TEXT,Hmin TEXT,Hmax TEXT,Bmin TEXT,Bmax TEXT,Phone TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_NAME);
        onCreate(db);
    }


}


