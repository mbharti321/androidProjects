package com.example.lab10contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView m_imgJuice, m_imgDosa, m_imgPizza, m_imgPulav;
    Button mBtnReset;

    float juiceRate=15, pulavRate=100, pizzaRate=99, dosaRate=60;
    int juiceCount=0, pulavCount=0, pizzaCount=0, dosaCount=0;

    int selectedFood = 0;

    TextView mJuiceRate, mPulavRate, mPizzaRate, mDosaRate;
    TextView mJuiceCount, mPulavCount, mPizzaCount, mDosaCount, mtotalCount;
    TextView mJuiceTotal, mPulavTotal, mPizzaTotal, mDosaTotal, mtotalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_imgJuice = findViewById(R.id.imgJuice);
        m_imgDosa = findViewById(R.id.imgDosa);
        m_imgPizza = findViewById(R.id.imgPizza);
        m_imgPulav = findViewById(R.id.imgPulav);
        mBtnReset = findViewById(R.id.btnReset);


        mJuiceRate = findViewById(R.id.textViewJuiceRate);
        mPulavRate= findViewById(R.id.textViewPulavRate);
        mPizzaRate= findViewById(R.id.textViewPizzaRate);
        mDosaRate= findViewById(R.id.textViewDosaRate);

        mJuiceCount= findViewById(R.id.textViewJuiceCount);
        mPulavCount= findViewById(R.id.textViewPulavCount);
        mPizzaCount= findViewById(R.id.textViewPizzaCount);
        mDosaCount= findViewById(R.id.textViewDosaCount);
        mtotalCount= findViewById(R.id.textViewTotalCount);

        mJuiceTotal= findViewById(R.id.textViewJuiceTotal);
        mPulavTotal= findViewById(R.id.textViewPulavTotal);
        mPizzaTotal= findViewById(R.id.textViewPizzaTotal);
        mDosaTotal= findViewById(R.id.textViewDosaTotal);
        mtotalAmount= findViewById(R.id.textViewTotalAmount);




        registerForContextMenu(m_imgJuice);
        registerForContextMenu(m_imgDosa);
        registerForContextMenu(m_imgPizza);
        registerForContextMenu(m_imgPulav);

        dispaly();



        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                juiceCount=0;
                pulavCount=0;
                pizzaCount=0;
                dosaCount=0;
                dispaly();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void dispaly() {
        mJuiceRate.setText(Float.toString(juiceRate) );
        mPulavRate.setText(Float.toString(pulavRate));
        mPizzaRate.setText(Float.toString(pizzaRate));
        mDosaRate.setText(Float.toString(dosaRate));

        mJuiceCount.setText(Integer.toString(juiceCount));
        mPulavCount.setText(Integer.toString(pulavCount));
        mPizzaCount.setText(Integer.toString(pizzaCount));
        mDosaCount.setText(Integer.toString(dosaCount));
        int totalCount = juiceCount+ pulavCount+ pizzaCount+ dosaCount;
        mtotalCount.setText(Integer.toString(totalCount));

        float JuiceAmount = juiceRate * juiceCount;
        float PulavAmount =pulavRate * pulavCount;
        float PizzaAmount =pizzaRate*pizzaCount;
        float DosaAmount =dosaRate*dosaCount;

        float totalAmount = JuiceAmount + PulavAmount +PizzaAmount +DosaAmount;
        mJuiceTotal.setText(Float.toString(JuiceAmount));
        mPulavTotal.setText(Float.toString(PulavAmount));
        mPizzaTotal.setText(Float.toString(PizzaAmount));
        mDosaTotal.setText(Float.toString(DosaAmount));

        mtotalAmount.setText(Float.toString(totalAmount));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

//        getMenuInflater().inflate(R.menu.context_menu, menu);

        switch (v.getId()) {
            case R.id.imgJuice:
                selectedFood = R.id.imgJuice;
                getMenuInflater().inflate(R.menu.context_menu, menu);
                return;

            case R.id.imgPulav:
                selectedFood = R.id.imgPulav;
                getMenuInflater().inflate(R.menu.context_menu, menu);
                return;

            case R.id.imgPizza:
                selectedFood = R.id.imgPizza;
                getMenuInflater().inflate(R.menu.context_menu, menu);
                return;

            case R.id.imgDosa:
                selectedFood = R.id.imgDosa;
                getMenuInflater().inflate(R.menu.context_menu, menu);
                return;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.itemPlace:
                if(selectedFood == R.id.imgJuice){
                    juiceCount += 1;
                }else if(selectedFood == R.id.imgPulav){
                    pulavCount += 1;
                }else if(selectedFood == R.id.imgPizza){
                    pizzaCount += 1;
                }else if(selectedFood == R.id.imgDosa){
                    dosaCount += 1;
                }

                Toast.makeText(MainActivity.this, "Ordered Placed", Toast.LENGTH_SHORT).show();
                dispaly();
                return true;


            case R.id.itemDetails:
                StringBuilder foodDetails = new StringBuilder();
                foodDetails.append("Selected Food Details:\n");
                if(selectedFood == R.id.imgJuice){
                    foodDetails.append("Food Name: " + "Juice\n");
                    foodDetails.append("Food Price: ").append(juiceRate);
                }else if(selectedFood == R.id.imgPulav){
                    foodDetails.append("Food Name: " + "Pulav\n");
                    foodDetails.append("Food Price: ").append(pulavRate);
                }else if(selectedFood == R.id.imgPizza){
                    foodDetails.append("Food Name: " + "Pizza\n");
                    foodDetails.append("Food Price: ").append(pizzaRate);
                }else if(selectedFood == R.id.imgDosa){
                    foodDetails.append("Food Name: " + "Dosa\n");
                    foodDetails.append("Food Price: ").append(dosaRate);
                }

                Toast.makeText(MainActivity.this, foodDetails.toString(), Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }
}