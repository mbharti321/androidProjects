package com.example.manolab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mUsername;
    private RadioGroup mRadioGroup;
    private CheckBox mCheckBangalore, mCheckChennai, mCheckMumbai, mCheckDelhi;
    private Button mSubmit, mReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSubmit = findViewById(R.id.btnSubmit);
        mReset = findViewById(R.id.btnReset);

        mUsername = findViewById(R.id.editTextUsername);
        mRadioGroup = findViewById(R.id.radioGroup);


        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer displayMsg = new StringBuffer();
                displayMsg.append(mUsername.getText()).append("\n");

                int selectedRadio = mRadioGroup.getCheckedRadioButtonId();
                Button ageButton = findViewById(selectedRadio);
                if(selectedRadio == -1){
                    Toast.makeText(MainActivity.this, "Please select one age group",Toast.LENGTH_SHORT).show();
                }
                else{
                    displayMsg.append(ageButton.getText());
                }


               Toast.makeText(MainActivity.this, displayMsg,Toast.LENGTH_SHORT).show();
            }
        });

        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hi", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
