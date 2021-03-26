package com.example.sharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView txtUsername;
    Button btnLogout;

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    private String sharedPrefFile = "com.example.android.sharedprefs";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtUsername = findViewById(R.id.txtUsername);
        btnLogout = findViewById(R.id.btn_logout);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mPreferences = getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();


        String name = mPreferences.getString(getString(R.string.name),"");
        txtUsername.setText(name);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor = mPreferences.edit();
//                mEditor.clear();
//                mEditor.commit();
                finish();
                Toast.makeText(HomeActivity.this,"LogOut Successful",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
