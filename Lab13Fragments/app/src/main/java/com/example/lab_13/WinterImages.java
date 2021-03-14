package com.example.lab_13;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class WinterImages extends Fragment {


    public WinterImages() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_winter_images, container, false);
        ImageView img=(ImageView) view.findViewById(R.id.winterImage);
   return  view;
    }

}