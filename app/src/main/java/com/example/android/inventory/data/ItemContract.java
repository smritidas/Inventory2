package com.example.android.inventory.data;


import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * The API contract class for the app
 */

public class ItemContract {

    //To prevent accidental instantiating give it an empty constructor
    private ItemContract() {
    }

    public static final String CONTENT_AUTHORITY = "com.example.android.inventory";

    /**
     * This is the base of all the URIs which the apps will contact it with.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);


    //Possible path. Check Pets app for explanation.
    public static final String PATH_ITEM = "inventory";

    //Inner class that represents constant values
    public static final class ItemEntry implements BaseColumns{

        //Content URI to access data in the provider
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_ITEM);

        //Mime type for a list of products
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ITEM;

        //Mime type for a single product
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ITEM;

        //Name of database table
        public static final String TABLE_NAME = "inventory";

        public static final String _ID = BaseColumns._ID;


        public static final String COLUMN_ITEM_NAME = "name";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_QUANTITY = "quantity";

    }
}
