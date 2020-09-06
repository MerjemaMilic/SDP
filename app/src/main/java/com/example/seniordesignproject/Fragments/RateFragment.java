package com.example.seniordesignproject.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seniordesignproject.HomeActivity;
import com.example.seniordesignproject.Interface.IRateInterface;
import com.example.seniordesignproject.MainActivity;
import com.example.seniordesignproject.NewRateActivity;
import com.example.seniordesignproject.ProfileActivity;
import com.example.seniordesignproject.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class RateFragment extends Fragment implements IRateInterface {
    private Spinner spinnerCity;
    FloatingActionButton addrate;
    Button test;
    private TextView txtCity;
    private TextInputLayout textInputLayout;
    private AutoCompleteTextView dropdownText;
    private TextInputLayout subtextInputLayout;
    private AutoCompleteTextView subdropdownText;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    private ArrayAdapter<String> neighborhoodAdapter;
    private List<String> banjaluka, bihac, cazin;
    private Spinner neighborhoodSpinner;
    View parentLayout;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragment_rate, container, false);
       firebaseAuth = FirebaseAuth.getInstance();
       user = firebaseAuth.getCurrentUser();
       FloatingActionButton addrate = (FloatingActionButton) view.findViewById(R.id.addratebutton);

       addrate.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intToHome = new Intent(getActivity(), NewRateActivity.class);
              startActivity(intToHome);
          }
       });

        return view;






    }


    @Override
    public void createNewRate(String city, String neighborhood, String content) {

    }
}
