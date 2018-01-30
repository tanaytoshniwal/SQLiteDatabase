package com.example.alphabat69.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by AlphaBAT69 on 31-01-2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static String dbName = "school.db";
    public static int dbVersion = 1;
    public static String table = "login";
    public static String column1 = "username";
    public static String column2 = "password";
    public static String column3 = "contact";
    public static String createTable = "create table login(_id integer primary key autoincrement, username text, password text, contact text)";
    public static String TAG = "MyDB";

    SQLiteDatabase database;

    public DBHelper(Context context){
        //Database created
        super(context, dbName, null, dbVersion);
        Log.i(TAG,"Database Created Successfully");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
        Log.i(TAG,"Database Created Successfully");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //to save values to database
    public void save(String username, String password, String contact){
        database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(column1, username);
        values.put(column2, password);
        values.put(column3, contact);
        database.insert(table, null, values);
        Log.i(TAG, "Record Inserted");
        database.close();
    }

    //to delete records from database
    public void delete(String username){
        database = getWritableDatabase();
        String[] str = {username};
        database.delete(table, "username=?", str);
        Log.i(TAG, "Record Deleted");
        database.close();

    }
}
