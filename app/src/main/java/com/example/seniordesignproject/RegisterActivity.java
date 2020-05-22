package com.example.seniordesignproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    FirebaseAuth mFirebaseAuth;
    private Button register;
    private EditText email, password, firstName, lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mFirebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email_rinput);
        password = findViewById(R.id.password_rinput);
        register = findViewById(R.id.register_confirm);
        register.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(RegisterActivity.this, "Fields are emplty", Toast.LENGTH_SHORT).show();
                }
                else if(!(femail.isEmpty() && fpassword.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(femail,fpassword).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "Sign in unsuccessful, Please try again", Toast.LENGTH_SHORT).show();

                            } else {
                                startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                            }

                        }
                    });
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Error occured!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}

