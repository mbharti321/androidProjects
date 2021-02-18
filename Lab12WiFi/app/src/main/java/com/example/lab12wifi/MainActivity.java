package com.example.lab12wifi;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mBtnWiFi;
    boolean WiFiStatus;

    String val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnWiFi = findViewById(R.id.btnWiFi);

        WifiManager wifi = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WiFiStatus = wifi.isWifiEnabled();

        mBtnWiFi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(WiFiStatus){
                    val = "true";
//                    Toast.makeText(MainActivity.this,val,Toast.LENGTH_SHORT).show();
                    wifi.setWifiEnabled(false);
                    WiFiStatus = false;
                    Toast.makeText(MainActivity.this,"Wifi turned off",Toast.LENGTH_SHORT).show();
                }
                else{
                    val = "false";
//                    Toast.makeText(MainActivity.this,val,Toast.LENGTH_SHORT).show();
                    wifi.setWifiEnabled(true);

                    if(wifi.isWifiEnabled()) {
                        WiFiStatus = true;
                        Toast.makeText(MainActivity.this, "Wifi turned on", Toast.LENGTH_SHORT).show();
                    }else
                        Toast.makeText(MainActivity.this,"Failed to connect wifi",Toast.LENGTH_SHORT).show();
                }
            }
        });
//        finish();
    }


}