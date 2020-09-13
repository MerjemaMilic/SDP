package com.example.seniordesignproject;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seniordesignproject.Model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity {
    private TextInputLayout firstName, address;

    private Button update, back;
    private TextInputEditText nameedit, addressedit, emailedit;

    TextView username, nameupper;
    FirebaseAuth mFirebaseAuth;
    FirebaseFirestore fStore;
    String userID;
    FirebaseUser user;


    CollectionReference userReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        username = findViewById(R.id.profileemailtext);

        nameupper = findViewById(R.id.profilenametextupper);
        firstName = findViewById(R.id.profile_nametext);
        address = findViewById(R.id.profileaddresstext);
        update = findViewById(R.id.update);
        addressedit = findViewById(R.id.profileaddressedit);
        nameedit = findViewById(R.id.profile_nameedit);
        emailedit = findViewById(R.id.profile_emailedit);
        back = findViewById(R.id.back);

        mFirebaseAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = mFirebaseAuth.getCurrentUser();

        userID = mFirebaseAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                addressedit.setText(value.getString("postal_address"));
                nameedit.setText(value.getString("firstName"));
                nameupper.setText(value.getString("firstName"));
                emailedit.setText(value.getString("email"));

            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameedit.getText().toString().isEmpty() || addressedit.getText().toString().isEmpty()) {
                    Toast.makeText(ProfileActivity.this, "One or many fields are empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                final String email1 = emailedit.getText().toString();
                String username1 = username.getText().toString();
                user.updateEmail(email1).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        DocumentReference docRef = fStore.collection("users").document(user.getUid());
                        Map<String, Object> edited = new HashMap<>();
                        edited.put("email", email1);
                        edited.put("firstName", nameedit.getText().toString());
                        edited.put("postal_address", addressedit.getText().toString());
                        docRef.update(edited).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                                finish();
                            }
                        });
                        Toast.makeText(ProfileActivity.this, "Update successful", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ProfileActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToHome = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(intToHome);
            }
        });


        FirebaseAuth.AuthStateListener mAuthStateListener;
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String name = user.getEmail();
            username.setText(name);

            // User is signed in
        } else {
            // No user is signed in
        }


    }
}
