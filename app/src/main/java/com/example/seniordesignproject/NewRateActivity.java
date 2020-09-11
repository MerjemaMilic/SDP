package com.example.seniordesignproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.seniordesignproject.Categories.AlifakovacActivity;
import com.example.seniordesignproject.Categories.GrbavicaActivity;
import com.example.seniordesignproject.Interface.IRateInterface;
import com.example.seniordesignproject.Model.Average;
import com.example.seniordesignproject.Model.Neighborhood;
import com.example.seniordesignproject.Model.Rate;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Query;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;


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
  int average = 0;
    int pricingRating;
    int total = 0;
    String cityitem;
    int sociabilityRating;
    int[] ratesaf;
    List<Integer> list = new ArrayList<Integer>();
    FirebaseFirestore database;
    double numofreviews = 0;
    long numberRating = 0;
    long totalsafety = 0;
    long totalpricing = 0;
    long totalsociability = 0;
    DatabaseReference referenceNeighborhoods;
    DatabaseReference referenceRatings;
    DatabaseReference referenceRatingsgrb;
    List<Integer> listsafety = new ArrayList<Integer>();







    String updateID, updateNeighborhood, updateContent;
    DatabaseReference reff,reff1;



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
        reff = FirebaseDatabase.getInstance().getReference().child("rate");
        reff1 = FirebaseDatabase.getInstance().getReference().child("neighborhoods").child("rate");
        String ratekey = reff.push().getKey();
        referenceNeighborhoods = FirebaseDatabase.getInstance().getReference("neighborhoods");




        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    numberRating = (dataSnapshot.getChildrenCount());

                for( DataSnapshot ds :dataSnapshot.getChildren()) {
                    Average average = ds.getValue(Average.class);
                    Integer safetynow = Integer.valueOf(average.getSafetyrate());
                    Integer pricingnow = Integer.valueOf(average.getPricingrate());
                    Integer sociabilitynow = Integer.valueOf(average.getSociabilityrate());
                    totalsafety +=  safetynow;
                    totalpricing +=  pricingnow;
                    totalsociability +=  sociabilitynow;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

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
                 switch((int) rating) {
                     case 0: {
                      average = 0;
                     }
                     case 1: {
                         average +=1;
                     }
                     case 2: {
                         average += 2;

                     }

                     case 3: {
                         average += 3;
                     }

                     case 4: {
                         average += 4;
                     }
                     case 5: {
                         average += 5;
                     }
                 }



            }
        });

        safetyRating1 = safety.getNumStars();
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




        DocumentReference rateref = database.collection("reviews").document();






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
                DocumentReference newRateRef = database.collection("reviews").document(userID);
                 Rate rate = new Rate();

                rate.setRate_id(newRateRef.getId());
                rate.setNeighborhood(neighborhood);
                rate.setContent(content);
                rate.setUser_id(userID);
                rate.setSafety(safetyR);
                rate.setPricing(pricingR);
                rate.setSociability(sociabilityR);
                addNeighborhood();
                  //addData();

                referenceRatingsgrb.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()) {

                            for(DataSnapshot ds : dataSnapshot.getChildren()) {
                                Average average = ds.getValue(Average.class);
                                Integer safetynow = Integer.valueOf(average.getSafetyrate());
                                Integer pricingnow = Integer.valueOf(average.getPricingrate());
                                Integer sociabilitynow = Integer.valueOf(average.getSociabilityrate());
                                totalsafety +=  safetynow;
                                totalpricing +=  pricingnow;
                                totalsociability +=  sociabilitynow;
                                listsafety.add(average.getSafetyrate());

                            }
                            Toast.makeText(NewRateActivity.this, "" + listsafety.size(), Toast.LENGTH_LONG).show();
                            numberRating = totalsafety / listsafety.size();
                            Toast.makeText(NewRateActivity.this, "" + numberRating, Toast.LENGTH_LONG).show();
                            Intent i = new Intent(NewRateActivity.this, GrbavicaActivity.class);
                            i.putExtra("grbrating", numberRating);
                            startActivity(i);





                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });







                newRateRef.set(rate).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            numofreviews += 1;
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












    }

    public void addData() {
     int safetyRating = (int) safety.getRating();
     int sociabilityRating = (int) sociability.getRating();
     int pricingRating = (int) pricing.getRating();
     String id = referenceRatings.push().getKey();
     String neighborhood = spinnerCity.getSelectedItem().toString();


        String averageRating;
     String totalRating;
     Average avg = new Average();
     Rate rating = new Rate();
     rating.setNeighborhood(neighborhood);
     avg.setSafetyrate(safetyRating);
     avg.setPricingrate(pricingRating);
     avg.setSociabilityrate(sociabilityRating);
     avg.setId(id);
     avg.setNumberrating((int) (numberRating+1));// this is number of reviews
        avg.setTotalsumsafety(totalsafety);
        avg.setTotalsumpricing(totalpricing);
        avg.setTotalsumsociability(totalsociability);
      //  avg.setAveragerate(totalsafety / numberRating);
      //  avg.setAveragepricingrate(totalpricing / numberRating);
      //  avg.setAveragesociabilityrate(totalsociability / numberRating);
        avg.setNeighborhoodname(neighborhood);
    //    referenceRatings.child(String.valueOf(numberRating+1)).setValue(avg);



        Toast.makeText(NewRateActivity.this, "Success rate", Toast.LENGTH_SHORT).show();
    // reff.child(String.valueOf(numberRating+1)).setValue(avg);
        // reff1.child(String.valueOf(numberRating+1)).setValue(avg);
       // reff1.setValue(rating);

        //DatabaseReference ref= FirebaseDatabase.getInstance().getReference("rate");
       // Query query=ref.orderByChild("neighborhoodname").equalTo("0");

       /* query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot datas: dataSnapshot.getChildren()){
                    String name=datas.child("averagesociabilityrate").getValue().toString();
                    Toast.makeText(NewRateActivity.this, name + "",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(NewRateActivity.this,   "FAIL",Toast.LENGTH_SHORT).show();

            }
        }); */


    }

    public void addNeighborhood() {
        String nameNeighborhood = cityitem;

        if(!TextUtils.isEmpty(nameNeighborhood)) {
            String neighborhoodid = referenceNeighborhoods.push().getKey();
            Neighborhood neighborhood = new Neighborhood();
            neighborhood.setNeighborhoodName(nameNeighborhood);
            neighborhood.setId(neighborhoodid);
            referenceNeighborhoods.child(nameNeighborhood).setValue(neighborhood);
            Toast.makeText(NewRateActivity.this, "Success", Toast.LENGTH_SHORT).show();
            referenceRatings = FirebaseDatabase.getInstance().getReference("ratings").child(nameNeighborhood);
            referenceRatingsgrb = FirebaseDatabase.getInstance().getReference("ratings/Grbavica");

            int safetyRating = (int) safety.getRating();
            int sociabilityRating = (int) sociability.getRating();
            int pricingRating = (int) pricing.getRating();
            String id = referenceRatings.push().getKey();
            final Average avg = new Average();
            avg.setSafetyrate(safetyRating);
            avg.setPricingrate(pricingRating);
            avg.setSociabilityrate(sociabilityRating);
            avg.setId(id);
           avg.setNumberrating(numberRating);// this is number of reviews
            avg.setTotalsumsafety(totalsafety);
            avg.setTotalsumpricing(totalpricing);
            avg.setTotalsumsociability(totalsociability);
            referenceRatings.child(id).setValue(avg);




        }
        else {
            Toast.makeText(NewRateActivity.this, "Please choose a neighborhood", Toast.LENGTH_SHORT).show();
        }
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
        rate.setAvgsafetyRating(safety);





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
