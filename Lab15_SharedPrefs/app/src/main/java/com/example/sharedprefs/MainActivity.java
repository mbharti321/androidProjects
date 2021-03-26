package com.example.sharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edUsername;
    EditText edPassword;
    CheckBox cbox;
    Button btnLogin;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    private String sharedPrefFile = "com.example.android.sharedprefs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edUsername = findViewById(R.id.EditText_Username);
        edPassword = findViewById(R.id.EditText_password);
        cbox = findViewById(R.id.checkBox);
        btnLogin = findViewById(R.id.btn_login);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mPreferences = getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();

        checkPreference();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbox.isChecked()){
                    mEditor.putString(getString(R.string.checkbox), "True");
                    mEditor.commit();

                    String name = edUsername.getText().toString();
                    mEditor.putString(getString(R.string.name), name);
                    mEditor.commit();

                    String password = edUsername.getText().toString();
                    mEditor.putString(getString(R.string.password1), password);
                    mEditor.commit();
                }else {

                    mEditor.putString(getString(R.string.checkbox), "False");
                    mEditor.commit();

                    mEditor.putString(getString(R.string.name), "");
                    mEditor.commit();

                    mEditor.putString(getString(R.string.password1), "");
                    mEditor.commit();

                }
                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(i);
                Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void checkPreference() {
        String checkBox = mPreferences.getString(getString(R.string.checkbox),"False");
        String name = mPreferences.getString(getString(R.string.name),"");
        String password = mPreferences.getString(getString(R.string.password1),"");


        edUsername.setText(name);
        edPassword.setText(password);

        if(checkBox.equals("True")){
            cbox.setChecked(true);
        }
        else {
            cbox.setChecked(false);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mPreferences = getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();
        String checkBox = mPreferences.getString(getString(R.string.checkbox),"False");
        String name = mPreferences.getString(getString(R.string.name),"");
        String password = mPreferences.getString(getString(R.string.password1),"");


        edUsername.setText(name);
        edPassword.setText(password);

        if(checkBox.equals("True")){
            cbox.setChecked(true);
        }
        else {
            cbox.setChecked(false);
        }
        checkPreference();
    }

    public void loginEvent(View view) {
    }
}
