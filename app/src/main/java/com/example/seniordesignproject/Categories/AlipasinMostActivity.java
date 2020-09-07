package com.example.seniordesignproject.Categories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.seniordesignproject.Model.Rate;
import com.example.seniordesignproject.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class AlipasinMostActivity extends AppCompatActivity {

    private FirebaseFirestore firebaseFirestore;

    private RecyclerView mFirestoreList;

    private FirestoreRecyclerAdapter adapter;

    RatingBar safetyavg,sociabilityavg,pricingavg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alipasin_most);
        firebaseFirestore = FirebaseFirestore.getInstance();
        mFirestoreList = findViewById(R.id.bihacrecycler);
        safetyavg = findViewById(R.id.safetyaverage);
        sociabilityavg = findViewById(R.id.sociabilityaverage);
        pricingavg = findViewById(R.id.pricingaverage);


        safetyavg.setRating(4);
        sociabilityavg.setRating(2);
        pricingavg.setRating(3);
        Query query = firebaseFirestore.collection("reviews").whereEqualTo("neighborhood","Alipasin Most");

        FirestoreRecyclerOptions<Rate> options = new FirestoreRecyclerOptions.Builder<Rate>()
                .setQuery(query, Rate.class)
                .build();

        adapter = new FirestoreRecyclerAdapter<Rate, AlipasinMostActivity.ProductsViewHolder>(options) {
            @NonNull
            @Override
            public AlipasinMostActivity.ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view, parent, false);
                return new AlipasinMostActivity.ProductsViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull AlipasinMostActivity.ProductsViewHolder productsViewHolder, int i, @NonNull Rate rate) {
                productsViewHolder.list_neighborhood.setText(rate.getNeighborhood());
                productsViewHolder.list_content.setText(rate.getContent());

            }
        };
        mFirestoreList.setLayoutManager(new LinearLayoutManager(this));
        mFirestoreList.setAdapter(adapter);
    }

    private class ProductsViewHolder extends RecyclerView.ViewHolder{
        private TextView list_neighborhood;
        private TextView list_content;


        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);

            list_neighborhood = itemView.findViewById(R.id.neighborhood_name);
            list_content = itemView.findViewById(R.id.review_content);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
    }