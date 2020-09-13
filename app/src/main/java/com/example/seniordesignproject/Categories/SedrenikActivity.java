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

import com.example.seniordesignproject.Model.Average;
import com.example.seniordesignproject.Model.Rate;
import com.example.seniordesignproject.R;
import com.example.seniordesignproject.RateDetails2;
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

public class SedrenikActivity extends AppCompatActivity {

    private FirebaseFirestore firebaseFirestore;
    private RecyclerView mFirestoreList;
    private FirestoreRecyclerAdapter adapter;

    RatingBar safetyavg, sociabilityavg, pricingavg;

    DatabaseReference referenceRatingsedrenik;

    List<Integer> list = new ArrayList<Integer>();
    List<Integer> listsafety = new ArrayList<Integer>();
    List<Integer> listpricing = new ArrayList<Integer>();
    List<Integer> listsociability = new ArrayList<Integer>();

    double numofreviews = 0;
    float numberRating = (float) 0.0;
    float pricingnumberRating = (float) 0.0;
    float sociabilitynumberRating = (float) 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sedrenik);
        firebaseFirestore = FirebaseFirestore.getInstance();
        mFirestoreList = findViewById(R.id.zenicarecycler);

        safetyavg = findViewById(R.id.safetyaverage);
        sociabilityavg = findViewById(R.id.sociabilityaverage);
        pricingavg = findViewById(R.id.pricingaverage);

        referenceRatingsedrenik = FirebaseDatabase.getInstance().getReference("ratings/Sedrenik");

        referenceRatingsedrenik.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    float totalsafety = 0;
                    float totalpricing = 0;
                    float totalsociability = 0;

                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        Average average = ds.getValue(Average.class);

                        float safetynow = average.getSafetyrate();
                        float pricingnow = average.getPricingrate();
                        float sociabilitynow = average.getSociabilityrate();

                        // calculating sum
                        totalsafety = totalsafety + safetynow;
                        totalpricing = totalpricing + pricingnow;
                        totalsociability = totalsociability + sociabilitynow;


                        //adding individual rating integers to lists
                        listsafety.add(average.getSafetyrate());
                        listpricing.add(average.getPricingrate());
                        listsociability.add(average.getSociabilityrate());


                        //calculating averages
                        pricingnumberRating = totalpricing / listpricing.size();
                        numberRating = totalsafety / listsafety.size();
                        sociabilitynumberRating = totalsociability / listsociability.size();


                    }

                    //    Toast.makeText(AlifakovacActivity.this, "totalsafety" + totalsafety, Toast.LENGTH_LONG).show();
                    //    Toast.makeText(AlifakovacActivity.this, "totalsafety" + listsafety.size(), Toast.LENGTH_LONG).show();
                    //    Toast.makeText(AlifakovacActivity.this, "" + numberRating, Toast.LENGTH_LONG).show();

                    safetyavg.setRating(numberRating);
                    pricingavg.setRating(pricingnumberRating);
                    sociabilityavg.setRating(sociabilitynumberRating);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Query query = firebaseFirestore.collection("reviews").whereEqualTo("neighborhood","Sedrenik");

        FirestoreRecyclerOptions<Rate> options = new FirestoreRecyclerOptions.Builder<Rate>()
                .setQuery(query, Rate.class)
                .build();

        adapter = new FirestoreRecyclerAdapter<Rate, SedrenikActivity.ProductsViewHolder>(options) {
            @NonNull
            @Override
            public SedrenikActivity.ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view, parent, false);
                return new SedrenikActivity.ProductsViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull SedrenikActivity.ProductsViewHolder productsViewHolder, int i, @NonNull Rate rate) {
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


        public ProductsViewHolder(@NonNull final View itemView) {
            super(itemView);

            list_neighborhood = itemView.findViewById(R.id.neighborhood_name);
            list_content = itemView.findViewById(R.id.review_content);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(itemView.getContext(), RateDetails2.class);
                    i.putExtra("neighborhood", list_neighborhood.getText().toString());
                    i.putExtra("content", list_content.getText().toString());

                    itemView.getContext().startActivity(i);

                }
            });
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