package com.example.lab14musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;
    ImageButton mPlayPause;
    ImageButton mStop;

    //Current = 0 <- Play,  Current = 1 <- Pause
    int current = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayPause = findViewById(R.id.playButton);
        mStop = findViewById(R.id.stopButton);


        mPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current == 0) {

                    setImage(v);
                    current = 1;


                    //Main click event
                    if (player == null) {
                        player = MediaPlayer.create(MainActivity.this, R.raw.qaafirana);
                        player.start();
                    } else {
                        player.start();
                    }

                } else {
                    setImage(v);
                    current = 0;
                    if (player != null) {
                        player.pause();
                    }
                }


            }
        });

        mStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player != null) {
                    setImage(v);
                }

                stopPlayer();
            }
        });


    }

    @SuppressLint("ShowToast")
    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
            Toast.makeText(MainActivity.this, "Resource Released", Toast.LENGTH_SHORT).show();
        }
    }

    private void setImage(View v) {

        if (current == 0) {
            current = 1;
            mPlayPause.setImageResource(R.drawable.pause);
        } else {
            current = 0;
            mPlayPause.setImageResource(R.drawable.play);
        }
    }
}