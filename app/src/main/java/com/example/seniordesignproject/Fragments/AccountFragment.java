package com.example.seniordesignproject.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seniordesignproject.MainActivity;
import com.example.seniordesignproject.ProfileActivity;
import com.example.seniordesignproject.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AccountFragment extends Fragment {
    TextView profileText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        Button button = (Button) view.findViewById(R.id.logout);
        ImageView profile = (ImageView) view.findViewById(R.id.profile_icon);
        profileText = view.findViewById(R.id.profile_text);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
            }
        });
        FirebaseAuth mFirebaseAuth;
        FirebaseAuth.AuthStateListener mAuthStateListener;
        final TextView username;
        username = view.findViewById(R.id.username_text);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String name = user.getEmail();
            username.setText(name);
            // User is signed in
        } else {
            // No user is signed in
        }

      //  Toast.makeText(getActivity(), currentFirebaseUser.getEmail(), Toast.LENGTH_SHORT).show();
        //username = currentFirebaseUser.getEmail();
        // (this, "" + currentFirebaseUser.getUid(), Toast.LENGTH_SHORT).show();

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FirebaseAuth.getInstance().signOut();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
            });
         
        profileText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        return view;

        }

    }
