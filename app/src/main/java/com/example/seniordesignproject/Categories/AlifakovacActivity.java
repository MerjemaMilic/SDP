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

import com.example.seniordesignproject.Model.Konverzija;
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
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.common.collect.Lists;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collections;
import com.google.android.gms.tasks.Task;

import static com.google.api.client.util.Lists.newArrayList;

public class AlifakovacActivity extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore;

    private RecyclerView mFirestoreList;

    TextView avg;

    RatingBar safetyavg, sociabilityavg, pricingavg;

    private FirestoreRecyclerAdapter adapter;

    URL urlObj;
    HttpURLConnection urlConnection;
    String TOKEN;

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

        try{
            InputStream is = getResources().openRawResource(R.raw.secret);
            GoogleCredential credentials = GoogleCredential.fromStream(is).createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
            credentials.refreshToken();
            Toast.makeText(AlifakovacActivity.this, "test" + credentials, Toast.LENGTH_SHORT).show();
            TOKEN = credentials.getAccessToken();
            Log.d("TOKEN", TOKEN);
            try{
            String urlPitanja = "https://firestore.googleapis.com/v1/projects/SeniorDesignProject/databases/(default)/documents/reviews?access_token=";
            urlObj = new URL(urlPitanja + URLEncoder.encode(TOKEN, "UTF-8"));
            urlConnection = (HttpURLConnection) urlObj.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Accept", "application/json");
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                Toast.makeText(AlifakovacActivity.this, "test", Toast.LENGTH_SHORT).show();
                String rezultat = Konverzija.convertStreamToString(in);
            Log.d("dokumenti",rezultat);
            Toast.makeText(AlifakovacActivity.this, "" + rezultat, Toast.LENGTH_SHORT).show();
            JSONObject jo = new JSONObject(rezultat);

            JSONArray documents = jo.getJSONArray("documents");
            }
            catch(Exception e){

                Toast.makeText(AlifakovacActivity.this, "2" + e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }
        catch(Exception e){

            Toast.makeText(AlifakovacActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();

        }


        safetyavg.setRating(3);
        sociabilityavg.setRating(2);
        pricingavg.setRating(4);




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