package com.example.denfristapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PlaceDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        Intent intent = getIntent();
        String itemDescription = intent.getStringExtra("ITEM_DESCRIPTION");
        int itemImageResId = intent.getIntExtra("ITEM_IMAGE", R.drawable.image1);

        TextView itemDetailText = findViewById(R.id.placeName);
        itemDetailText.setText(itemDescription);

        ImageView imageView = findViewById(R.id.placeImage);
        imageView.setImageResource(itemImageResId);
    }

    public void onBackToMain(View view) {
        Intent intent = new Intent(PlaceDetailActivity.this, MainActivity.class);
        startActivity(intent);
    }
}