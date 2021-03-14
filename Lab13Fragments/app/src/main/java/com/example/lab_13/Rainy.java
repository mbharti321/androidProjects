package com.example.lab_13;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Rainy extends Fragment {

Button btnRainy;

    public Rainy() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rainy, container, false);

        btnRainy=(Button)view.findViewById(R.id.buttonRainy);

        btnRainy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               RainyImages rainyImages = new RainyImages();
                //Fragment transaction allows to add,remove, replace in response with a fragment
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,rainyImages);
                fr.commit();
            }
        });
        return view;
    }
}