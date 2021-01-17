package com.example.manolab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mUsername;
    private RadioGroup mRadioGroup;
    private CheckBox mCheckBangalore, mCheckChennai, mCheckMumbai, mCheckDelhi;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mSubmit = findViewById(R.id.btnSubmit);
        Button mReset = findViewById(R.id.btnReset);

        mUsername = findViewById(R.id.editTextUsername);
        mRadioGroup = findViewById(R.id.radioGroup);
        mCheckBangalore = findViewById(R.id.checkBangalore);
        mCheckChennai = findViewById(R.id.checkChennai);
        mCheckMumbai = findViewById(R.id.checkMumbai);
        mCheckDelhi = findViewById(R.id.checkDelhi);
        mImageView = findViewById(R.id.imageView1);


        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mUsername.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Please enter username",Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer displayMsg = new StringBuffer();
                displayMsg.append("Username: ");
                displayMsg.append(mUsername.getText()).append("\n");

                int selectedRadio = mRadioGroup.getCheckedRadioButtonId();
                Button ageButton = findViewById(selectedRadio);
                if(selectedRadio == -1){
                    Toast.makeText(MainActivity.this, "Please select one age group",Toast.LENGTH_SHORT).show();
                    return;
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
                mImageView.setVisibility(View.VISIBLE);
               Toast.makeText(MainActivity.this, displayMsg,Toast.LENGTH_SHORT).show();

            }
        });

        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Hi", Toast.LENGTH_SHORT).show();
                mUsername.setText("");
                mRadioGroup.clearCheck();
                mCheckBangalore.setChecked(false);
                mCheckDelhi.setChecked(false);
                mCheckMumbai.setChecked(false);
                mCheckChennai.setChecked(false);
                mImageView.setVisibility(View.INVISIBLE);
            }
        });
    }


}
