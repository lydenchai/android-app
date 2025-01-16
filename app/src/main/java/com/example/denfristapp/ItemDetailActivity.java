package com.example.denfristapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        Intent intent = getIntent();
        String itemDescription = intent.getStringExtra("ITEM_DESCRIPTION");
        int itemImageResId = intent.getIntExtra("ITEM_IMAGE", R.drawable.image1);

        TextView itemDetailText = findViewById(R.id.itemDetailText);
        itemDetailText.setText(itemDescription);

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(itemImageResId);
    }

    public void onBack(View view) {
        Intent intent = new Intent(ItemDetailActivity.this, ListItemActivity.class);
        startActivity(intent);
    }
}
