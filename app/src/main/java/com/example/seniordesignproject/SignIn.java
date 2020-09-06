package com.example.seniordesignproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignIn extends AppCompatActivity {
     Button register,login;
     private TextInputLayout email, password;
    FirebaseAuth mFirebaseAuth;
    private TextView forgotpassword;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mFirebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email_rinputlayout);
        password = findViewById(R.id.password_inputlayout);
        login = findViewById(R.id.login_button);
        forgotpassword = findViewById(R.id.forgotpassword);
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
                final String femail = email.getEditText().getText().toString();
                String fpassword = password.getEditText().getText().toString();
                if(femail.isEmpty()) {
                    email.setError("Please enter e-mail");
                    email.requestFocus();
                }
                 if(fpassword.isEmpty()) {
                    password.setError("Please enter password");
                    password.requestFocus();
                }
                else if(femail.isEmpty() && fpassword.isEmpty()) {
                    email.setError("Field is empty");
                    password.setError("Field is empty");
                }
                else if(femail.length() < 3 && femail.length() > 0) {
                    email.setError("E-mail too short");
                }
                 else if(femail.length() > 320 ) {
                    email.setError("E-mail too long");
                }

                else if(fpassword.length() < 5 && femail.length() > 0) {
                    password.setError("Password too short");
                }
                 else if(fpassword.length() > 320 ) {
                    password.setError("Password too long");
                }

                else if(!(femail.isEmpty() && fpassword.isEmpty())) {
                    mFirebaseAuth.signInWithEmailAndPassword(femail, fpassword).addOnCompleteListener(SignIn.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(SignIn.this, "Login Error, please login again", Toast.LENGTH_SHORT).show();

                            } else {
                                email.setError(null);
                                Intent intToHome = new Intent(SignIn.this, HomeActivity.class);
                                startActivity(intToHome);
                            }
                        }


                    });
                }

                else{
                    Toast.makeText(SignIn.this, "Error occured!", Toast.LENGTH_SHORT).show();

                }
                if(femail.equals("admin@admin.com")) {
                    if(fpassword.equals("admin123")) {
                        Intent inttoAdmin = new Intent(SignIn.this, AdminActivity.class);
                        startActivity(inttoAdmin);
                    }
                }

            }
        });



        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           final EditText resetMail = new EditText(v.getContext());
            Context context;
            AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
            passwordResetDialog.setMessage("Enter your e-mail to receive the password reset link");
            passwordResetDialog.setView(resetMail);
            passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                 String mail = resetMail.getText().toString();
                 mFirebaseAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                     @Override
                     public void onSuccess(Void aVoid) {
                         Toast.makeText(SignIn.this,"Reset link sent to your mail", Toast.LENGTH_SHORT).show();
                     }
                 }).addOnFailureListener(new OnFailureListener() {
                     @Override
                     public void onFailure(@NonNull Exception e) {
                         Toast.makeText(SignIn.this,"Error occured. Reset link has not been sent." + e.getMessage(),Toast.LENGTH_SHORT).show();
                     }
                 });
                }
            });

            passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // close the dialog
                }
            });

            passwordResetDialog.create().show();
            }
        });


    }
    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }






}
