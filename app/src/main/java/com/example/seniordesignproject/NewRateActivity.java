package com.example.seniordesignproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.seniordesignproject.Categories.AlifakovacActivity;
import com.example.seniordesignproject.Interface.IRateInterface;
import com.example.seniordesignproject.Model.Rate;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static android.util.Log.i;

public class NewRateActivity extends AppCompatActivity {
    private TextInputLayout mcity, mneighborhood, mcontent;
    private Button submit, back;
    private Spinner spinnerCity;
    private IRateInterface mInterface;
    RatingBar safety, pricing,sociability;
    int safetyRating;
    int safetyRating1;
  int average;
    int pricingRating;
    int total = 0;
    String cityitem;
    int sociabilityRating;
    int[] ratesaf;
    List<Integer> list = new ArrayList<Integer>();
    FirebaseFirestore database;

    String updateID, updateNeighborhood, updateContent;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_rate);
        spinnerCity = findViewById(R.id.cityedit);
//        mneighborhood = findViewById(R.id.neighborhood);
        mcontent = findViewById(R.id.content);
        submit = findViewById(R.id.submitreview);
        safety = findViewById(R.id.safety_rating_bar);
        sociability = findViewById(R.id.sociability_rating_bar);
        pricing = findViewById(R.id.pricing_rating_bar);
        back = findViewById(R.id.backfromnewratebutton);
        database = FirebaseFirestore.getInstance();

       back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(NewRateActivity.this,HomeActivity.class);
               startActivity(intent);
           }
       });

        final List<String> neighborhoods = new ArrayList<>();
        neighborhoods.add("Choose a neighborhood");
        neighborhoods.add("Alifakovac");
        neighborhoods.add("Alipasin Most");
        neighborhoods.add("Alipasino Polje");
        neighborhoods.add("Aneks");
        neighborhoods.add("Bascarsija");
        neighborhoods.add("Betanija");
        neighborhoods.add("Bistrik ");
        neighborhoods.add("Cengic Vila ");
        neighborhoods.add("Dobrinja");
        neighborhoods.add("Dolac Malta");
        neighborhoods.add("Ferhadija");
        neighborhoods.add("Grbavica");
        neighborhoods.add("Hrasno");
        neighborhoods.add("Hrid-Jarčedoli");
        neighborhoods.add("Koševo");
        neighborhoods.add("Kovači");
        neighborhoods.add("Kovačići");
        neighborhoods.add("Marijin Dvor");
        neighborhoods.add("Mojmilo");
        neighborhoods.add("Otoka");
        neighborhoods.add("Pofalići");
        neighborhoods.add("Sedrenik");
        neighborhoods.add("Skenderija");
        neighborhoods.add("Vraca");
        final ArrayAdapter<String> neighborhoodAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,neighborhoods);
        neighborhoodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(neighborhoodAdapter);

       spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cityitem = spinnerCity.getSelectedItem().toString();

           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });


        safety.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                 safetyRating = (int) ratingBar.getRating();
             /*   for (int i = 0; i < list.size(); ++i){
                    safetyRating1 = (int) ratingBar.getNumStars();
                    list.add(safetyRating1);
                } */



            }
        });

        safetyRating1 = safety.getNumStars();
        for(int i = 0; i < list.size(); i++)
        list.add(safetyRating1);



       // Toast.makeText(NewRateActivity.this, "" + list.size(),Toast.LENGTH_SHORT).show();

     //   ratesaf[0] = safetyRating;


        sociability.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                sociabilityRating = (int) ratingBar.getRating();

            }
        });



        pricing.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                pricingRating = (int) ratingBar.getNumStars();

            }
        });




        database.collection("reviews")
                .whereEqualTo("safety", true)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Toast.makeText(NewRateActivity.this, "" + document.getData(), Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(NewRateActivity.this,"Message",Toast.LENGTH_SHORT).show();
                        }
                    }
                });






        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String neighborhood = cityitem;
           //     String neighborhood = mneighborhood.getEditText().getText().toString();
                String content = mcontent.getEditText().getText().toString();
                int safetyR = safetyRating;
                int sociabilityR = sociabilityRating;
                int pricingR = pricingRating;

                FirebaseFirestore db = FirebaseFirestore.getInstance();
                String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                DocumentReference newRateRef = database.collection("reviews").document();
                 Rate rate = new Rate();

                rate.setRate_id(newRateRef.getId());
                rate.setNeighborhood(neighborhood);
                rate.setContent(content);
                rate.setUser_id(userID);
                rate.setSafety(safetyR);
                rate.setPricing(pricingR);
                rate.setSociability(sociabilityR);





                newRateRef.set(rate).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(NewRateActivity.this,"Your review has been published",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(NewRateActivity.this,HomeActivity.class);
                            startActivity(intent);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(NewRateActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });
               // uploadData(neighborhood,content,safetyR,sociabilityR,pricingR);

            }
        });





        Toast.makeText(NewRateActivity.this, total + "" + list.size(),Toast.LENGTH_SHORT).show();







    }

    public void uploadData(String neighborhood, String content, int safety, int pricing, int sociability) {
        DocumentReference newRateRef = database.collection("reviews").document();
        String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Rate rate = new Rate();

        rate.setRate_id(newRateRef.getId());
        rate.setNeighborhood(neighborhood);
        rate.setContent(content);
        rate.setUser_id(userID);
        rate.setSafety(safety);
        rate.setPricing(pricing);
        rate.setSociability(sociability);



        newRateRef.set(rate).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(NewRateActivity.this,"Your review has been published",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(NewRateActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(NewRateActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

}
