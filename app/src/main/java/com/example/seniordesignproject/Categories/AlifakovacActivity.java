package com.example.seniordesignproject.Categories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seniordesignproject.Model.Rate;
import com.example.seniordesignproject.R;
import com.example.seniordesignproject.RateDetails;
import com.example.seniordesignproject.RateDetails2;
import com.example.seniordesignproject.ViewHolder;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class AlifakovacActivity extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore;

    private RecyclerView mFirestoreList;

    TextView avg;

    RatingBar safetyavg, sociabilityavg, pricingavg;

    private FirestoreRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_alifakovac);
         firebaseFirestore = FirebaseFirestore.getInstance();
         mFirestoreList = findViewById(R.id.alifakovacrecycler);
         avg = findViewById(R.id.avg);
        safetyavg = findViewById(R.id.safetyaverage);
        sociabilityavg = findViewById(R.id.sociabilityaverage);
        pricingavg = findViewById(R.id.pricingaverage);


        safetyavg.setRating(4);
        sociabilityavg.setRating(2);
        pricingavg.setRating(3);




        DocumentReference docRef = firebaseFirestore.collection("reviews").document("Alifakovac");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d("TAG", "DocumentSnapshot data: " + document.getData());
                    } else {
                        Log.d("TAG", "No such document");
                    }
                } else {
                    Log.d("TAG", "get failed with ", task.getException());
                }
            }
        });
/*

        Task<QuerySnapshot> query1 = firebaseFirestore.collection("reviews").whereGreaterThan("safety","0").whereEqualTo("neighborhood","Alifakovac").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                int data = 0;

                for(QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    Rate rate = documentSnapshot.toObject(Rate.class);
                  data = rate.getSafety();

                }

           //     avg.setText(data);
                Toast.makeText(AlifakovacActivity.this, data,Toast.LENGTH_SHORT).show();



            }
        });

        */


        Query query1 = firebaseFirestore.collection("reviews").whereGreaterThan("safety","0").whereEqualTo("neighborhood", "Alifakovac");

       query1.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
           @Override
           public void onComplete(@NonNull Task<QuerySnapshot> task) {
          if(task.isSuccessful()) {

          }
            }
       });




        Query query = firebaseFirestore.collection("reviews").whereEqualTo("neighborhood","Alifakovac");

        FirestoreRecyclerOptions<Rate> options = new FirestoreRecyclerOptions.Builder<Rate>()
                .setQuery(query, Rate.class)
                .build();

         adapter = new FirestoreRecyclerAdapter<Rate, ProductsViewHolder>(options) {
            @NonNull
            @Override
            public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view, parent, false);





                return new ProductsViewHolder(view);


            }

            @Override
            protected void onBindViewHolder(@NonNull ProductsViewHolder productsViewHolder, int i, @NonNull Rate rate) {
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

                    Intent i = new Intent (itemView.getContext(), RateDetails2.class);
                    i.putExtra("neighborhood",list_neighborhood.getText().toString());
                    i.putExtra("content",list_content.getText().toString());

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