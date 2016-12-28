package com.example.android.inventory.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ItemDBHelper extends SQLiteOpenHelper{

    public final static String DB_NAME = "inventory.db";
    public final static int DB_VERSION = 1;

    public ItemDBHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION );
    }

    //TODO Fix item entry
    @Override
    public void onCreate(SQLiteDatabase db){
      final String SQL_CREATE_TABLE = "CREATE TABLE " + ItemContract.ItemEntry.TABLE_NAME + " (" +
              ItemContract.ItemEntry.COLUMN_ID + " INTEGER PRIMARY KEY," +
              ItemContract.ItemEntry.COLUMN_ITEM_NAME + " TEXT NOT NULL," +
              ItemContract.ItemEntry.COLUMN_PRICE + " INTEGER NOT NULL," +
              ItemContract.ItemEntry.COLUMN_QUANTITY + " INTEGER NOT NULL);";

        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}
