package com.example.fitnessapp5;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;

public class CaloriiFragment extends Fragment {

    TextView display;
    EditText greutate,inaltime,varsta,activitate;
    double greutatef,inaltimef,varstaf,activitatef,carbs=0,fats=0,prots=0;
    RadioGroup radiogroup1,radiogroup2;
    Button calculeaza;
    double total=0;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View z= inflater.inflate(R.layout.fragment_calorii,container,false);


        radiogroup1=z.findViewById(R.id.grupsex);
        radiogroup2=z.findViewById(R.id.grupobiectiv);
        display = (TextView)z.findViewById(R.id.ntextView);
        greutate=(EditText)z.findViewById(R.id.greutate);
        inaltime=(EditText)z.findViewById(R.id.inaltime);
        varsta=(EditText)z.findViewById(R.id.varsta);
        activitate=(EditText)z.findViewById(R.id.nrore);
        calculeaza = (Button) z.findViewById(R.id.calcul);
          calculeaza.setEnabled(false);

          TextWatcher activare = new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
               String greutateinput=greutate.getText().toString().trim();
               String varstainput=varsta.getText().toString().trim();
               String inaltimeinput=inaltime.getText().toString().trim();
               String activitateinput=activitate.getText().toString().trim();

               calculeaza.setEnabled(!greutateinput.isEmpty() && !varstainput.isEmpty() && !inaltimeinput.isEmpty() && !activitateinput.isEmpty());

           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       };

        greutate.addTextChangedListener(activare);
        varsta.addTextChangedListener(activare);
        inaltime.addTextChangedListener(activare);
        activitate.addTextChangedListener(activare);

        calculeaza.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {

                                              greutatef=Double.parseDouble(greutate.getText().toString());
                                              inaltimef=Double.parseDouble(inaltime.getText().toString());
                                              varstaf=Double.parseDouble(varsta.getText().toString());
                                              activitatef=Double.parseDouble(activitate.getText().toString());


                                              int radioId=radiogroup1.getCheckedRadioButtonId();



                                                  switch (radioId)
                                                          {
                                                              case R.id.masculin:
                                                                  total=10*greutatef+625*inaltimef/100-5*varstaf+5;
                                                                  break;
                                                              case R.id.feminin:
                                                                  total=10*greutatef+625*inaltimef/100-5*varstaf-161;
                                                                  break;
                                                          }


                                              total=total+10*total/100;
                                                if(activitatef==0)
                                                  {
                                                      total=12*total/10;

                                                  }
                                              if(activitatef>0 && activitatef <=0.5)
                                              {
                                                  total=1375*total/1000;
                                              }
                                              if(activitatef>0.5 && activitatef <=1)
                                              {
                                                  total=155*total/100;
                                              }
                                               if(activitatef>1 && activitatef <=2)
                                              {
                                                  total=1725*total/1000;
                                              }
                                              if(activitatef>2)
                                              {
                                                  total=19*total/10;
                                              }
                                               int radioId2=radiogroup2.getCheckedRadioButtonId();

                                                    switch ((radioId2))
                                                    {
                                                        case R.id.masamusculara:
                                                            total=total + 15*total/100;
                                                            prots=2*greutatef;
                                                            fats=11*greutatef/10;
                                                            carbs=(total-9*fats-4*prots)/4;
                                                            break;
                                                        case R.id.slabire:
                                                            total=total - 15*total/100;
                                                            prots=23*greutatef/10;
                                                            fats=9*greutatef/10;
                                                            carbs=(total-9*fats-4*prots)/4;
                                                            break;
                                                        case R.id.recompozitie:
                                                            prots=19*greutatef/10;
                                                            fats=102*greutatef/100;
                                                            carbs=(total-9*fats-4*prots)/4;
                                                    }
                                              if(radioId == -1)
                                              {
                                                  Toast.makeText(getActivity(), "Alege sexul!", Toast.LENGTH_SHORT).show();
                                              }else {
                                                  if(radioId2 == -1)
                                                  {
                                                      Toast.makeText(getActivity(), "Alege obiectivul!", Toast.LENGTH_SHORT).show();
                                                  }else {
                                                      DecimalFormat df= new DecimalFormat(" ");
                                                      display.setText("Calorii necesare: " + String.valueOf(df.format(total)) + "\nRecomandare macronutrienti:"+"\nCarbohidrati: " + df.format(carbs)+"g" + "\nProteine: " + df.format(prots)+"g" + "\nGrasime: " + df.format(fats)+"g");

                                                  }
                                              }

                                          }
                                      }

        );
        return z;}

};

