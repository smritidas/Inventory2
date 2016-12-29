package com.example.android.inventory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.inventory.data.ItemContract.ItemEntry;

/**
 * Either add a new item or edit an existing one.
 */

public class EditorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);}
}
