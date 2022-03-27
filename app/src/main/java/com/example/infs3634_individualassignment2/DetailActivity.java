package com.example.infs3634_individualassignment2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "DetailActivity";
    TextView dName, dPlace, dRating, dDesc;
    ImageView dMap;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle("Detail Activity");
        Intent intent = getIntent();
        String msg = intent.getStringExtra("key");
        Holiday holiday = Holiday.findHolidays(msg);
        Log.d(TAG, "Received Message " + msg);

        Log.d(TAG, "Holiday Name: " + holiday.getName());

        // Get handle to view elements
        dName = findViewById(R.id.tvName);
        dPlace = findViewById(R.id.tvPlace);
        dRating = findViewById(R.id.tvRating);
        dDesc = findViewById(R.id.tvDesc);
        dMap = findViewById(R.id.tvMap);

        // Set values
        dName.setText(holiday.getName());
        dPlace.setText(holiday.getLocation());
        dRating.setText(holiday.getRating());
        dDesc.setText(holiday.getDescription());
        // To-do: Fix ImageView
        dMap.setImage(holiday.getImage());

    }
}

