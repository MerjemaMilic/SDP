package com.example.seniordesignproject.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.seniordesignproject.Categories.AlifakovacActivity;
import com.example.seniordesignproject.Categories.AlipasinMostActivity;
import com.example.seniordesignproject.Categories.AlipasinoPoljeActivity;
import com.example.seniordesignproject.Categories.AneksActivity;
import com.example.seniordesignproject.Categories.BascarsijaActivity;
import com.example.seniordesignproject.Categories.BetanijaActivity;
import com.example.seniordesignproject.Categories.BistrikActivity;
import com.example.seniordesignproject.Categories.CengicVilaActivity;
import com.example.seniordesignproject.Categories.DobrinjaActivity;
import com.example.seniordesignproject.Categories.DolacMaltaActivity;
import com.example.seniordesignproject.Categories.FerhadijaActivity;
import com.example.seniordesignproject.Categories.GrbavicaActivity;
import com.example.seniordesignproject.Categories.HrasnoActivity;
import com.example.seniordesignproject.Categories.HridJarcedoliActivity;
import com.example.seniordesignproject.Categories.KosevoActivity;
import com.example.seniordesignproject.Categories.KovaciActivity;
import com.example.seniordesignproject.Categories.KovaciciActivity;
import com.example.seniordesignproject.Categories.MarijinDvorActivity;
import com.example.seniordesignproject.Categories.MojmiloActivity;
import com.example.seniordesignproject.Categories.OtokaActivity;
import com.example.seniordesignproject.Categories.PofaliciActivity;
import com.example.seniordesignproject.Categories.SedrenikActivity;
import com.example.seniordesignproject.Categories.SkenderijaActivity;
import com.example.seniordesignproject.Categories.VracaActivity;
import com.example.seniordesignproject.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DsicoverFragment extends Fragment {
    TextView username;
    Button banjaluka,bihac,bijeljina,capljina,cazin,doboj,gorazde,gracanica,gradacac,gradiska,istocnosarajevo,livno,ljubuski,mostar,prijedor,sarajevo,srebrenik,sirokibrijeg,trebinje,tuzla,visoko,zvornik,zenica,zivinice;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);

        banjaluka = view.findViewById(R.id.banjalukabutton);
        bihac = view.findViewById(R.id.bihacbutton);
        bijeljina = view.findViewById(R.id.bijeljinabutton);
        capljina = view.findViewById(R.id.capljinabutton);
        cazin = view.findViewById(R.id.cazinbutton);
        cazin = view.findViewById(R.id.capljinabutton);
        doboj = view.findViewById(R.id.dobojbutton);
        gorazde = view.findViewById(R.id.gorazdebutton);
        gracanica = view.findViewById(R.id.gracanicabutton);
        gradacac = view.findViewById(R.id.gradacacbutton);
        gradiska = view.findViewById(R.id.gradiskabutton);
        istocnosarajevo = view.findViewById(R.id.istocnosarajevobutton);
        livno = view.findViewById(R.id.livnobutton);
        ljubuski = view.findViewById(R.id.ljubuskibutton);
        mostar = view.findViewById(R.id.mostar);
        prijedor = view.findViewById(R.id.prijedorbutton);
        sarajevo = view.findViewById(R.id.sarajevobutton);
        srebrenik = view.findViewById(R.id.srebrenikbutton);
        sirokibrijeg = view.findViewById(R.id.sirokibrijegbutton);
        trebinje = view.findViewById(R.id.trebinjebutton);
        tuzla = view.findViewById(R.id.tuzlabutton);
        visoko = view.findViewById(R.id.visokobutton);
        zenica = view.findViewById(R.id.zenicabutton);
        zvornik = view.findViewById(R.id.zvornikbutton);
        zivinice = view.findViewById(R.id.zivinicebutton);




        banjaluka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AlifakovacActivity.class);
                startActivity(intent);
            }
        });

        bihac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AlipasinMostActivity.class);
                startActivity(intent);
            }
        });

        bijeljina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AlipasinoPoljeActivity.class);
                startActivity(intent);
            }
        });

        cazin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BascarsijaActivity.class);
                startActivity(intent);
            }
        });

        capljina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AneksActivity.class);
                startActivity(intent);
            }
        });

        doboj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BetanijaActivity.class);
                startActivity(intent);
            }
        });

        gorazde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BistrikActivity.class);
                startActivity(intent);
            }
        });

        gracanica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CengicVilaActivity.class);
                startActivity(intent);
            }
        });

        gradacac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DobrinjaActivity.class);
                startActivity(intent);
            }
        });


        gradiska.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DolacMaltaActivity.class);
                startActivity(intent);
            }
        });

        istocnosarajevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FerhadijaActivity.class);
                startActivity(intent);
            }
        });

        livno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GrbavicaActivity.class);
                startActivity(intent);
            }
        });


        ljubuski.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HrasnoActivity.class);
                startActivity(intent);
            }
        });

        mostar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HridJarcedoliActivity.class);
                startActivity(intent);
            }
        });


        prijedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), KosevoActivity.class);
                startActivity(intent);
            }
        });

        sarajevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), KovaciActivity.class);
                startActivity(intent);
            }
        });

        srebrenik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MarijinDvorActivity.class);
                startActivity(intent);
            }
        });

        sirokibrijeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), KovaciciActivity.class);
                startActivity(intent);
            }
        });

        trebinje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MojmiloActivity.class);
                startActivity(intent);
            }
        });

        tuzla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OtokaActivity.class);
                startActivity(intent);
            }
        });

        visoko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PofaliciActivity.class);
                startActivity(intent);
            }
        });

        zenica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SedrenikActivity.class);
                startActivity(intent);
            }
        });

        zvornik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), VracaActivity.class);
                startActivity(intent);
            }
        });

        zivinice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SkenderijaActivity.class);
                startActivity(intent);
            }
        });

       // username = view.findViewById(R.id.username_discover);



          return view;
    }


    private void setUserInformation() {
        // username.setText(Common.currentUser);
    }
}
