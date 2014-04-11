package com.example.assignment;

import java.sql.SQLException;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBAdapter 
{
    public static final String KEY_ROWID = "_id";
    public static final String KEY_firstname= "firstname";
    public static final String KEY_surname = "surname";
    public static final String KEY_address = "address";
    public static final String KEY_phone = "phone";
    public static final String KEY_email = "email";
        private static final String TAG = "DBAdapter";

    private static final String DATABASE_NAME = "taxi";
    private static final String DATABASE_TABLE = "Booking";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE =
        "create table " + DATABASE_TABLE + " (_id integer primary key autoincrement, "
        + "firstname text not null, surname text not null, " 
        + "address text not null, phone integer not null, email text not null);";

    private final Context context; 

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx) 
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper 
    {
        DatabaseHelper(Context context) 
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) 
        {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion 
                    + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS titles");
            onCreate(db);
        }
    }    

    //---opens the database---
    public DBAdapter open() throws SQLException 
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---    
    public void close() 
    {
        DBHelper.close();
    }

    //---insert a title into the database---
    public long insertTitle(String firstname, String surname, String address, String phone, String email) 
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_firstname, firstname);
        initialValues.put(KEY_surname, surname);
        initialValues.put(KEY_address, address);
        initialValues.put(KEY_phone, phone);
        initialValues.put(KEY_email, email);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    //---deletes a particular title---
    public boolean deleteTitle(long rowId) 
    {
        return db.delete(DATABASE_TABLE, KEY_ROWID + 
                "=" + rowId, null) > 0;
    }

    //---retrieves all the titles---
    public Cursor getAllTitles() 
    {
        return db.query(DATABASE_TABLE, new String[] {
                KEY_ROWID, 
                KEY_firstname,
                KEY_surname,
                KEY_address,
                KEY_phone,
                KEY_email
            }, 
            null, 
            null, 
            null, 
            null, 
            null);
    }

    //---retrieves a particular title---
    public Cursor getTitle(long rowId) throws SQLException 
    {
        Cursor mCursor =
            db.query(true, DATABASE_TABLE, new String[] {
                                KEY_ROWID,
                                KEY_firstname, 
                                KEY_surname,
                                KEY_address,
                                KEY_phone,
                                KEY_email
                    }, 
                    KEY_ROWID + "=" + rowId, 
                    null,
                    null, 
                    null, 
                    null, 
                    null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //---updates a title---
    public boolean updateTitle(long rowId, String firstname, String surname, String address, String phone, String email) 
    {
        ContentValues args = new ContentValues();
        args.put(KEY_firstname, firstname);
        args.put(KEY_surname, surname);
        args.put(KEY_address, address);
        args.put(KEY_phone, phone);
        args.put(KEY_email, email);
        return db.update(DATABASE_TABLE, args, 
                     KEY_ROWID + "=" + rowId, null) > 0;
    }
}