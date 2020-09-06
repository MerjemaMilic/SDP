package com.example.seniordesignproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class RateDetails extends AppCompatActivity {
    TextView neighborhood, content,  userdetails;
    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_details);
        db = FirebaseFirestore.getInstance();


        neighborhood = findViewById(R.id.rateneighborhooddetail);
        content = findViewById(R.id.ratecontentdetails);
        //userdetails = findViewById(R.id.userratedetails);




        Intent i = getIntent();
        final String neighborhoodName = i.getStringExtra("content");
        final String contentName = i.getStringExtra("neighborhood");
        final Bundle bundle = getIntent().getExtras();

        neighborhood.setText(neighborhoodName);
        content.setText(contentName);


    }
}