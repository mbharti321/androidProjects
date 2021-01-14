package com.example.manocalc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView mNum1, mNum2, mResult, mResultLbl;
    private double num1, num2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNum1 = (TextView) findViewById(R.id.editTextNum1);
        mNum2 = (TextView) findViewById(R.id.editTextNum2);
        mResult = (TextView) findViewById(R.id.textViewResult);
        mResultLbl = (TextView) findViewById(R.id.textViewResultLbl);
        mNum1.requestFocus();
    }

    //To check if any of the text field is empty
    public boolean isEmptyField(){
        String mNum1Str = mNum1.getText().toString();
        String mNum2Str = mNum2.getText().toString();

        if(mNum1Str.equals("") || mNum2Str.equals("")) {
            Toast toast = Toast.makeText(this,"Please enter both the numbers", Toast.LENGTH_SHORT);
            toast.show();
            return true;
        }
        else {
            num1 = Double.parseDouble(mNum1Str);
            num2 = Double.parseDouble(mNum2Str);
            return false;
        }
    }


    @SuppressLint("SetTextI18n")
    public void addNumbers(View view) {
        if (isEmptyField()) {
            return;
        }
        result = num1 + num2;
        if(mResult != null){
            mResultLbl.setText("Addition:");
            mResult.setText(Double.toString(result));
        }
    }



    @SuppressLint("SetTextI18n")
    public void subNumbers(View view) {
        if (isEmptyField()) {
            return;
        }
        result = num1 - num2;
        if(mResult != null){
            mResultLbl.setText("Subtraction:");
            mResult.setText(Double.toString(result));
        }
    }

    @SuppressLint("SetTextI18n")
    public void divNumbers(View view) {
        if (isEmptyField()) {
            return;
        }
        result = num1 / num2;
        if(mResult != null){
            mResultLbl.setText("Division:");
            mResult.setText(Double.toString(result));
        }
    }

    @SuppressLint("SetTextI18n")
    public void mulNumbers(View view) {
        if (isEmptyField()) {
            return;
        }
        result = num1 * num2;
        if(mResult != null){
            mResultLbl.setText("Product:");
            mResult.setText(Double.toString(result));
        }
    }

    public void resetAll(View view) {
        mNum1.setText("");
        mNum2.setText("");
        mResult.setText("");
        mNum1.requestFocus();
        mResultLbl.setText("Result:");
    }
}