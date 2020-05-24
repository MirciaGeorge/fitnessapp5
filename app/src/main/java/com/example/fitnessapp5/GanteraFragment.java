package com.example.fitnessapp5;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class GanteraFragment extends Fragment {
    GridLayout mainGrid;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View q= inflater.inflate(R.layout.fragment_gantera,container,false);

        mainGrid=q.findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);

        return q;
    }

    private void setSingleEvent(GridLayout mainGrid) {
        for(int i=0;i<mainGrid.getChildCount();i++)
        {
            CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int finalI=i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(finalI == 0)
                    {
                        Intent intent = new Intent(getActivity(),MasaMuscularaActivity.class);
                        startActivity(intent);
                    }
                    else if(finalI == 1)
                    {
                        Intent intent = new Intent(getActivity(),RecompozitieActivity.class);
                        startActivity(intent);
                    }
                    else if(finalI == 2)
                    {
                        Intent intent = new Intent(getActivity(),SlabireActivity.class);
                        startActivity(intent);
                    }else
                    {
                        Toast.makeText(getActivity(), "fail", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }

    }

}
