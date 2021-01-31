package com.example.manoimplicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private EditText mwebsite_edittext, mlocation_edittext, mshare_edittext;
    private Button mopen_website_button, mopen_location_button, mshare_text_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mwebsite_edittext = findViewById(R.id.website_edittext);
        mlocation_edittext = findViewById(R.id.location_edittext);
        mshare_edittext = findViewById(R.id.share_edittext);

        mopen_website_button = findViewById(R.id.open_website_button);
        mopen_location_button = findViewById(R.id.open_location_button);
        mshare_text_button = findViewById(R.id.share_text_button);


        mopen_website_button.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("QueryPermissionsNeeded")
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "website button Clicked", Toast.LENGTH_SHORT).show();
                String url = mwebsite_edittext.getText().toString();
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }

            }
        });

        mopen_location_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "location button Clicked", Toast.LENGTH_SHORT).show();

                // Get the string indicating a location. Input is not validated; it is
                // passed to the location handler intact.
                String loc = mlocation_edittext.getText().toString();

                // Parse the location and create the intent.
                Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
                Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

                // Find an activity to handle the intent, and start that activity.
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });

        mshare_text_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "share button Clicked", Toast.LENGTH_SHORT).show();

                String txt = mshare_edittext.getText().toString();
                String mimeType = "text/plain";
                ShareCompat.IntentBuilder
                        .from(MainActivity.this)
                        .setType(mimeType)
                        .setChooserTitle("Hello title")
                        .setText(txt).startChooser();
            }
        });
    }


}