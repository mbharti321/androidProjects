package com.example.lab9menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ShareCompat;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private ImageButton mibtnSend;
    TextInputEditText mMessage, mMain_number;
    ConstraintLayout mlayout;
    boolean iscolor = true;
    int defaultColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessage = findViewById(R.id.main_message);
        mMain_number = findViewById(R.id.main_number);
        mlayout = (ConstraintLayout) findViewById(R.id.layout1);
        mibtnSend = findViewById(R.id.ibtnSend);

        defaultColor = ContextCompat.getColor(MainActivity.this, R.color.design_default_color_primary);

        mibtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txtMessage = mMessage.getText().toString();
                String mob_number = mMain_number.getText().toString();
                if(mob_number.equals("")){
                    Toast.makeText(MainActivity.this, "Whatsapp", Toast.LENGTH_SHORT).show();
                    whatsappSendChooser(txtMessage);
                }
                else if (mob_number.length() != 10){
                    Toast.makeText(MainActivity.this, getString(R.string.not10Digits), Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Whatsapp", Toast.LENGTH_SHORT).show();
                    whatsappSend(mob_number, txtMessage);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
//            case R.id.send:
//                whatsappSend();
//                return true;

            case R.id.color:
                Toast.makeText(MainActivity.this,"Change color", Toast.LENGTH_SHORT).show();
                changeColor();
                return true;

            case R.id.share:
                Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
                share();
                return true;

            case R.id.exit:
                Toast.makeText(MainActivity.this, "exit", Toast.LENGTH_SHORT).show();
                exit();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }

    private void changeColor() {
        if(iscolor)
        {
            mlayout.setBackgroundColor(Color.GRAY);
            iscolor = false;
        }
        else
        {
            mlayout.setBackgroundColor(Color.WHITE);
            iscolor = true;
        }
    }

//    void setColor() {
//
//        AmbilWarnaDialog ambilWarnaDialog = new AmbilWarnaDialog(this, defaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
//            @Override
//            public void onCancel(AmbilWarnaDialog dialog) {
//
//            }
//
//            @Override
//            public void onOk(AmbilWarnaDialog dialog, int color) {
//                defaultColor = color;
//                mlayout.setBackgroundColor(defaultColor);
//            }
//        });
//        ambilWarnaDialog.show();
//
//    }

    private void share() {
        String txt = mMessage.getText().toString();
        String mimeType = "text/plain";

        ShareCompat.IntentBuilder
                .from(MainActivity.this)
                .setType(mimeType)
                .setChooserTitle(txt)
                .setText(txt)
                .startChooser();
    }



    private boolean appInstalledOrNot(String url) {
        PackageManager packageManager = getPackageManager();
        boolean app_installed;

        try {
            packageManager.getPackageInfo(url, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch ( PackageManager.NameNotFoundException e ) {
            app_installed = false;
        }
        return app_installed;
    }
    private void whatsappSendChooser(String txtMessage) {


        boolean installed = appInstalledOrNot("com.whatsapp");
        if (installed) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, txtMessage);
            sendIntent.setType("text/plain");
            sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent);
        } else {
            Toast.makeText(MainActivity.this, "Whatsapp not instaled", Toast.LENGTH_SHORT).show();
        }
    }

    void whatsappSend(String mob_number, String txtMessage) {
        boolean installed = appInstalledOrNot("com.whatsapp");
        if (installed) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+ "+91"+ mob_number + "&text=" + txtMessage));
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Whatsapp not instaled", Toast.LENGTH_SHORT).show();
        }

    }



    //Closes the App: Closing current activity
    void exit() {
        finish();
    }


}