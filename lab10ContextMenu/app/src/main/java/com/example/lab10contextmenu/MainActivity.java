package com.example.lab10contextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView m_imgJuice, m_imgDosa, m_imgPizza, m_imgPulav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_imgJuice = findViewById(R.id.imgJuice);
        m_imgDosa = findViewById(R.id.imgDosa);
        m_imgPizza = findViewById(R.id.imgPizza);
        m_imgPulav = findViewById(R.id.imgPulav);


        m_imgJuice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "juice", Toast.LENGTH_SHORT).show();
            }
        });

        m_imgDosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Dosa", Toast.LENGTH_SHORT).show();
            }
        });


        m_imgPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Pizza", Toast.LENGTH_SHORT).show();
            }
        });

        m_imgPulav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Pulav", Toast.LENGTH_SHORT).show();
            }
        });
    }


}