package com.example.seniordesignproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class RateFragment extends Fragment {
    private Spinner spinnerCity;
    private TextView txtCity;
    private TextInputLayout textInputLayout;
    private AutoCompleteTextView dropdownText;
    private TextInputLayout subtextInputLayout;
    private AutoCompleteTextView subdropdownText;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rate,container,false);






    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textInputLayout = view.findViewById(R.id.input_layout);
        dropdownText = view.findViewById(R.id.dropdown_text);
        subtextInputLayout = view.findViewById(R.id.input_layoutsub);
        subdropdownText = view.findViewById(R.id.dropdown_textsub);


        List<String> banjaluka= new ArrayList<>();
        List<String> bihac= new ArrayList<>();
        List<String> cazin= new ArrayList<>();
        List<String> capljina= new ArrayList<>();
        List<String> doboj= new ArrayList<>();
        List<String> gorazde= new ArrayList<>();
        List<String> gracanica= new ArrayList<>();
        List<String> gradacac= new ArrayList<>();
        List<String> gradiska= new ArrayList<>();
        List<String> istocnoSarajevo= new ArrayList<>();
        List<String> livno = new ArrayList<>();
        List<String> ljubuski= new ArrayList<>();
        List<String> mostar= new ArrayList<>();
        List<String> prijedor= new ArrayList<>();
        List<String> sarajevo= new ArrayList<>();
        List<String> srebrenik= new ArrayList<>();
        List<String> sirokiBrijeg= new ArrayList<>();
        List<String> trebinje= new ArrayList<>();
        List<String> tuzla= new ArrayList<>();
        List<String> visoko= new ArrayList<>();
        List<String> zenica= new ArrayList<>();
        List<String> zvornik= new ArrayList<>();
        List<String> zivinice= new ArrayList<>();

        List<String> cities = new ArrayList<>();
        cities.add("Banja Luka");
        cities.add("Bihać");
        cities.add("Bijeljina");
        cities.add("Cazin");
        cities.add("Čapljina ");
        cities.add("Doboj ");
        cities.add("Goražde ");
        cities.add("Gračanica ");
        cities.add("Gradačac ");
        cities.add("Gradiška ");
        cities.add("Istočno Sarajevo ");
        cities.add("Livno  ");
        cities.add("Ljubuški ");
        cities.add("Mostar");
        cities.add("Prijedor");
        cities.add("Sarajevo");
        cities.add("Srebrenik");
        cities.add("Široki Brijeg");
        cities.add("Trebinje");
        cities.add("Tuzla");
        cities.add("Visoko");
        cities.add("Zenica");
        cities.add("Zvornik");
        cities.add("Živinice");
        ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(getActivity(), R.layout.dropdown_item,cities);
        ArrayAdapter<String> neighborhoodAdapter;

        banjaluka.add("Agino Selo");
        banjaluka.add("Barlovci");
        banjaluka.add("Bastasi");
        banjaluka.add("Bistrica");
        banjaluka.add("Bočac");
        banjaluka.add("Borik");
        banjaluka.add("Borkovići");
        banjaluka.add("Bronzani");
        banjaluka.add("Cerici");
        banjaluka.add("Čokori");
        banjaluka.add("Debeljaci");
        banjaluka.add("Dobrnja");
        banjaluka.add("Dragočaj");
        banjaluka.add("Drakulić");
        banjaluka.add("Dujakovci");
        banjaluka.add("Goleši");
        banjaluka.add("Gornji Šeher");
        banjaluka.add("Jagare");
        banjaluka.add("Kmećani");
        banjaluka.add("Kola");
        banjaluka.add("Kola Donja");
        banjaluka.add("Krmine");
        banjaluka.add("Krupa na Vrbasu");
        banjaluka.add("Kuljani");
        banjaluka.add("Lokvari");
        banjaluka.add("Lusići");
        banjaluka.add("Ljubačevo");
        banjaluka.add("Melina");
        banjaluka.add("Motike");
        banjaluka.add("");
        banjaluka.add("");
        banjaluka.add("");






        dropdownText.setAdapter(cityAdapter);


        //initialize your view here for use view.findViewById("your view id")
/*        spinnerCity = view.findViewById(R.id.city_dropdown);
        txtCity = view.findViewById(R.id.dropdown_text);

        List<String> cities = new ArrayList<>();
        cities.add("- Choose your city -");
        cities.add(" BANJA LUKA ");
        cities.add(" BIHAĆ ");
        cities.add(" BIJELJINA ");
        cities.add(" CAZIN ");
        cities.add(" ČAPLJINA ");
        cities.add(" DOBOJ ");
        cities.add(" GORAŽDE ");
        cities.add(" GRAČANICA ");
        cities.add(" GRADAČAC ");
        cities.add(" GRADIŠKA ");
        cities.add(" ISTOČNO SARAJEVO ");
        cities.add(" LIVNO ");
        cities.add(" LJUBUŠKI ");
        cities.add(" MOSTAR ");
        cities.add(" PRIJEDOR ");
        cities.add(" SARAJEVO ");
        cities.add(" SREBRENIK ");
        cities.add(" ŠIROKI BRIJEG ");
        cities.add(" TREBINJE");
        cities.add(" TUZLA ");
        cities.add(" VISOKO ");
        cities.add(" ZENICA ");
        cities.add(" ZVORNIK ");
        cities.add(" ŽIVINICE ");

        ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item,cities);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(cityAdapter);

        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String yourCity = spinnerCity.getSelectedItem().toString();
                if(!yourCity.equals("- Choose your city -")) {
                    txtCity.setText("You choose " + yourCity);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
         */

    }


}
