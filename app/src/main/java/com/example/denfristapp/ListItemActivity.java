package com.example.denfristapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        LinearLayout itemContainer = findViewById(R.id.itemContainer);

        int[] imageResIds = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};
        String[] texts = {
                getString(R.string.section1_text),
                getString(R.string.section2_text),
                getString(R.string.section3_text),
                getString(R.string.section4_text),
                getString(R.string.section5_text)
        };
        LayoutInflater inflater = LayoutInflater.from(this);
        for (int i = 0; i < imageResIds.length; i++) {
            View itemView = inflater.inflate(R.layout.list_item, itemContainer, false);

            ImageView itemImage = itemView.findViewById(R.id.itemImage);
            TextView itemText = itemView.findViewById(R.id.itemText);

            itemImage.setImageResource(imageResIds[i]);
            itemText.setText(texts[i]);

            final int index = i;
            View.OnClickListener clickListener = v -> openItemDetailActivity(texts[index], imageResIds[index]);
            itemImage.setOnClickListener(clickListener);
            itemText.setOnClickListener(clickListener);

            itemContainer.addView(itemView);
        }
    }

    private void openItemDetailActivity(String itemDescription, int imageResId) {
        Intent intent = new Intent(ListItemActivity.this, ItemDetailActivity.class);
        intent.putExtra("ITEM_DESCRIPTION", itemDescription);
        intent.putExtra("ITEM_IMAGE", imageResId);
        startActivity(intent);
    }
}
