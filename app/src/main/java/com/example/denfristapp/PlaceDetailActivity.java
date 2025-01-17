package com.example.denfristapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;

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

        LinearLayout thingsTodo = findViewById(R.id.toDoList);
        LinearLayout placeContainer = findViewById(R.id.morePlaces);
        int[] images = {
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3,
                R.drawable.image4,
                R.drawable.image5,
                R.drawable.image6
        };
        String[] things = {
                getString(R.string.todo1),
                getString(R.string.todo2),
                getString(R.string.todo3),
                getString(R.string.todo4),
                getString(R.string.todo5),
                getString(R.string.todo6)
        };
        String[] texts = {
                getString(R.string.place1),
                getString(R.string.place2),
                getString(R.string.place3),
                getString(R.string.place4),
                getString(R.string.place5),
                getString(R.string.place6),
        };
        String[] countries = {
                getString(R.string.country),
                getString(R.string.country),
                getString(R.string.country),
                getString(R.string.country),
                getString(R.string.country),
                getString(R.string.country)
        };
        String[] prices = {
                getString(R.string.price1),
                getString(R.string.price2),
                getString(R.string.price3),
                getString(R.string.price4),
                getString(R.string.price5),
                getString(R.string.price6)
        };
        String[] rates = {
                getString(R.string.rate1),
                getString(R.string.rate2),
                getString(R.string.rate3),
                getString(R.string.rate4),
                getString(R.string.rate5),
                getString(R.string.rate6)
        };
        LayoutInflater inflater = LayoutInflater.from(this);

        for (int i = 0; i < things.length; i++) {
            View itemView = inflater.inflate(R.layout.to_do_list, thingsTodo, false);
            TextView itemText = itemView.findViewById(R.id.toDoName);

            itemText.setText(things[i]);

            final int index = i;
            itemView.setOnClickListener(v -> openTodoDetail(things[index], images[index]));

            thingsTodo.addView(itemView);
        }

        for (int i = 0; i < images.length; i++) {
            View morePlaceView = inflater.inflate(R.layout.more_places, placeContainer, false);
            ImageView placeImg = morePlaceView.findViewById(R.id.morePlaceImg);
            TextView placeName = morePlaceView.findViewById(R.id.morePlaceName);
            TextView country = morePlaceView.findViewById(R.id.country);
            TextView price = morePlaceView.findViewById(R.id.price);
            TextView rate = morePlaceView.findViewById(R.id.rate);

            placeImg.setImageResource(images[i]);
            placeName.setText(texts[i]);
            country.setText(countries[i]);
            price.setText(prices[i]);
            rate.setText(rates[i]);

            final int index = i;
            morePlaceView.setOnClickListener(v -> openPlaceDetail(texts[index], images[index]));

            placeContainer.addView(morePlaceView);
        }
    }

    public void onBackToMain(View view) {
        Intent intent = new Intent(PlaceDetailActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private void openTodoDetail(String itemDescription, int itemImageResId) {
        Intent intent = new Intent(PlaceDetailActivity.this, PlaceDetailActivity.class);
        intent.putExtra("ITEM_DESCRIPTION", itemDescription);
        intent.putExtra("ITEM_IMAGE", itemImageResId);
        startActivity(intent);
    }

    private void openPlaceDetail(String itemDescription, int imageResId) {
        Intent intent = new Intent(PlaceDetailActivity.this, PlaceDetailActivity.class);
        intent.putExtra("ITEM_DESCRIPTION", itemDescription);
        intent.putExtra("ITEM_IMAGE", imageResId);
        startActivity(intent);
    }
}
