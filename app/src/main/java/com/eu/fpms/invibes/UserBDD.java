//
///**
// * Created by Arnaud on 14-05-18.
// */
//
//package com.eu.fpms.invibes;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//
//    public class UserBDD {
//
//        private static final int VERSION = 1;
//        private static final String DB_NAME = "invibes.db";
//
//        private static final String TABLE_NAME = "user";
//        private static final String COL_ID = "ID";
//        private static final int NUM_COL_ID = 0;
//        private static final String COL_NAME = "NAME";
//        private static final int NUM_COL_NAME = 1;
//        private static final String COL_USERNAME = "USERNAME";
//        private static final int NUM_COL_USERNAME = 2;
//        private static final String COL_PASSWORD = "PASSWORD";
//        private static final int NUM_COL_PASSWORD = 3;
//
//        private static final int NUM_COL_TMIN = 4;
//        private static final int NUM_COL_TMAX = 5;
//        private static final int NUM_COL_HMIN= 6;
//        private static final int NUM_COL_HMAX = 7;
//        private static final int NUM_COL_BMIN = 8;
//        private static final int NUM_COL_BMAX = 9;
//        private static final int NUM_COL_PHONE = 10;
//
//        private SQLiteDatabase bdd;
//
//        private DatabaseHelper users;
//
//        public UserBDD(Context context) {
//            users = new DatabaseHelper(context, DB_NAME, null, VERSION);
//        }
//
//        public void openForWrite() {
//            bdd = users.getWritableDatabase();
//        }
//
//        public void openForRead() {
//            bdd = users.getReadableDatabase();
//        }
//
//        public void close() {
//            bdd.close();
//        }
//
//        public SQLiteDatabase getBdd() {
//            return bdd;
//        }
//
//        public long insertUser(User user) {
//
//            ContentValues content = new ContentValues();
//            content.put(COL_NAME, user.getName());
//            content.put(COL_USERNAME, user.getUsername());
//            content.put(COL_PASSWORD, user.getPassword());
//
//            return bdd.insert(TABLE_NAME, null, content);
//
//        }
//
//        public int updateUserPreferences(int id, User user) {
//            ContentValues content = new ContentValues();
//            content.put(COL_TMIN, user.getTmin());
//            content.put(COL_TMAX, user.getTmax());
//            content.put(COL_HMIN, user.getHmin());
//            content.put(COL_HMAX, user.getHmax());
//            content.put(COL_BMIN, user.getBmin());
//            content.put(COL_BMAX, user.getBmax());
//            content.put(COL_PHONE, user.getPhone());
//
//            return bdd.update(TABLE_NAME, content, COL_ID + " = " + id, null);
//        }
//
//        public User getUser(String username) {
//            Cursor c = bdd.query(TABLE_NAME, new String[] { COL_ID, COL_NAME,
//                    COL_USERNAME, COL_PASSWORD }, COL_USERNAME + " LIKE \"" + username + "\"", null, null,null, COL_USERNAME);
//            return cursorToUser(c);
//        }
//
//        public User getUserPreferences(String name) {
//            Cursor c = bdd.query(TABLE_NAME, new String[] { COL_TMIN, COL_TMAX,
//                    COL_HMIN, COL_HMAX, COL_BMIN, COL_BMAX, COL_PHONE }, COL_NAME + " LIKE \"" + name + "\"", null, null,null, COL_NAME);
//            return cursorToUser2(c);
//        }
//
//        public User cursorToUser(Cursor c) {
//            if (c.getCount() == 0) {
//                c.close();
//                return null;
//            }
//            User user = new User();
//            user.setId(c.getInt(NUM_COL_ID));
//            user.setName(c.getString(NUM_COL_NAME));
//            user.setUsername(c.getString(NUM_COL_USERNAME));
//            user.setPassword(c.getString(NUM_COL_PASSWORD));
//
//            c.close();
//            return user;
//        }
//
//        public User cursorToUser2(Cursor c) {
//            if (c.getCount() == 0) {
//                c.close();
//                return null;
//            }
//            User user = new User();
//            user.setId(c.getInt(NUM_COL_TMIN));
//            user.setName(c.getString(NUM_COL_TMAX));
//            user.setUsername(c.getString(NUM_COL_HMIN));
//            user.setPassword(c.getString(NUM_COL_HMAX));
//            user.setUsername(c.getString(NUM_COL_BMIN));
//            user.setPassword(c.getString(NUM_COL_BMAX));
//            user.setUsername(c.getString(NUM_COL_PHONE));
//
//            c.close();
//            return user;
//        }
//
//    }
