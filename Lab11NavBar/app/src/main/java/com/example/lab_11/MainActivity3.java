package com.example.lab_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity3 extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity2.EXTRA_MESSAGE);
        TextView textView1 = findViewById(R.id.uname);
        textView1.setText("Name : " + message);

       String message1 = intent.getStringExtra(MainActivity2.EXTRA_NUMBER);
        TextView textView2 = findViewById(R.id.mobile);
        textView2.setText("Mobile Number : " + message1);

        String message2 = intent.getStringExtra(MainActivity2.EXTRA_TEXT);
        TextView textView3 = findViewById(R.id.room);
        textView3.setText("Room Chosen : " + message2);

        String message4 = intent.getStringExtra(MainActivity2.EXTRA_DATE);
        TextView textView4 = findViewById(R.id.date);
        textView4.setText("Date Chosen : " + message4);

        String message5 = intent.getStringExtra(MainActivity2.EXTRA_TIME);
        TextView textView5 = findViewById(R.id.user_time);
        textView5.setText("Time Chosen: " + message5);

        TextView textView6 = findViewById(R.id.amount);

        if(message2.equals("Single"))
        {
            int amt;
            amt = 430;
            textView6.setText("Amount: Rs." +amt );
        }
        else if(message2.equals("Double"))
        {
            int amt;
            amt = 600;
            textView6.setText("Amount: Rs." +amt );
        }

    }

    public void ClickMenu(View view)
    {
        //Open drawer
        MainActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view )
    {
        //Close drawer
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view)
    {
        //Redirect activity to home
        MainActivity.redirectActivity(this,MainActivity.class);
    }

    public void ClickDashboard(View view)
    {
        //Recreate activity
        recreate();
    }

    public void ClickExit(View view)
    {
        MainActivity.logout(this);
    }

    public void display(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.toast_layout_root));
        Toast toast = new Toast(getApplicationContext());

        TextView toastTextView = (TextView) layout.findViewById(R.id.toastTextView);
        toast.setGravity(Gravity.TOP | Gravity.CENTER, 20, 1700);
        toastTextView.setText("Confirmed, Thanks for booking!");
        toast.setView(layout);
        toast.show();
    }
}
