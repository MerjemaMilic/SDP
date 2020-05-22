package com.example.seniordesignproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignIn extends AppCompatActivity {
     Button register,login;
     EditText email, password;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mFirebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email_rinput);
        password = findViewById(R.id.password_input);
        login = findViewById(R.id.login_button);
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();

                if( mFirebaseUser != null) {
                    Toast.makeText(SignIn.this, "You are logged in", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SignIn.this,HomeActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(SignIn.this, "Please login", Toast.LENGTH_SHORT).show();

                }
            }
        };
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String femail = email.getText().toString();
                String fpassword = password.getText().toString();
                if(femail.isEmpty()) {
                    email.setError("Please enter username");
                    email.requestFocus();
                }
                else if(fpassword.isEmpty()) {
                    password.setError("Please enter password");
                    password.requestFocus();
                }
                else if(femail.isEmpty() && fpassword.isEmpty()) {
                    Toast.makeText(SignIn.this, "Fields are emplty", Toast.LENGTH_SHORT).show();
                }
                else if(!(femail.isEmpty() && fpassword.isEmpty())) {
                    mFirebaseAuth.signInWithEmailAndPassword(femail, fpassword).addOnCompleteListener(SignIn.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(SignIn.this, "Login Error, please login again", Toast.LENGTH_SHORT).show();

                            } else {
                                Intent intToHome = new Intent(SignIn.this, HomeActivity.class);
                                startActivity(intToHome);
                            }
                        }


                    });
                }

                else{
                    Toast.makeText(SignIn.this, "Error occured!", Toast.LENGTH_SHORT).show();

                }
                if(femail.equals("admin@gmail.com")) {
                    if(fpassword.equals("admin123")) {
                        Intent inttoAdmin = new Intent(SignIn.this, AdminActivity.class);
                        startActivity(inttoAdmin);
                    }
                }
            }
        });
        register = findViewById(R.id.register_button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignIn.this, RegisterActivity.class);
                startActivity(i);
            }
        });


    }
    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }





}
