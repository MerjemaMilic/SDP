package com.example.seniordesignproject.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seniordesignproject.R;
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

    private ArrayAdapter<String> neighborhoodAdapter;
    private List<String> banjaluka, bihac, cazin;
    private Spinner neighborhoodSpinner;




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
        spinnerCity = view.findViewById(R.id.cityspin);



        final List<String> banjaluka= new ArrayList<>();
        final List<String> bihac= new ArrayList<>();
        final List<String> cazin= new ArrayList<>();
        final List<String> capljina= new ArrayList<>();
        final List<String> doboj= new ArrayList<>();
       final List<String> gorazde= new ArrayList<>();
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
        final List<String> zivinice= new ArrayList<>();


      final List<String> cities = new ArrayList<>();
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

      //  final ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(getActivity(), R.layout.dropdown_item,cities);
        // dropdownText.setAdapter(cityAdapter);
     final ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item,cities);
     cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
     spinnerCity.setAdapter(cityAdapter);




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
        banjaluka.add("Obilićevo");
        banjaluka.add("Obrovac");
        banjaluka.add("Pavići");
        banjaluka.add("Pavlovac");
        banjaluka.add("Pervan Donji");
        banjaluka.add("Pervan Gornji");
        banjaluka.add("Piskavica");
        banjaluka.add("Ponir");
        banjaluka.add("Potkozarje");
        banjaluka.add("Prljakovci");
        banjaluka.add("Priječani");
        banjaluka.add("Prnjavor Mali");
        banjaluka.add("Radmanići");
        banjaluka.add("Radosavska");
        banjaluka.add("Ramići");
        banjaluka.add("Rekavice");
        banjaluka.add("Slavićka");
        banjaluka.add("Starčevica");
        banjaluka.add("Stratinska");
        banjaluka.add("Stričići");
        banjaluka.add("Stupnica");
        banjaluka.add("Subotica");
        banjaluka.add("Šargovac");
        banjaluka.add("Šimići");
        banjaluka.add("Šljivno");
        banjaluka.add("Verići");
        banjaluka.add("Vilusi");
        banjaluka.add("Vrbanja");
        banjaluka.add("Zalužani");
        banjaluka.add("Zelenci");

        bihac.add("Bajrići");
        bihac.add("Brekovica");
        bihac.add("Bugar");
        bihac.add("Ćukovi");
        bihac.add("Doljani");
        bihac.add("Donja Gata");
        bihac.add("Dubovsko");
        bihac.add("Gorjevac");
        bihac.add("Grabež");
        bihac.add("Grmuša");
        bihac.add("Hrgar");
        bihac.add("Jezero");
        bihac.add("Kalati");
        bihac.add("Kostela");
        bihac.add("Kulen Vakuf");
        bihac.add("Lohovo");
        bihac.add("Lohovska Brda");
        bihac.add("Mala Pleća");
        bihac.add("Mali Skočaj");
        bihac.add("Međudražje");
        bihac.add("Muslići");
        bihac.add("Ostrovica");
        bihac.add("Papari");
        bihac.add("Praščijak");
        bihac.add("Pritoka");
        bihac.add("Račić");
        bihac.add("Rajinovci");
        bihac.add("Ripač");
        bihac.add("Spahići");
        bihac.add("Srbljani");
        bihac.add("Velika Gata");
        bihac.add("Veliki Skočaj");
        bihac.add("Veliki Stjenjani");
        bihac.add("Vikići");
        bihac.add("Vrsta");
        bihac.add("Zavalje");
        bihac.add("Zlopoljac");


        cazin.add("Bajrići");
        cazin.add("Brezova Kosa");
        cazin.add("Bukovica");
        cazin.add("Crnaja");
        cazin.add("Čajići");
        cazin.add("Čizmići");
        cazin.add("Ćehići");
        cazin.add("Ćoralići");
        cazin.add("Donja Barska");
        cazin.add("Donja Koprivna");
        cazin.add("Donja Lučka");
        cazin.add("Glogovac");
        cazin.add("Gornja Barska");
        cazin.add("Gornja Koprivna");
        cazin.add("Gornja Lučka");
        cazin.add("Gradina");
        cazin.add("Hadžin Potok");
        cazin.add("Kapići");
        cazin.add("Kovačevići");
        cazin.add("Krakača");
        cazin.add("Krivaja");
        cazin.add("Krivaja");
        cazin.add("Liđani");
        cazin.add("Liskovac");
        cazin.add("Ljubljankići");
        cazin.add("Majetići");
        cazin.add("Miostrah");
        cazin.add("Mujakići");
        cazin.add("Mutnik");
        cazin.add("Osredak");
        cazin.add("Ostrožac");
        cazin.add("Ostrođac na Uni");
        cazin.add("Pećigrad");
        cazin.add("Pivnice");
        cazin.add("Pjanići");
        cazin.add("Podgredina");
        cazin.add("Polje");
        cazin.add("Ponjevići");
        cazin.add("Prošići");
        cazin.add("Rošići");
        cazin.add("Rujnica");
        cazin.add("Skokovi");
        cazin.add("Stijena");
        cazin.add("Šturlić");
        cazin.add("Šturlička Platnica");
        cazin.add("Toromani");
        cazin.add("Tržac");
        cazin.add("Tržačka Platnica");
        cazin.add("Tržačka Raštela");
        cazin.add("Urga");
        cazin.add("Vilenjača");
        cazin.add("Vrelo");
        cazin.add("Zmajevac");


        capljina.add("Bajovci");
        capljina.add("Bivolje Brdo");
        capljina.add("Crnići");
        capljina.add("Čeljevo");
        capljina.add("Doljani");
        capljina.add("Domanovići");
        capljina.add("Dračevo");
        capljina.add("Dretelj");
        capljina.add("Dubravica");
        capljina.add("Gabela");
        capljina.add("Gnjilišta");
        capljina.add("Gorica");
        capljina.add("Grabovina");
        capljina.add("Hotanj");
        capljina.add("Jasenica");
        capljina.add("Klepci");
        capljina.add("Lokve");
        capljina.add("Opličići");
        capljina.add("Počitelj");
        capljina.add("Prčavci");
        capljina.add("Prebilovci");
        capljina.add("Sjekose");
        capljina.add("Stanojevići");
        capljina.add("Struge");
        capljina.add("Svitava");
        capljina.add("Ševaš Njive");
        capljina.add("Šurmanci");
        capljina.add("Tasovčići");
        capljina.add("Trebižat");
        capljina.add("Višići");
        capljina.add("Zvirovići");


        doboj.add("Boljanić");
        doboj.add("Božinci Donji");
        doboj.add("Brezici");
        doboj.add("Brusnica");
        doboj.add("Bukovac");
        doboj.add("Bukovica Mala");
        doboj.add("Bukovica Velika");
        doboj.add("Bušletić");
        doboj.add("Čajre");
        doboj.add("Čivčije Bukovičke");
        doboj.add("Čivčije Osječanske");
        doboj.add("Doboj");
        doboj.add("Donja Paklenica");
        doboj.add("Donji Rakovac");
        doboj.add("Foča");
        doboj.add("Glogovica");
        doboj.add("Gornja Međeđa");
        doboj.add("Gornja Paklenica");
        doboj.add("Grabovica");
        doboj.add("Grapska Donja");
        doboj.add("Grapska Gornja");
        doboj.add("Johovac");
        doboj.add("Kladari");
        doboj.add("Komarica");
        doboj.add("Kostajnica");
        doboj.add("Kotorsko");
        doboj.add("Kožuhe");
        doboj.add("Lipac");
        doboj.add("Lukavica Rijeka");
        doboj.add("Ljeskove Vode");
        doboj.add("Majevac");
        doboj.add("Makijenovac");
        doboj.add("Miljkovac");
        doboj.add("Omanjska");
        doboj.add("Opsine");
        doboj.add("Osječani Donji");
        doboj.add("Osječani Gornji");
        doboj.add("Osojnica");
        doboj.add("Paležnica Donja");
        doboj.add("Paležnica Gornja");
        doboj.add("Pločnik");
        doboj.add("Podnovlje");
        doboj.add("Porječje");
        doboj.add("Potočani");
        doboj.add("Pridjel Donji");
        doboj.add("Prijed Gornji");
        doboj.add("Prisade");
        doboj.add("Prnjavor Mali");
        doboj.add("Prnjavor Veliki");
        doboj.add("Ritešić");
        doboj.add("Rječica Donja");
        doboj.add("Rječica Gornja");
        doboj.add("Sjenina");
        doboj.add("Sjenina Rijeka");
        doboj.add("Skipovac Donji");
        doboj.add("Skipovac Gornji");
        doboj.add("Stanić Rijeka");
        doboj.add("Stanovi");
        doboj.add("Strlježevica");
        doboj.add("Suho Polje");
        doboj.add("Svjetliča");
        doboj.add("Ševarlije");
        doboj.add("Tekućica");
        doboj.add("Tisovac");
        doboj.add("Trbuk");
        doboj.add("Trnjani");
        doboj.add("Vranduk");
        doboj.add("Zarječa");
        doboj.add("Zelinja Gornja");

        gorazde.add("Bačci");
        gorazde.add("Bahovo");
        gorazde.add("Bakije");
        gorazde.add("Bare");
        gorazde.add("Batkovići");
        gorazde.add("Bezmilje");
        gorazde.add("Biljin");
        gorazde.add("Blagojevići");
        gorazde.add("Bogušići");
        gorazde.add("Borovići");
        gorazde.add("Boškovići");
        gorazde.add("Brajlovići");
        gorazde.add("Bratiš");
        gorazde.add("Brekovi");
        gorazde.add("Brezje");
        gorazde.add("Brijeg");
        gorazde.add("Bučje");
        gorazde.add("Budići");
        gorazde.add("Butkovići");
        gorazde.add("Butkovići Ilovača");
        gorazde.add("Crvica");
        gorazde.add("Čitluk");
        gorazde.add("Čovčići");
        gorazde.add("Čurovi");
        gorazde.add("Ćatovići");
        gorazde.add("Ćehajići");
        gorazde.add("Deševa");
        gorazde.add("Donja Brda");
        gorazde.add("Donja Bukvica");
        gorazde.add("Donje Selo");
        gorazde.add("Donji Bogovići");
        gorazde.add("Dragolji");
        gorazde.add("Dučići");
        gorazde.add("Džindići");
        gorazde.add("Đakovići");
        gorazde.add("Faočići");
        gorazde.add("Gaj");
        gorazde.add("Glamoč");
        gorazde.add("Gočela");
        gorazde.add("Goražde");
        gorazde.add("Gornja Brda");
        gorazde.add("Gornja Bukvica");
        gorazde.add("Gornji Bogovići");
        gorazde.add("Grabovik");
        gorazde.add("Gunjačići");
        gorazde.add("Gunjevići");
        gorazde.add("Gusići");
        gorazde.add("Guskovići");
        gorazde.add("Hadžići");
        gorazde.add("Hrančići");
        gorazde.add("Hubjeri");
        gorazde.add("Ilovaća");
        gorazde.add("Jagodići");
        gorazde.add("Jarovići");
        gorazde.add("Kalac");
        gorazde.add("Kamen");
        gorazde.add("Karauzovići");
        gorazde.add("Karovići");
        gorazde.add("Kazagići");
        gorazde.add("Knjevići");
        gorazde.add("Kodžaga Polje");
        gorazde.add("Kola");
        gorazde.add("Kolijevke");
        gorazde.add("Kolovarice");
        gorazde.add("Konjbaba");
        gorazde.add("Konjevići");
        gorazde.add("Kosače");
        gorazde.add("Kraboriš");
        gorazde.add("Kreča");
        gorazde.add("Kučine");
        gorazde.add("Kušeši");
        gorazde.add("Kutješi");
        gorazde.add("Laleta");
        gorazde.add("Lukarice");
        gorazde.add("Markovići");
        gorazde.add("Milanovići");
        gorazde.add("Mirvići");
        gorazde.add("Mirvići na Podhranjenu");
        gorazde.add("Morinac");
        gorazde.add("Mravi");
        gorazde.add("Mravinjac");
        gorazde.add("Mrkovi");
        gorazde.add("Nekopi");
        gorazde.add("Odžak");
        gorazde.add("Orahovice");
        gorazde.add("Oručevac");
        gorazde.add("Osanica");
        gorazde.add("Osječani");
        gorazde.add("Ostružno");
        gorazde.add("Ozrenovići");
        gorazde.add("Paraun");
        gorazde.add("Perjani");
        gorazde.add("Pijestina");
        gorazde.add("Pijevac");
        gorazde.add("Plesi");
        gorazde.add("Podhomara");
        gorazde.add("Podhranjen");
        gorazde.add("Podkozara Donja");
        gorazde.add("Poratak");
        gorazde.add("Potrkuša");
        gorazde.add("Prisoje");
        gorazde.add("Radići");
        gorazde.add("Radijevići");
        gorazde.add("Radovovoći");
        gorazde.add("Raškovići");
        gorazde.add("Ratkovići");
        gorazde.add("Rešetnica");
        gorazde.add("Ropovići");
        gorazde.add("Rosijevići");
        gorazde.add("Sedlari");
        gorazde.add("Sijedac");
        gorazde.add("Skravnik");
        gorazde.add("Sofići");
        gorazde.add("Sopotnica");
        gorazde.add("Spahovići");
        gorazde.add("Šabanci");
        gorazde.add("Šašići");
        gorazde.add("Šehovići");
        gorazde.add("Šemihova");
        gorazde.add("Šućurići");
        gorazde.add("Tupačići");
        gorazde.add("Uhotići");
        gorazde.add("Ušanovići");
        gorazde.add("Utješinovići");
        gorazde.add("Vitkovići");
        gorazde.add("Vlajčići");
        gorazde.add("Vraneši");
        gorazde.add("Vranići");
        gorazde.add("Vran Potok");
        gorazde.add("Vrbica");
        gorazde.add("Vremci");
        gorazde.add("Vučetići");
        gorazde.add("Zabus");
        gorazde.add("Završje");
        gorazde.add("Zorovići");
        gorazde.add("Zubovići");
        gorazde.add("Zubovići u Oglečevi");
        gorazde.add("Zupčići");
        gorazde.add("Žigovi");
        gorazde.add("Žilići");
        gorazde.add("Žuželo");

        gracanica.add("Babići");
        gracanica.add("Duborovci");
        gracanica.add("Donja Lohinja");
        gracanica.add("Džakule");
        gracanica.add("Gornja Lohinja");
        gracanica.add("Gračanica");
        gracanica.add("Lendići");
        gracanica.add("Lukavica");
        gracanica.add("Malešići");
        gracanica.add("Miričina");
        gracanica.add("Orahovica Donja");
        gracanica.add("Orahovica Gornja");
        gracanica.add("Paležnica Donja");
        gracanica.add("Piskavica");
        gracanica.add("Pribava");
        gracanica.add("Prijeko Drvo");
        gracanica.add("Rašljeva");
        gracanica.add("Skipovac Donji");
        gracanica.add("Skipovac Gornji");
        gracanica.add("Soko");
        gracanica.add("Stjepan Polje");
        gracanica.add("Škahovica");
        gracanica.add("Vranovići");

        gradacac.add("Avramovina");
        gradacac.add("Biberovo Polje");
        gradacac.add("Blaževac");
        gradacac.add("Donja Međiđa");
        gradacac.add("Donja Tramošnica");
        gradacac.add("Donje Krečane");
        gradacac.add("Donje Ledenice");
        gradacac.add("Gornji Lukavac");
        gradacac.add("Gradačac");
        gradacac.add("Hrgovi Donji");
        gradacac.add("Jasenica");
        gradacac.add("Jelovče Selo");
        gradacac.add("Kerep");
        gradacac.add("Mionica");
        gradacac.add("Mionica");
        gradacac.add("Novalići");
        gradacac.add("Porebrice");
        gradacac.add("Rajska");
        gradacac.add("Samarevac");
        gradacac.add("Sibovac");
        gradacac.add("Srnice Donje");
        gradacac.add("Srnice Gornje");
        gradacac.add("Turić");
        gradacac.add("Vida");
        gradacac.add("Vučkovci");
        gradacac.add("Zelinja Donja");
        gradacac.add("Zelinja Gornja");
        gradacac.add("Zelinja Srednja");

        gradiska.add("Adžići");
        gradiska.add("Berek");
        gradiska.add("Bistrica");
        gradiska.add("Bok Jankovac");
        gradiska.add("Brestovčina");
        gradiska.add("Bukovac");
        gradiska.add("Cerovljani");
        gradiska.add("Cimiroti");
        gradiska.add("Čatrnja");
        gradiska.add("Čelinovac");
        gradiska.add("Čikule");
        gradiska.add("Donja Dolina");
        gradiska.add("Donja Jurkovića");
        gradiska.add("Donji Karajzovci");
        gradiska.add("Donji Podgradci");
        gradiska.add("Dragelji");
        gradiska.add("Dubrave");
        gradiska.add("Elezagići");
        gradiska.add("Gašnica");
        gradiska.add("Gornja Dolina");
        gradiska.add("Gornja Jurkovića");
        gradiska.add("Gornja Lipovača");
        gradiska.add("Gornji Karajzovci");
        gradiska.add("Gornji Podgradci");
        gradiska.add("Gradiška");
        gradiska.add("Grbavci");
        gradiska.add("Greda");
        gradiska.add("Jablanica");
        gradiska.add("Jazovac");
        gradiska.add("Kijevci");
        gradiska.add("Kočićevo");
        gradiska.add("Kozara");
        gradiska.add("Kozinci");
        gradiska.add("Krajišnik");
        gradiska.add("Kruškik");
        gradiska.add("Laminci Brezici");
        gradiska.add("Laminci Dubrave");
        gradiska.add("Laminci Jaružani");
        gradiska.add("Laminci Sređani");
        gradiska.add("Liskovac");
        gradiska.add("Lužani");
        gradiska.add("Maćkovac");
        gradiska.add("Mašići");
        gradiska.add("Mičije");
        gradiska.add("Miloševo Brdo");
        gradiska.add("Miljevići");
        gradiska.add("Mokrice");
        gradiska.add("Nova Topola");
        gradiska.add("Novo Selo");
        gradiska.add("Orahova");
        gradiska.add("Orubica");
        gradiska.add("Petrovo Selo");
        gradiska.add("Rogolji");
        gradiska.add("Romanovci");
        gradiska.add("Rovine");
        gradiska.add("Samardžije");
        gradiska.add("Seferovci");
        gradiska.add("Sovjak");
        gradiska.add("Srednja Jurkovica");
        gradiska.add("Šaškinovci");
        gradiska.add("Trebovijani");
        gradiska.add("Trnovac");
        gradiska.add("Trošelji");
        gradiska.add("Turjak");
        gradiska.add("Vakuf");
        gradiska.add("Vilusi");
        gradiska.add("Vrbaška");
        gradiska.add("Žeravica");

        istocnoSarajevo.add("Klek");
        istocnoSarajevo.add("Kozarevići");
        istocnoSarajevo.add("Lukavica");
        istocnoSarajevo.add("Miljevići");
        istocnoSarajevo.add("Petrovići");
        istocnoSarajevo.add("Toplik");
        istocnoSarajevo.add("Tvrdimići");

        livno.add("Bila");
        livno.add("Bilo Polje");
        livno.add("Bogdaše");
        livno.add("Bojmunte");
        livno.add("Ćaič");
        livno.add("Čaprazlije");
        livno.add("Čelebić");
        livno.add("Čuklić");
        livno.add("Ćosanlije");
        livno.add("Dobro");
        livno.add("Donji Rujani");
        livno.add("Drinova Međa");
        livno.add("Držanlije");
        livno.add("Golinjevo");
        livno.add("Gornji Rujani");
        livno.add("Grborezi");
        livno.add("Grgurići");
        livno.add("Gubin");
        livno.add("Komorani");
        livno.add("Kovačić");
        livno.add("Lipa");
        livno.add("Lištani");
        livno.add("Livno");
        livno.add("Lopatice");
        livno.add("Lusnić");
        livno.add("Ljubunčić");
        livno.add("Mali Guber");
        livno.add("Mali Kablići");
        livno.add("Miši");
        livno.add("Odžak");
        livno.add("Orguz");
        livno.add("Podgradina");
        livno.add("Podgreda");
        livno.add("Podhum");
        livno.add("Potkraj");
        livno.add("Potočani");
        livno.add("Potok");
        livno.add("Priluka");
        livno.add("Prisap");
        livno.add("Prolog");
        livno.add("Provo");
        livno.add("Radanovci");
        livno.add("Rapovine");
        livno.add("Sajković");
        livno.add("Smričani");
        livno.add("Srđevići");


        ljubuski.add("Bijača");
        ljubuski.add("Cerno");
        ljubuski.add("Crnopod");
        ljubuski.add("Crveni Grm");
        ljubuski.add("Dole");
        ljubuski.add("Grab");
        ljubuski.add("Grabovnik");
        ljubuski.add("Gradska");
        ljubuski.add("Greda");
        ljubuski.add("Grljevići");
        ljubuski.add("Hardomilje");
        ljubuski.add("Hrašljani");
        ljubuski.add("Humac");
        ljubuski.add("Kašće");
        ljubuski.add("Lisice");
        ljubuski.add("Ljubuški");
        ljubuski.add("Miletina");
        ljubuski.add("Mostarska Vrata");
        ljubuski.add("Orahovlje");
        ljubuski.add("Predgrađe");
        ljubuski.add("Radišići");
        ljubuski.add("Šipovača");
        ljubuski.add("Veljaci");
        ljubuski.add("Vojnići");
        ljubuski.add("Zvirići");




        mostar.add("Bačevići");
        mostar.add("Banjdol");
        mostar.add("Blagaj");
        mostar.add("Bogodol");
        mostar.add("Buna");
        mostar.add("Cim");
        mostar.add("Čule");
        mostar.add("Dobrć");
        mostar.add("Donja Drežnica");
        mostar.add("Donji Jasenjani");
        mostar.add("Dračevice");
        mostar.add("Gnojnice");
        mostar.add("Goranci");
        mostar.add("Gornja Drežnica");
        mostar.add("Gornje Gnojnice");
        mostar.add("Gornji Jasenjani");
        mostar.add("Gubavica");
        mostar.add("Hodbina");
        mostar.add("Hrušta");
        mostar.add("Ilići");
        mostar.add("Kremenac");
        mostar.add("Kružanj");
        mostar.add("Lakševine");
        mostar.add("Malo Polje");
        mostar.add("Miljkovići");
        mostar.add("Podvelež");
        mostar.add("Raška Gora");
        mostar.add("Selište");
        mostar.add("Sretnice");
        mostar.add("Vrapčići");
        mostar.add("Žitomislići");
        mostar.add("Žulja");
        mostar.add("Željuša");

        prijedor.add("Ališići");
        prijedor.add("Babići");
        prijedor.add("Bistrica");
        prijedor.add("Biščani");
        prijedor.add("Crna Dolina");
        prijedor.add("Donja Ravska");
        prijedor.add("Gačani");
        prijedor.add("Gradina");
        prijedor.add("Hambarine");
        prijedor.add("Jaruge");
        prijedor.add("Krivaja");
        prijedor.add("Ljeskare");
        prijedor.add("Ništavci");
        prijedor.add("Raljaš");
        prijedor.add("Tisova");
        prijedor.add("Zecovi");

        sarajevo.add("Alifakovac");
        sarajevo.add("Alipašin Most");
        sarajevo.add("Alipašino Polje");
        sarajevo.add("Aneks");
        sarajevo.add("Babića Bašća");
        sarajevo.add("Bardakčije");
        sarajevo.add("Baščaršija");
        sarajevo.add("Betanija");
        sarajevo.add("Bistrik");
        sarajevo.add("Briješće");
        sarajevo.add("Čengić Vila");
        sarajevo.add("Dobrinja");
        sarajevo.add("Dolac Malta");
        sarajevo.add("Ferhadija");
        sarajevo.add("Grbavica");
        sarajevo.add("Hrasno");
        sarajevo.add("Hrid");
        sarajevo.add("Koševo");
        sarajevo.add("Kovači");
        sarajevo.add("Kovačići");
        sarajevo.add("Marijin Dvor");
        sarajevo.add("Mejtaš");
        sarajevo.add("Mojmilo");
        sarajevo.add("Otoka");
        sarajevo.add("Pofalići");
        sarajevo.add("Sedrenik");
        sarajevo.add("Skenderija");
        sarajevo.add("Soukbunar");
        sarajevo.add("Velešići");
        sarajevo.add("Vraca");
        sarajevo.add("Vratnik");


        srebrenik.add("Babunovići");
        srebrenik.add("Behrami");
        srebrenik.add("Brda");
        srebrenik.add("Brezik");
        srebrenik.add("Brnjičani");
        srebrenik.add("Cage");
        srebrenik.add("Cerik");
        srebrenik.add("Crveno Brdo");
        srebrenik.add("Čekanići");
        srebrenik.add("Dedići");
        srebrenik.add("Donji Moranjci");
        srebrenik.add("Donji podpeć");
        srebrenik.add("Duboki Potok");
        srebrenik.add("Falešići");
        srebrenik.add("Gornji Hrgovi");
        srebrenik.add("Huremi");
        srebrenik.add("Jasenica");
        srebrenik.add("Kiseljak");
        srebrenik.add("Like");
        srebrenik.add("Lipje");
        srebrenik.add("Ljenobud");
        srebrenik.add("Maoča");
        srebrenik.add("Podorašje");
        srebrenik.add("Seona");
        srebrenik.add("Sladna");
        srebrenik.add("Zahirovići");



        sirokiBrijeg.add("Biograd");
        sirokiBrijeg.add("Buhovo");
        sirokiBrijeg.add("Crne Lokve");
        sirokiBrijeg.add("Čerigaj");
        sirokiBrijeg.add("Dobrić");
        sirokiBrijeg.add("Doci");
        sirokiBrijeg.add("Dužice");
        sirokiBrijeg.add("Gornja Britvica");
        sirokiBrijeg.add("Izbično");
        sirokiBrijeg.add("Jare");
        sirokiBrijeg.add("Lise");
        sirokiBrijeg.add("Ljubotići");
        sirokiBrijeg.add("Mokro");
        sirokiBrijeg.add("Oklaji");
        sirokiBrijeg.add("Privalj");
        sirokiBrijeg.add("Trn");
        sirokiBrijeg.add("Uzarići");

        trebinje.add("Aranđelovo");
        trebinje.add("Baonine");
        trebinje.add("Begović Kula");
        trebinje.add("Bijograd");
        trebinje.add("Brani Do");
        trebinje.add("Brova");
        trebinje.add("Cerovac");
        trebinje.add("Do");
        trebinje.add("Dobromani");
        trebinje.add("Dubljani");
        trebinje.add("Grab");
        trebinje.add("Hum");
        trebinje.add("Jasen");
        trebinje.add("Korlati");
        trebinje.add("Kraj");
        trebinje.add("Lapja");
        trebinje.add("Mesari");
        trebinje.add("Nikontovići");
        trebinje.add("Ograde");
        trebinje.add("Orašje Površ");
        trebinje.add("Petrovići");
        trebinje.add("Pijavice");
        trebinje.add("Rapti Bobani");
        trebinje.add("Rapti Zupci");
        trebinje.add("Skočigrm");
        trebinje.add("Šarani");
        trebinje.add("Tulje");


        tuzla.add("Brđani");
        tuzla.add("Breške");
        tuzla.add("Bukinje");
        tuzla.add("Cerik");
        tuzla.add("Dobrnja");
        tuzla.add("Dokanj");
        tuzla.add("Gornja Tuzla");
        tuzla.add("Kiseljak");
        tuzla.add("Kolimer");
        tuzla.add("Lipnica");
        tuzla.add("Ljepunice");
        tuzla.add("Ljubače");
        tuzla.add("Marinkovići");
        tuzla.add("Mramor");
        tuzla.add("Pasci Gornje");
        tuzla.add("Plane");
        tuzla.add("Požarnica");
        tuzla.add("Rapače");
        tuzla.add("Simin Han");
        tuzla.add("Svojtina");
        tuzla.add("Ševar");
        tuzla.add("Šići");
        tuzla.add("Tetima");
        tuzla.add("Tisovac");


        visoko.add("Arnautovići");
        visoko.add("Bare");
        visoko.add("Bešići");
        visoko.add("Bradve");
        visoko.add("Buzići");
        visoko.add("Ćalakovići");
        visoko.add("Ćatići");
        visoko.add("Dautovci");
        visoko.add("Dobrinje");
        visoko.add("Dobro");
        visoko.add("Dobro Selo");
        visoko.add("Dol");
        visoko.add("Dvor");
        visoko.add("Džindići");
        visoko.add("Ginje");
        visoko.add("Goduša");
        visoko.add("Hadžići");
        visoko.add("Jelašje");
        visoko.add("Kalići");
        visoko.add("Kula Banjer");
        visoko.add("Liješevo");
        visoko.add("Malo Čajno");
        visoko.add("Orašac");
        visoko.add("Paljike");
        visoko.add("Radinovići");
        visoko.add("Seoča");
        visoko.add("Šošnje");

        zenica.add("Arnauti");
        zenica.add("Babina Rijeka");
        zenica.add("Bijele Vode");
        zenica.add("Blatnica");
        zenica.add("Bukovica");
        zenica.add("Dobriljevo");
        zenica.add("Donja Vraca");
        zenica.add("Drugavci");
        zenica.add("Gladovići");
        zenica.add("Gorica");
        zenica.add("Gornja Gračanica");
        zenica.add("Gornje Crkvice");
        zenica.add("Janjac");
        zenica.add("Jasika");
        zenica.add("Kolići");
        zenica.add("Lašva");
        zenica.add("Lokvine");
        zenica.add("Loznik");
        zenica.add("Meokušnice");
        zenica.add("Nemila");
        zenica.add("Poca");
        zenica.add("Putovići");
        zenica.add("Sebuja");
        zenica.add("Tetovo");
       zenica.add("Tišina");


        zvornik.add("Androvići");
        zvornik.add("Bair");
        zvornik.add("Beksuja");
        zvornik.add("Cer");
        zvornik.add("Čaršija");
        zvornik.add("Divič");
        zvornik.add("Dugi Dio");
        zvornik.add("Đevanje");
        zvornik.add("Ekonomija");
        zvornik.add("Glodi");
        zvornik.add("Glumina");
        zvornik.add("Gušteri");
        zvornik.add("Hrid Zvornik");
        zvornik.add("Jardan");
        zvornik.add("Kozluk");
        zvornik.add("Liješanj");
        zvornik.add("Malešić");
        zvornik.add("Novo Selo");
        zvornik.add("Padine");
        zvornik.add("Rijeka");
        zvornik.add("Samari");
        zvornik.add("Snagovo");


        zivinice.add("Brnjica");
        zivinice.add("Djedino");
        zivinice.add("Dubrave Donj");
        zivinice.add("Kopjevići");
        zivinice.add("Lukavica Donja");
        zivinice.add("Odorovići");
        zivinice.add("Svojat");
        zivinice.add("Šerići");
        zivinice.add("Tupković Donji");
        zivinice.add("Tupković Gornji");
        zivinice.add("Živinice Donje");
        zivinice.add("Živinice Gornje");







/*
     dropdownText.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             if(position == 0) {
                 neighborhoodAdapter = new ArrayAdapter<>(getActivity(), R.layout.dropdown_item,banjaluka);
             }
             if(position == 1) {
                 neighborhoodAdapter = new ArrayAdapter<>(getActivity(), R.layout.dropdown_item,bihac);
             }
             if(position == 2) {
                 neighborhoodAdapter = new ArrayAdapter<>(getActivity(), R.layout.dropdown_item,cazin);
             }
             if(position == 3) {
                 neighborhoodAdapter = new ArrayAdapter<>(getActivity(), R.layout.dropdown_item,capljina);
             }
             if(position == 4) {
                 neighborhoodAdapter = new ArrayAdapter<>(getActivity(), R.layout.dropdown_item,doboj);
             }
             neighborhoodAdapter = new ArrayAdapter<>(getActivity(), R.layout.dropdown_item,cities);

             subdropdownText.setAdapter(neighborhoodAdapter);


         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {

         }
     });

*/







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
