package com.example.seniordesignproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seniordesignproject.Fragments.AccountFragment;
import com.example.seniordesignproject.Model.Feedback;
import com.example.seniordesignproject.Model.Rate;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class SubmitFeedbackActivity extends AppCompatActivity {

    TextView usernamesubmit;
    FirebaseAuth mFirebaseAuth;
    FirebaseFirestore fStore;
    String userID;
    FirebaseUser user;
    Button back,submit;
    TextInputLayout opinion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_submit_feedback);
        usernamesubmit = findViewById(R.id.profilenamesubmitfeedback);
        back = findViewById(R.id.backtomainfeedbackbutton);
        opinion = findViewById(R.id.formopinion);
        mFirebaseAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = mFirebaseAuth.getCurrentUser();
        userID = mFirebaseAuth.getCurrentUser().getUid();
        submit = findViewById(R.id.submitform);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String formopinion = opinion.getEditText().getText().toString();


                FirebaseFirestore db = FirebaseFirestore.getInstance();

                DocumentReference newFeedbackref = db.collection("feedback").document();
                String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                Feedback feedback = new Feedback();
                feedback.setOpinion(formopinion);
                feedback.setOpinionid(newFeedbackref.getId());


                newFeedbackref.set(feedback).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(SubmitFeedbackActivity.this,"Thank you for your feedback!",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SubmitFeedbackActivity.this,HomeActivity.class);
                            startActivity(intent);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SubmitFeedbackActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubmitFeedbackActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        FirebaseAuth.AuthStateListener mAuthStateListener;
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            DocumentReference documentReference = fStore.collection("users").document(userID);
            documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {

                    usernamesubmit.setText(value.getString("firstName"));

                }
            });
            // User is signed in
        } else {
            // No user is signed in
        }

    }


}