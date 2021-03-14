package com.example.lab_13;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Autumn extends Fragment {
    Button btnAutumn;

    public Autumn() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_autumn, container, false);

        btnAutumn=(Button)view.findViewById(R.id.buttonAutumn);

        btnAutumn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AutumnImages autumnImages = new AutumnImages();
                //Fragment transaction allows to add,remove, replace in response with a fragment
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,autumnImages);
                fr.commit();
            }
        });
        return view;
    }
}