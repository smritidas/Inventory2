package com.example.android.inventory.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.android.inventory.data.ItemContract.ItemEntry;

//Database helper for the app

public class ItemDBHelper extends SQLiteOpenHelper{

    //name of the database
    public final static String DB_NAME = "inventory.db";

    //database version
    public final static int DB_VERSION = 1;


    /**
     * Constructs a new instance of {@link ItemDBHelper}
     *
     * @param context of the app
     */
    public ItemDBHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION );
    }

    //called when database is called for the first time
    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE = "CREATE TABLE " + ItemEntry.TABLE_NAME + " ("
                + ItemEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ItemEntry.COLUMN_ITEM_NAME + " TEXT NOT NULL, "
                + ItemEntry.COLUMN_PRICE + " REAL NOT NULL DEFAULT 0.0, "
                + ItemEntry.COLUMN_QUANTITY + " INTEGER NOT NULL DEFAULT 0"
                + ");";

        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ItemContract.ItemEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
