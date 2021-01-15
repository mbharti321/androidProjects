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
        mCheckBangalore = findViewById(R.id.checkBangalore);
        mCheckChennai = findViewById(R.id.checkChennai);
        mCheckMumbai = findViewById(R.id.checkMumbai);
        mCheckDelhi = findViewById(R.id.checkDelhi);


        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer displayMsg = new StringBuffer();
                displayMsg.append("Username: ");
                displayMsg.append(mUsername.getText()).append("\n");

                int selectedRadio = mRadioGroup.getCheckedRadioButtonId();
                Button ageButton = findViewById(selectedRadio);
                if(selectedRadio == -1){
                    Toast.makeText(MainActivity.this, "Please select one age group",Toast.LENGTH_SHORT).show();
                }
                else{
                    displayMsg.append("Age Group: ");
                    displayMsg.append(ageButton.getText()).append("\n");
                }
                displayMsg.append("Preferred City: ");
                if(mCheckBangalore.isChecked()){
                    displayMsg.append(mCheckBangalore.getText());
                }
                if(mCheckChennai.isChecked()){
                    displayMsg.append(", ").append(mCheckChennai.getText());
                }
                if(mCheckMumbai.isChecked()){
                    displayMsg.append(", ").append(mCheckMumbai.getText());
                }
                if(mCheckDelhi.isChecked()){
                    displayMsg.append(", ").append(mCheckDelhi.getText());
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
