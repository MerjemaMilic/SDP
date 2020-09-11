package com.example.seniordesignproject.Categories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seniordesignproject.Model.Average;
import com.example.seniordesignproject.Model.Rate;
import com.example.seniordesignproject.NewRateActivity;
import com.example.seniordesignproject.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.List;

public class GrbavicaActivity extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore;

    private RecyclerView mFirestoreList;

    private FirestoreRecyclerAdapter adapter;
    List<Integer> list = new ArrayList<Integer>();
    FirebaseFirestore database;
    double numofreviews = 0;
    long numberRating = 0;

    DatabaseReference referenceNeighborhoods;
    DatabaseReference referenceRatings;
    DatabaseReference referenceRatingsgrb;
    List<Integer> listsafety = new ArrayList<Integer>();

    RatingBar safetyavg, sociabilityavg, pricingavg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grbavica);
        safetyavg = findViewById(R.id.safetyaverage);

       // Intent i = getIntent();
        //final long avgRate = i.getLongExtra("grbrating", 4);
        //Toast.makeText(GrbavicaActivity.this, avgRate + "",Toast.LENGTH_SHORT).show();
        firebaseFirestore = FirebaseFirestore.getInstance();
        mFirestoreList = findViewById(R.id.livnorecycler);
        referenceRatingsgrb = FirebaseDatabase.getInstance().getReference("ratings/Grbavica");

        referenceRatingsgrb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    long totalsafety = 0;
                    long totalpricing = 0;
                    long totalsociability = 0;

                    for(DataSnapshot ds : dataSnapshot.getChildren()) {
                        Average average = ds.getValue(Average.class);
                        Integer safetynow = Integer.valueOf(average.getSafetyrate());
                        Integer pricingnow = Integer.valueOf(average.getPricingrate());
                        Integer sociabilitynow = Integer.valueOf(average.getSociabilityrate());
                        totalsafety = totalsafety +  safetynow;
                        totalpricing +=  pricingnow;
                        totalsociability +=  sociabilitynow;
                        listsafety.add(average.getSafetyrate());
                        numberRating = totalsafety / listsafety.size();


                    }

                    Toast.makeText(GrbavicaActivity.this, "totalsafety" + totalsafety, Toast.LENGTH_LONG).show();
                    Toast.makeText(GrbavicaActivity.this, "totalsafety" + listsafety.size(), Toast.LENGTH_LONG).show();
                    Toast.makeText(GrbavicaActivity.this, "" + numberRating, Toast.LENGTH_LONG).show();
                    safetyavg.setRating(numberRating);






                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        Query query = firebaseFirestore.collection("reviews").whereEqualTo("neighborhood","Grbavica");

        FirestoreRecyclerOptions<Rate> options = new FirestoreRecyclerOptions.Builder<Rate>()
                .setQuery(query, Rate.class)
                .build();

        adapter = new FirestoreRecyclerAdapter<Rate, GrbavicaActivity.ProductsViewHolder>(options) {
            @NonNull
            @Override
            public GrbavicaActivity.ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view, parent, false);
                return new GrbavicaActivity.ProductsViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull GrbavicaActivity.ProductsViewHolder productsViewHolder, int i, @NonNull Rate rate) {
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