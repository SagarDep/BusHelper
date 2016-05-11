package com.android.bushelper.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_USER = "create table users ("
            + "user_id integer primary key autoincrement,"
            + "account text,"
            + "nickname text,"
            + "password text)";

    public static final String CREATE_ORDER = "create table orders ("
            + "order_id integer primary key autoincrement,"
            + "user_id integer,"
            + "order_no text,"
            + "order_time text,"
            + "start text,"
            + "arrive text,"
            + "date text,"
            + "price text)";

    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);
        db.execSQL(CREATE_ORDER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
