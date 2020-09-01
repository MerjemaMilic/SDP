package com.example.seniordesignproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    FirebaseAuth mFirebaseAuth;
    private Button register;
    private TextInputLayout email, password, firstName, address;
    FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mFirebaseAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        email = findViewById(R.id.email_rinput);
        password = findViewById(R.id.password_rinput);
        register = findViewById(R.id.register_confirm);
        firstName = findViewById(R.id.name_rinput);
        address = findViewById(R.id.address_rinput);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final String femail = email.getEditText().getText().toString();
                final String fpassword = password.getEditText().getText().toString();
                final String ffirstName = firstName.getEditText().getText().toString();
                final String faddress = address.getEditText().getText().toString();

                if(femail.isEmpty()) {
                    email.setError("Please enter username");
                    email.requestFocus();
                }
                else if(fpassword.isEmpty()) {
                    password.setError("Please enter password");
                    password.requestFocus();
                }
               else if(!(isValidEmail(femail))) {
                    email.setError("Please try again with a valid e-mail");
                }
               else if(!(isStrong(fpassword))) {
                   password.setError("Your password must contain at least one digit, one lower case letter, one upper case letter, a special character and consist of minimum 9 characters");
                }
                else if(femail.isEmpty() && fpassword.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }
            //    else if(!(femail.isEmpty() && fpassword.isEmpty())) {
                else if(isValidEmail(femail) && fpassword.length() > 8) {
                        mFirebaseAuth.createUserWithEmailAndPassword(femail,fpassword).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "created", Toast.LENGTH_SHORT).show();
                                userID = mFirebaseAuth.getCurrentUser().getUid();
                                DocumentReference documentReference = fStore.collection("users").document(userID);
                                Map<String, Object> user = new HashMap<>();
                                user.put("firstName", ffirstName);
                                user.put("email", femail);
                                user.put("postal_address", faddress);
                                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d("TAG", "USER is created for" + userID);
                                    }
                                });
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

    public static boolean isValidEmail(CharSequence t) {
        return (!TextUtils.isEmpty(t) && Patterns.EMAIL_ADDRESS.matcher(t).matches());
    }

    private boolean isStrong(String password){
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");

        /*


        ^                 # start-of-string
(?=.*[0-9])       # a digit must occur at least once
(?=.*[a-z])       # a lower case letter must occur at least once
(?=.*[A-Z])       # an upper case letter must occur at least once
(?=.*[@#$%^&+=])  # a special character must occur at least once
(?=\S+$)          # no whitespace allowed in the entire string
.{8,}             # anything, at least eight places though
$                 # end-of-string

         */

    }
}

