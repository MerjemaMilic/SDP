package com.example.seniordesignproject.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.seniordesignproject.R;
import com.example.seniordesignproject.Service.PicassoImageLoadingService;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import ss.com.bannerslider.Slider;

public class DsicoverFragment extends Fragment {
    TextView username;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);


        Slider.init(new PicassoImageLoadingService());

        username = view.findViewById(R.id.username_discover);



          return view;
    }


    private void setUserInformation() {
        // username.setText(Common.currentUser);
    }
}
