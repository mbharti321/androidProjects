package com.example.lab9menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ShareCompat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
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
    TextInputEditText mMessage;
    ConstraintLayout mlayout;
    boolean iscolor = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessage = findViewById(R.id.main_textbox);
        mlayout = (ConstraintLayout) findViewById(R.id.layout1);
        mibtnSend = findViewById(R.id.ibtnSend);

        mibtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whatsappSend();
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
                changeColor();
                return true;

            case R.id.share:
                share();
                return true;

            case R.id.exit:
                exit();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }

    private void changeColor() {
        if(iscolor)
        {
            mlayout.setBackgroundColor(Color.GREEN);
            iscolor = false;
        }
        else
        {
            mlayout.setBackgroundColor(Color.WHITE);
            iscolor = true;
        }
    }


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

//    private void whatsappSend() {
//        String txt = mMessage.getText().toString();
//
//        Intent sendIntent = new Intent();
//        sendIntent.setAction(Intent.ACTION_SEND);
//        sendIntent.putExtra(Intent.EXTRA_TEXT, txt);
//        sendIntent.setType("text/plain");
//        sendIntent.setPackage("com.whatsapp");
//
//        startActivity(sendIntent);
//
//    }




    //https://medium.com/@mujjtahidah/send-whatsapp-to-specific-number-android-studio-96c8caf7422f
    //    @SuppressLint("NewApi")
    private void whatsappSend() {
        String txt = mMessage.getText().toString();
        try{
            Intent sendIntent =new Intent("android.intent.action.MAIN");
            sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.setType("text/plain");
            sendIntent.putExtra(Intent.EXTRA_TEXT,"");
            sendIntent.putExtra("jid", txt +"@s.whatsapp.net");
            sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent);
        }
        catch(Exception e)
        {
            Toast.makeText(this,"Error/n"+ e.toString(),Toast.LENGTH_SHORT).show();
        }
    }


    //Closes the App: Closing current activity
    void exit() {
        finish();
    }


}