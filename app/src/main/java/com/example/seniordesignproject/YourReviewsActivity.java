package com.example.seniordesignproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.seniordesignproject.Model.Rate;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class YourReviewsActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    CustomAdapter adapter;

    FloatingActionButton mAddBtn;
    List<Rate> rateList = new ArrayList<>();

    FirebaseFirestore db;

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_reviews);

        db = FirebaseFirestore.getInstance();
        mRecyclerView = findViewById(R.id.recyclerviewlist);
        mAddBtn = findViewById(R.id.addBtn);
        mRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        pd = new ProgressDialog(this);
        showData();

        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(YourReviewsActivity.this, NewRateActivity.class));

            }
        });
    }

    private void showData() {

        pd.setTitle("Loading data...");
        pd.show();

        db.collection("reviews")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        rateList.clear();
                        pd.dismiss();

                        for (DocumentSnapshot doc : task.getResult()) {
                      //     int i = (int) doc.get("safety");
                      //     int j = (int) doc.get("sociability");
                      //     int k = (int) doc.get("pricing");//if the field is Integer
                            task.getResult();
                            Rate rate = new Rate(doc.getString("neighborhood"), doc.getString("content"), doc.getString("rate_id"), doc.getString("user_id" ));
                            rateList.add(rate);
                        }

                        adapter = new CustomAdapter(YourReviewsActivity.this, rateList);
                        mRecyclerView.setAdapter(adapter);

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(YourReviewsActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}