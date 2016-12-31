package com.example.android.inventory;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
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

    private boolean mItemHasChanged = false;

    private View.OnTouchListener mTouchListener = new View.OnTouchListener(){
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            mItemHasChanged = true;
            return false;
        }
    };

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
        mIncreaseButton = (Button) findViewById(R.id.increase);
        mDecreaseButton = (Button) findViewById(R.id.decrease);

        mNameEditText.setOnTouchListener(mTouchListener);
        mPriceEditText.setOnTouchListener(mTouchListener);
        mQuantityEditText.setOnTouchListener(mTouchListener);

    }

    //Create a button to delete everything
    private int deleteProduct(Uri itemUri) {
        return getContentResolver().delete(itemUri, null, null);
    }

    //Get input from user and save into a database


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


