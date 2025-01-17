package com.example.denfristapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout itemContainer = findViewById(R.id.places);
        LinearLayout placeContainer = findViewById(R.id.morePlaces);

        int[] imageResIds = {
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3,
                R.drawable.image4,
                R.drawable.image5,
                R.drawable.image6
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
        String[] descriptions = {
                getString(R.string.description),
                getString(R.string.description),
                getString(R.string.description),
                getString(R.string.description),
                getString(R.string.description),
                getString(R.string.description),
        };

        LayoutInflater inflater = LayoutInflater.from(this);

        for (int i = 0; i < imageResIds.length; i++) {
            View itemView = inflater.inflate(R.layout.places, itemContainer, false);
            ImageView itemImage = itemView.findViewById(R.id.placeImage);
            TextView itemText = itemView.findViewById(R.id.placeName);
            TextView itemPlace = itemView.findViewById(R.id.inPlace);

            itemImage.setImageResource(imageResIds[i]);
            itemText.setText(texts[i]);
            itemPlace.setText(countries[i]);

            final int index = i;
            itemView.setOnClickListener(v -> openPlaceDetail(texts[index], imageResIds[index], countries[index], descriptions[index]));

            itemContainer.addView(itemView);

            View morePlaceView = inflater.inflate(R.layout.more_places, placeContainer, false);
            ImageView placeImg = morePlaceView.findViewById(R.id.morePlaceImg);
            TextView placeName = morePlaceView.findViewById(R.id.morePlaceName);
            TextView country = morePlaceView.findViewById(R.id.country);
            TextView price = morePlaceView.findViewById(R.id.price);
            TextView rate = morePlaceView.findViewById(R.id.rate);

            placeImg.setImageResource(imageResIds[i]);
            placeName.setText(texts[i]);
            country.setText(countries[i]);
            price.setText(prices[i]);
            rate.setText(rates[i]);

            morePlaceView.setOnClickListener(v -> openPlaceDetail(texts[index], imageResIds[index], countries[index], descriptions[index]));

            placeContainer.addView(morePlaceView);
        }
    }

    private void openPlaceDetail(String itemName, int imageResId, String inPlace, String description) {
        Intent intent = new Intent(MainActivity.this, PlaceDetailActivity.class);
        intent.putExtra("ITEM_NAME", itemName);
        intent.putExtra("ITEM_IMAGE", imageResId);
        intent.putExtra("IN_PLACE", inPlace);
        intent.putExtra("DESCRIPTION", description);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Restart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Destroyed", Toast.LENGTH_SHORT).show();
    }
}
