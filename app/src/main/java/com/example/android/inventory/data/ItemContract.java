package com.example.android.inventory.data;


import android.provider.BaseColumns;

/**
 * The contract class for the app
 */

public class ItemContract {

    public static final class ItemEntry implements BaseColumns{

        public static final String COLUMN_ID = "id";
        public static final String TABLE_NAME = "item";

        public static final String COLUMN_ITEM_NAME = "name";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_QUANTITY = "quantity";

    }
}
