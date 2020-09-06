package com.example.seniordesignproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

public class RateDetails2 extends AppCompatActivity {
    FirebaseFirestore db;
    TextView neighborhood, content,  userdetails;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_details2);

        neighborhood = findViewById(R.id.rateneighborhoodtitle);
        content = findViewById(R.id.rateneighborhoodcontent);

        Intent i = getIntent();
        final String neighborhoodName = i.getStringExtra("neighborhood");
        final String contentName = i.getStringExtra("content");
        final Bundle bundle = getIntent().getExtras();

        neighborhood.setText(neighborhoodName);
        content.setText(contentName);

    }
}