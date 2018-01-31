package com.example.alphabat69.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

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
        Log.i(TAG,"Table Created Successfully");
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

    //to delete all records
    public int delete(){
        database = getWritableDatabase();
        int i = database.delete(table, null, null);
        Log.i(TAG, i+" Records deleted");
        database.close();
        return i;
    }

    //to update record
    public int update(String username, String newpassword, String newcontact){
        database = getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(column2, newpassword);
        value.put(column3, newcontact);
        int i = database.update(table, value, "username=?", new String[]{username});
        Log.i(TAG, i+" records updated");
        database.close();
        return i;
    }

    public ArrayList<StringBuffer> showAll(){
        database = getWritableDatabase();
        Cursor c = database.rawQuery("select * from login order by username", null);
        int count = c.getColumnCount();
        ArrayList<StringBuffer> list = new ArrayList<>();
        while(c.moveToNext()){
            StringBuffer buffer = new StringBuffer();
            for(int i=0;i<count;i++){
                buffer.append(c.getString(i));
                if(i!=count-1)
                    buffer.append(",");
            }
            list.add(buffer);
        }
        database.close();
        return list;
    }
}
