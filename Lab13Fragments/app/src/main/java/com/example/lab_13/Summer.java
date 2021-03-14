package com.example.lab_13;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Summer extends Fragment {
    //Defining the variable
    Button btnSummer;

    public Summer() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        container.removeAllViews();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_summer, container, false);

        //Assigning the value to the variable
        btnSummer=(Button)view.findViewById(R.id.buttonSummer);

        btnSummer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SummerImages summerImages = new SummerImages();
                //Fragment transaction allows to add,remove, replace in response with a fragment
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,summerImages);
                fr.commit();

            }
        });
        return view;
    }
}
