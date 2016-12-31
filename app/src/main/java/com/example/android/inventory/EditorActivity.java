package com.example.android.inventory;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.android.inventory.data.ItemContract.ItemEntry;

import static android.R.attr.button;
import static android.icu.lang.UCharacter.JoiningGroup.E;

/**
 * Either add a new item or edit an existing one.
 */

public class EditorActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<Cursor>{

    private Uri mCurrentItem;
    private EditText mNameEditText;
    private EditText mPriceEditText;
    private EditText mQuantityEditText;
    private ImageView mImage;
    private Button mOrderButton;
    private Button mIncreaseButton;
    private Button mDecreaseButton;


    private static final int ITEM_LOADER = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        Intent intent = getIntent();
        mCurrentItem = intent.getData();

        if (mCurrentItem == null){
            setTitle(getString(R.string.new_item));
            invalidateOptionsMenu();
        } else{
            setTitle(getString(R.string.edit_item));
            getLoaderManager().initLoader(ITEM_LOADER,null, this);
        }

        mNameEditText = (EditText) findViewById(R.id.edit_product_name);
        mPriceEditText= (EditText) findViewById(R.id.edit_product_price);
        mQuantityEditText = (EditText) findViewById(R.id.edit_product_quantity);
        mImage = (ImageView) findViewById(R.id.image);
        mOrderButton = (Button) findViewById(R.id.order_button);
        mDecreaseButton = (Button) findViewById(R.id.decrease);
        mIncreaseButton = (Button) findViewById(R.id.increase);

    }


    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}


