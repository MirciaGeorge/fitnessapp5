package com.example.fitnessapp5;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AlimentatieFragment extends Fragment {
     EditText nrcalorii;
     Button generare;
    double nrcaloriif;
    TextView displaY;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View y=inflater.inflate(R.layout.fragment_alimentatie,container,false);


        nrcalorii=(EditText)y.findViewById(R.id.nrcal);
        generare=(Button)y.findViewById(R.id.generator);
        displaY=(TextView)y.findViewById(R.id.dieta);

        generare.setEnabled(false);

        TextWatcher activ = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String nrcaloriiinput=nrcalorii.getText().toString().trim();
                generare.setEnabled(!nrcaloriiinput.isEmpty());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        nrcalorii.addTextChangedListener(activ);

        generare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nrcaloriif=Double.parseDouble(nrcalorii.getText().toString());
                if(nrcaloriif >= 1000 &&  nrcaloriif < 2100)
                {
                    displaY.setText("MASA 1\n*1 banana-cu 15 min inainte de masa\n*3 oua fierte sau facute fara ulei\n*200gr cottage cheese 2%\n*100gr paine integrala\n\nMASA 2\n*200gr piept de pui la grater\n 350gr cartofi natur\n\nMASA 3\n*60gr mix de oleaginoase\n*200ml iaurt");
                }
                if(nrcaloriif >= 2100 && nrcaloriif < 2200)
                {
                    displaY.setText("MASA 1\n*400ml lapte cu 3.5% grasime\n*100gr musli\n*2 oua fierte\n*60gr paine integrala \n\nMASA 2\n*200gr orez fiert\n*150gr piept de pui la gratar \n\nMASA 3\n*150gr somon la gratar\n*200gr mix de legume la gratar MASA 4\n*200gr iaurt grecesc 10%\n*30gr migdale crude");
                }
                if(nrcaloriif >= 2200 && nrcaloriif < 2300)
                {
                    displaY.setText("MASA 1\n*100gr paine integrala\n*100gr muschi afumat/piept de pui afumat\n*50gr musli\n*400ml lapte cu 3.5%grasime \n\nMASA 2\n*200gr mamaliguta\n*2 oua fierte sau ochiuri fara ulei\n*150gr cottage cheese light 2.2% \n\nMASA 3\n*200gr pulpe de pui la cuptor\n250gr cartofi la cuptor \n\nMASA 4\n*300ml iaurt bio 3% grasime\n*60gr migdale crude\n*1 banana");
                }
                if(nrcaloriif >= 2300 && nrcaloriif < 2400)
                {
                    displaY.setText("MASA 1\n*3 oua fierte sau omleta fara ulei\n*100gr telemea de vaca/branza fetta\n*100gr paine integrala\n*100gr muschi afumat \n\nMASA 2\n*200gr orez fiert\n*150gr muschi de vita la gratar \n\nMASA 3\n*200gr somon la gratar\n*200gr legume la gratar \n\nMASA 4\n*250 gr iaurt grecesc 10%\n*40 gr migdale crude\n*1 banana");
                }
                if(nrcaloriif >= 2400 && nrcaloriif < 2500)
                {
                    displaY.setText("MASA 1\n*1 banana- cu 15 min inainte de masa\n*3 oua fierte dau facute omleta fara ulei\n*100gr cottage cheese 2%\n*100gr paine integrala\n*budinca de ovaz(200ml lapte,50gr ovaz) \n\nMASA 2\n*200gr piept de pui la gratar\n*200gr cartofi natur  \n\nMASA 4\n*200gr piept de pui la gratar\n*250gr paste integrale\n\nMASA 5\n*60gr mix de oleaginoase\n300ml iaurt grecesc 10%\n*1 banana");
                }
                if(nrcaloriif >= 2500 &&  nrcaloriif < 2600)
                {
                    displaY.setText("MASA 1\n*1 banana-cu 15 min inainte de masa\n*3 oua fierte sau facute fara ulei\n*200gr cottage cheese 2%\n*60gr paine integrala\n\nMASA 2\n*150gr piept de pui la grater\n 250gr cartofi natur\n\nMASA 3\n*150gr piept de pui la gratar\n*250gr paste integrale\n\nMASA 4\n*60gr mix de oleaginoase\n*200ml iaurt");
                }
                if(nrcaloriif >= 2600 && nrcaloriif < 2700)
                {
                    displaY.setText("MASA 1\n*400ml lapte cu 3.5% grasime\n*100gr musli\n*2 oua fierte\n*60gr paine integrala \n\nMASA 2\n*200gr orez fiert\n*200gr piept de pui la gratar \n\nMASA 3\n*150gr somon la gratar\n*300gr mix de legume la gratar \n\nMASA 4\n*1 banana\n*1 mar\n\nMASA 5\n*300gr iaurt grecesc 10%\n*30gr migdale crude");
                }
                if(nrcaloriif >= 2700 && nrcaloriif < 2800)
                {
                    displaY.setText("MASA 1\n*100gr paine integrala\n*100gr muschi afumat/piept de pui afumat\n*100gr musli\n*500ml lapte cu 3.5%grasime \n\nMASA 2\n*300gr mamaliguta\n*2 oua fierte sau ochiuri fara ulei\n*200gr cottage cheese light 2.2% \n\nMASA 3\n*200gr pulpe de pui la cuptor\n250gr cartofi la cuptor \n\nMASA 4\n*300ml iaurt bio 3% grasime\n*60gr migdale crude\n*1 banana");
                }
                if(nrcaloriif >= 2800 && nrcaloriif < 2900)
                {
                    displaY.setText("MASA 1\n*3 oua fierte sau omleta fara ulei\n*100gr telemea de vaca/branza fetta\n*100gr paine integrala\n*100gr muschi afumat \n\nMASA 2\n*250gr orez fiert\n*200gr muschi de vita la gratar \n\nMASA 3\n*200gr somon la gratar\n*300gr legume la gratar \n\nMASA 4\n*300 gr iaurt grecesc 10%\n*60 gr migdale crude\n*1 banana");
                }
                if(nrcaloriif >= 2900 && nrcaloriif < 3000)
                {
                    displaY.setText("MASA 1\n*1 banana- cu 15 min inainte de masa\n*3 oua fierte dau facute omleta fara ulei\n*200gr cottage cheese 2%\n*60gr paine integrala\n*budinca de ovaz(250ml lapte,50gr ovaz) \n\nMASA 2\n*200gr piept de pui la gratar\n*250gr cartofi natur \n\nMASA 3\n*50gr fructe uscate/confiate \n\nMASA 4\n*200gr piept de pui la gratar\n*250gr paste integrale\n\nMASA 5\n*60gr mix de oleaginoase\n300ml iaurt grecesc 10%\n*1 banana");
                }
                if(nrcaloriif >= 3000 && nrcaloriif < 3100)
                {
                    displaY.setText("MASA 1\n*3 oua fierte sau omleta fara ulei\n*100 gr telemea de vaca/branza fetta\n*100gr paine integrala\n*100gr muschi afumat \n\nMASA 2\n*250gr orez fiert\n*200gr muschi de vita la gratar \n\nMASA 3\n*100gr smochine/fructe uscate \n\nMASA 4\n*200gr somon la gratar\n*300gr legume la gratar\n\nMASA 5\n*300gr iaurt grecesc 10%\n*60gr migdale crude\n*1 banana");
                }
                if(nrcaloriif >= 3100 && nrcaloriif < 3200)
                {
                    displaY.setText("MASA 1\n*orez cu lapte(150ml apa,100gr orez crud,400ml lapte) \n\nMASA 2\n*200gr somon la gratar\n*250gr cartofi natur \n\nMASA 3\n*spaghetti bolognese(200gr vita tocata,250gr spaghetti fierte,sos de rosii) \n\nMASA 4(Sandwich)\n*150gr piept de pui\n*100gr paine integrala\n*200gr cottage cheese 2%\n\nMASA 5\n*50gr smochine/fructe uscate\n*45gr migdale crude\n*300ml iaurt grecesc 10% grasime");
                }
                if(nrcaloriif >= 3200 && nrcaloriif < 3300)
                {
                    displaY.setText("MASA 1\n*3 oua fierte sau omleta fara ulei\n*100 gr telemea de vaca/branza fetta\n*100gr paine integrala\n*100gr muschi afumat \n\nMASA 2\n*250gr orez fiert\n*200gr muschi de vita la gratar \n\nMASA 3\n*100gr smochine/fructe uscate \n\nMASA 4\n*200gr somon la gratar\n*300gr legume la gratar\n\nMASA 5\n*300gr iaurt grecesc 10%\n*60gr migdale crude\n*50gr fulgi de ovaz");
                }
                if(nrcaloriif >= 3300 && nrcaloriif < 3400)
                {
                    displaY.setText("MASA 1\n*orez cu lapte(150ml apa,100gr orez crud,400ml lapte) \n\nMASA 2\n*200gr somon la gratar\n*250gr cartofi natur \n\nMASA 3\n*spaghetti bolognese(200gr vita tocata,250gr spaghetti fierte,sos de rosii) \n\nMASA 4(Sandwich)\n*150gr piept de pui\n*100gr paine integrala\n*200gr cottage cheese 2%\n\nMASA 5\n*50gr smochine/fructe uscate\n*60gr migdale crude\n*300ml iaurt grecesc 10% grasime");
                }
                if(nrcaloriif >= 3400 && nrcaloriif < 3500)
                {
                    displaY.setText("MASA 1\n*3 oua fierte sau omleta fara ulei\n*100 gr telemea de vaca/branza fetta\n*100gr paine integrala\n*100gr muschi afumat \n\nMASA 2\n*250gr orez fiert\n*200gr muschi de vita la gratar \n\nMASA 3\n*100gr smochine/fructe uscate\n*1 banana \n\nMASA 4\n*200gr somon la gratar\n*300gr legume la gratar\n\nMASA 5\n*300gr iaurt grecesc 10%\n*60gr migdale crude\n*100gr fulgi de ovaz");
                }
                if(nrcaloriif >= 3500 && nrcaloriif < 3600)
                {
                    displaY.setText("MASA 1\n*1 banana- cu 15 min inainte de masa\n*3 oua fierte dau facute omleta fara ulei\n*200gr cottage cheese 2%\n*100gr paine integrala\n*budinca de ovaz(250ml lapte,50gr ovaz) \n\nMASA 2\n*200gr piept de pui la gratar\n*250gr cartofi natur \n\nMASA 3\n*100gr fructe uscate/confiate\n*300ml iaurt de baut 0.9% grasime \n\nMASA 4\n*200gr piept de pui la gratar\n*250gr paste integrale\n\nMASA 5\n*60gr mix de oleaginoase\n300ml iaurt grecesc 10%\n*125gr fulgi de ovaz");
                }
                if(nrcaloriif >= 3600 && nrcaloriif < 3700)
                {
                    displaY.setText("MASA 1\n*400ml lapte cu 3.5% grasime\n*100gr musli\n*3 oua fierte\n*100gr paine integrala \n\nMASA 2\n*250gr orez fiert\n*200gr piept de pui la gratar \n\nMASA 3\n*200gr somon la gratar\n*250gr cartofi natur \n\nMASA 4\n*1 banana\n*1 mar\n\nMASA 5\n*300gr iaurt grecesc 10%\n*60gr migdale crude\n*150gr fulgi de ovaz");
                }
                if(nrcaloriif >= 3700 && nrcaloriif < 3800)
                {
                    displaY.setText("MASA 1\n*100gr paine integrala\n*100gr muschi afumat/piept de pui afumat\n*100gr musli\n*500ml lapte cu 3.5%grasime \n\nMASA 2\n*300gr mamaliguta\n*3 oua fierte sau ochiuri fara ulei\n*200gr cottage cheese light 2.2% \n\nMASA 3\n*200gr pulpe de pui la cuptor\n300gr cartofi la cuptor \n\nMASA 4\n*300ml iaurt grecesc 10% grasime\n*60gr migdale crude\n*100gr fulgi de ovaz\n\nMASA 5\n*2 banane\n*2 piersici\n*50gr smochine/fructe uscate");
                }
                if(nrcaloriif >= 3800 && nrcaloriif < 3900)
                {
                    displaY.setText("MASA 1\n*3 oua fierte sau omleta fara ulei\n*200 gr telemea de vaca/branza fetta\n*100gr paine integrala\n*100gr muschi afumat \n\nMASA 2\n*250gr orez fiert\n*200gr muschi de vita la gratar \n\nMASA 3\n*100gr smochine/fructe uscate\n*1 banana \n\nMASA 4\n*200gr somon la gratar\n*300gr legume la gratar\n\nMASA 5\n*300gr iaurt grecesc 10%\n*60gr migdale crude\n*100gr fulgi de ovaz");
                }
                if(nrcaloriif >= 3900 && nrcaloriif < 4000)
                {
                    displaY.setText("MASA 1\n*3 oua fierte\n*100gr piept de pui afumat\n*165gr paine integrala\n*budinca de ovaz(100gr ovaz, 500ml lapte)\n\nMASA 2\n*1 lipie integrala(60gr)\n*200gr cartofi copti\n*200gr piept de pui la gratar\n\nMASA 3\n*1 banana\n*50 gr fructe uscate\n\nMASA 4\n*200gr piept de pui la gratar\n*250gr paste integrale\n\nMASA 5\n*100gr migdale crude\n*300ml iaurt grecesc 10%\n*50gr fulgi de ovaz");
                }
                if(nrcaloriif >= 4000 && nrcaloriif < 4100)
                {
                    displaY.setText("MASA 1\n*100gr paine integrala\n*100gr muschi afumat/piept de pui afumat\n*100gr musli\n*500ml lapte cu 3.5%grasime \n\nMASA 2\n*300gr mamaliguta\n*3 oua fierte sau ochiuri fara ulei\n*200gr cottage cheese light 2.2% \n\nMASA 3\n*200gr pulpe de pui la cuptor\n300gr cartofi la cuptor \n\nMASA 4\n*300ml iaurt grecesc 10% grasime\n*60gr migdale crude\n*175gr fulgi de ovaz\n\nMASA 5\n*2 banane\n*2 piersici\n*100gr smochine/fructe uscate");
                }
                if(nrcaloriif >= 4100 && nrcaloriif < 4200)
                {
                    displaY.setText("MASA 1\n*orez cu lapte(150ml apa,100gr orez crud,450ml lapte) \n\nMASA 2\n*200gr somon la gratar\n*350gr cartofi natur \n\nMASA 3\n*spaghetti bolognese(200gr vita tocata,300gr spaghetti fierte,sos de rosii) \n\nMASA 4(Sandwich)\n*150gr piept de pui\n*100gr paine integrala\n*200gr cottage cheese 2%\n\nMASA 5\n*75gr fulgi de ovaz\n*60gr migdale crude\n*300ml iaurt grecesc 10% grasime\n\nMASA 6\n*1 banana\n*50 gr smochine");
                }
                if(nrcaloriif >= 4200 && nrcaloriif < 4300)
                {
                    displaY.setText("MASA 1\n*3 oua fierte sau omleta fara ulei\n*200 gr telemea de vaca/branza fetta\n*100gr paine integrala\n*100gr muschi afumat \n\nMASA 2\n*350gr orez fiert\n*200gr muschi de vita la gratar \n\nMASA 3\n*100gr smochine/fructe uscate\n*2 banane \n\nMASA 4\n*200gr somon la gratar\n*300gr legume la gratar\n\nMASA 5\n*300gr iaurt grecesc 10%\n*60gr migdale crude\n*100gr fulgi de ovaz\n\nMASA 6\n*100gr curcan\n*150gr cartofi dulci");
                }
                if(nrcaloriif >= 4300 && nrcaloriif < 4400)
                {
                    displaY.setText("MASA 1\n*1 banana- cu 15 min inainte de masa\n*3 oua fierte dau facute omleta fara ulei\n*200gr cottage cheese 2%\n*150gr paine integrala\n*budinca de ovaz(250ml lapte,100gr ovaz) \n\nMASA 2\n*200gr piept de pui la gratar\n*350gr cartofi natur \n\nMASA 3\n*100gr fructe uscate/confiate\n*300ml iaurt de baut 0.9% grasime \n\nMASA 4\n*200gr piept de pui la gratar\n*300gr paste integrale\n\nMASA 5\n*60gr mix de oleaginoase\n300ml iaurt grecesc 10%\n*125gr fulgi de ovaz\n\nMASA 6\n*100gr salau\n*100gr cartofi dulci");
                }
                if(nrcaloriif >= 4400 && nrcaloriif < 4500)
                {
                    displaY.setText("MASA 1\n*400ml lapte cu 3.5% grasime\n*150gr musli\n*3 oua fierte\n*150gr paine integrala \n\nMASA 2\n*300gr orez fiert\n*200gr piept de pui la gratar \n\nMASA 3\n*200gr somon la gratar\n*300gr cartofi natur \n\nMASA 4\n*1 banana\n*2 mere\n\nMASA 5\n*300gr iaurt grecesc 10%\n*60gr migdale crude\n*150gr fulgi de ovaz\n\nMASA 6\n*100gr salau\n*175gr cartofi dulci");
                }
                if(nrcaloriif >= 4500 && nrcaloriif < 4600)
                {
                    displaY.setText("MASA 1\n*200gr paine integrala\n*100gr muschi afumat/piept de pui afumat\n*150gr musli\n*500ml lapte cu 3.5%grasime \n\nMASA 2\n*300gr mamaliguta\n*3 oua fierte sau ochiuri fara ulei\n*250gr cottage cheese light 2.2% \n\nMASA 3\n*250gr pulpe de pui la cuptor\n350gr cartofi la cuptor \n\nMASA 4\n*350ml iaurt grecesc 10% grasime\n*100gr migdale crude\n*100gr fulgi de ovaz\n\nMASA 5\n*2 banane\n*2 piersici\n*100gr smochine/fructe uscate");
                }
                if(nrcaloriif >= 4600 && nrcaloriif < 4700)
                {
                    displaY.setText("MASA 1\n*3 oua fierte sau omleta fara ulei\n*200 gr telemea de vaca/branza fetta\n*200gr paine integrala\n*100gr muschi afumat \n\nMASA 2\n*350gr orez fiert\n*200gr muschi de vita la gratar \n\nMASA 3\n*100gr smochine/fructe uscate\n*1 banana \n\nMASA 4\n*200gr somon la gratar\n*350gr legume la gratar\n*300gr cartofi dulci\n\nMASA 5\n*400gr iaurt grecesc 10%\n*80gr migdale crude\n*100gr fulgi de ovaz");
                }
                if(nrcaloriif >= 4700 && nrcaloriif < 4800)
                {
                    displaY.setText("MASA 1\n*3 oua fierte\n*100gr piept de pui afumat\n*165gr paine integrala\n*budinca de ovaz(100gr ovaz, 500ml lapte)\n\nMASA 2\n*1 lipie integrala(60gr)\n*200gr cartofi copti\n*200gr piept de pui la gratar\n\nMASA 3\n*1 banana\n*50 gr fructe uscate\n\nMASA 4\n*200gr piept de pui la gratar\n*250gr paste integrale\n\nMASA 5\n*100gr migdale crude\n*300ml iaurt grecesc 10%\n*50gr fulgi de ovaz\n\nMASA 6\n*200gr curcan\n*300gr cartofi dulci");
                }
                if(nrcaloriif >= 4800 && nrcaloriif < 4900)
                {
                    displaY.setText("MASA 1\n*200gr paine integrala\n*100gr muschi afumat/piept de pui afumat\n*150gr musli\n*500ml lapte cu 3.5%grasime \n\nMASA 2\n*300gr mamaliguta\n*3 oua fierte sau ochiuri fara ulei\n*200gr cottage cheese light 2.2% \n\nMASA 3\n*200gr pulpe de pui la cuptor\n400gr cartofi la cuptor \n\nMASA 4\n*300ml iaurt grecesc 10% grasime\n*800gr migdale crude\n*175gr fulgi de ovaz\n\nMASA 5\n*2 banane\n*2 piersici\n*100gr smochine/fructe uscate\n\nMASA 6\n*200g fructe de padure");
                }
                if(nrcaloriif >= 4900 && nrcaloriif < 6000)
                {
                    displaY.setText("MASA 1\n*orez cu lapte(150ml apa,150gr orez crud,450ml lapte) \n\nMASA 2\n*200gr somon la gratar\n*400gr cartofi natur \n\nMASA 3\n*spaghetti bolognese(200gr vita tocata,350gr spaghetti fierte,sos de rosii) \n\nMASA 4(Sandwich)\n*150gr piept de pui\n*200gr paine integrala\n*200gr cottage cheese 2%\n\nMASA 5\n*75gr fulgi de ovaz\n*100gr migdale crude\n*300ml iaurt grecesc 10% grasime\n\nMASA 6\n*200gr salau\n*350gr cartofi dulci");
                }

            }
        });



        return y;
    }
}
