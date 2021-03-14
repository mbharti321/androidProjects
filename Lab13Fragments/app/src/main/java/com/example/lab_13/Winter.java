package com.example.lab_13;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;


public class Winter extends Fragment {
    //defining button variable
    Button btnWinter;
    public Winter() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_winter, container, false);

        //Assigning the value to the variable
        btnWinter=(Button)view.findViewById(R.id.buttonWinter);

        btnWinter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               WinterImages winterImages = new WinterImages();
                //Fragment transaction allows to add,remove, replace in response with a fragment
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,winterImages).commit();
            }
        });
        return view;
    }
    }
