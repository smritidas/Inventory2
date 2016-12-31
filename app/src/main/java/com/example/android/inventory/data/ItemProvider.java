package com.example.android.inventory.data;


import android.content.ClipData;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import java.net.URI;

import static android.icu.text.UnicodeSet.CASE;

public class ItemProvider extends ContentProvider {

    public static final int ITEMS = 100;

    public static final int ITEMS_ID = 101;

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(ItemContract.CONTENT_AUTHORITY, ItemContract.PATH_ITEM, ITEMS);
        sUriMatcher.addURI(ItemContract.CONTENT_AUTHORITY, ItemContract.PATH_ITEM + "/#", ITEMS_ID);
    }

    private ItemDBHelper mDBHelper;

    @Override
    public boolean onCreate() {
        mDBHelper = new ItemDBHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        SQLiteDatabase database = mDBHelper.getReadableDatabase();

        Cursor cursor;

        int match = sUriMatcher.match(uri);
        switch (match) {
            case ITEMS:

            cursor = database.query(ItemContract.ItemEntry.TABLE_NAME, projection, selection, selectionArgs,
                    null, null, sortOrder);
            break;

            case ITEMS_ID:
                selection = ItemContract.ItemEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                cursor = database.query(ItemContract.ItemEntry.TABLE_NAME, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    private Uri insertItem(Uri uri, ContentValues values){
        String name = values.getAsString(ItemContract.ItemEntry.COLUMN_ITEM_NAME);
        if (name == null) {
            throw new IllegalArgumentException("Item requires a name");
        }

        Integer price = values.getAsInteger(ItemContract.ItemEntry.COLUMN_PRICE);
        if (price == null || !ItemContract.ItemEntry.isValidPrice(price)) {
            throw new IllegalArgumentException("Item requires a valid price");
        }

        Integer quantity = values.getAsInteger(ItemContract.ItemEntry.COLUMN_QUANTITY);
        if (price == null || !ItemContract.ItemEntry.isValidQuantity(price)) {
            throw new IllegalArgumentException("Item requires a valid quantity");
        }

        SQLiteDatabase database = mDBHelper.getWritableDatabase();

        // Insert the new pet with the given values
        long id = database.insert(ItemContract.ItemEntry.TABLE_NAME, null, values);
        // If the ID is -1, then the insertion failed. Log an error and return null.
        if (id == -1) {
            return null;
        }

        // Notify all listeners that the data has changed for the pet content URI
        getContext().getContentResolver().notifyChange(uri, null);

        // Return the new URI with the ID (of the newly inserted row) appended at the end
        return ContentUris.withAppendedId(uri, id);
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }



    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }
}
