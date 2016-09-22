package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    Integer itemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String item = getIntent().getStringExtra("item");
        itemPosition = getIntent().getIntExtra("position", 0);
        EditText editText = (EditText) findViewById(R.id.txtEdit);
        editText.setText(item);
        editText.setSelection(item.length());
    }

    public void onSubmitItem(View v) {
        EditText editText = (EditText) findViewById(R.id.txtEdit);
        String item = editText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("item", item);
        intent.putExtra("position", itemPosition);
        setResult(1, intent);
        finish();
    }
}
