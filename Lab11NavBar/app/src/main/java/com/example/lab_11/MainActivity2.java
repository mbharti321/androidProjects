package com.example.lab_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static java.util.Calendar.HOUR_OF_DAY;

public class MainActivity2 extends AppCompatActivity {
    public static final String EXTRA_MESSAGE =
            "com.example.android.lab_11.EXTRA_MESSAGE";

    public static final String EXTRA_NUMBER =
            "com.example.android.lab_11.EXTRA_NUMBER";

    public static final String EXTRA_TEXT =
            "com.example.android.lab_11.EXTRA_TEXT";

    public static final String EXTRA_DATE=
            "com.example.android.lab_11.EXTRA_DATE";

    public static final String EXTRA_TIME=
            "com.example.android.lab_11.EXTRA_TIME";

    String[] rooms={"Double", "Single"};
    //Initialise variable
    DrawerLayout drawerLayout;
    Spinner spin;
    DatePickerDialog picker;
    TimePickerDialog picker1;
    EditText eText,eText2, eTextmobile,eTextname;
    Button btn;

    public final static String MESSAGE_KEY ="com.example.message_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
        this.spin = (Spinner) findViewById(R.id.roomSelection);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity2.this, R.array.rooms, R.layout.spinner_custom); //change the last argument here to your xml above.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(R.layout.spinner_custom);
         //Apply the adapter to the spinner
        spin.setAdapter(adapter);


        eTextname=(EditText)findViewById(R.id.editTextName);
        eTextmobile=(EditText)findViewById(R.id.editTextPhone);
        eText = (EditText) findViewById(R.id.ed1);
        eText2 = (EditText) findViewById(R.id.ed2);
        eText.setInputType(InputType.TYPE_NULL);

        btn = (Button) findViewById(R.id.submit);

    //For choosing date
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(MainActivity2.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        //For choosing time
        eText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                picker1 = new TimePickerDialog(MainActivity2.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        eText2.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                picker1.show();
            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }

    private void openActivity() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.toast_layout_root));
        Toast toast = new Toast(getApplicationContext());
//        TextView header = (TextView)layout.findViewById(R.id.toast_header);

        TextView toastTextView = (TextView) layout.findViewById(R.id.toastTextView);
        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);

        //If all the fields are null
        if((eTextname.getText().toString().isEmpty()) && (eTextmobile.getText().toString().isEmpty()) && (eText.getText().toString().isEmpty())&& (eText2.getText().toString().isEmpty())) {
            toastTextView.setText("PLEASE PROVIDE YOUR CREDENTIALS");
            toast.setView(layout);
            toast.show();
        }

        //If any one of the fields are null
        else if(eTextname.getText().toString().isEmpty()) {
            toastTextView.setText("ENTER NAME");
            toast.setView(layout);
            toast.show();
        }
        else if(eTextmobile.getText().toString().isEmpty()) {
            toastTextView.setText("ENTER MOBILE NUMBER");
            toast.setView(layout);
            toast.show();
        }
        else if(eText.getText().toString().isEmpty()) {
            toastTextView.setText("CHOOSE DATE");
            toast.setView(layout);
            toast.show();
        }
        else if(eText2.getText().toString().isEmpty()) {
            toastTextView.setText("CHOOSE TIME");
            toast.setView(layout);
            toast.show();
        }

        else {
            Bundle extras = new Bundle();
            String name = eTextname.getText().toString();
            intent.putExtra(EXTRA_MESSAGE,name);

           String Phone = eTextmobile.getText().toString();
            intent.putExtra(EXTRA_NUMBER,Phone);

            String room = spin.getSelectedItem().toString();
            intent.putExtra(EXTRA_TEXT,room);

            String date = eText.getText().toString();
           intent.putExtra(EXTRA_DATE, date);

            String time = eText2.getText().toString();
            intent.putExtra(EXTRA_TIME,time);

            //Start activity
            startActivity(intent);
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



}