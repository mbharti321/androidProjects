package com.example.asynclab16;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mScheduleJob, mCancelJob;
    private static final String TAG = "MAIN ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScheduleJob = findViewById(R.id.scheduleJobBtn);
        mCancelJob = findViewById(R.id.cancelJobBtn);

        mScheduleJob.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View v) {
                ComponentName componentName = new ComponentName(MainActivity.this, ExampleJobService.class);
                JobInfo info = new JobInfo.Builder(123, componentName)
                        .setRequiresCharging(true)
                        .setRequiredNetworkType(JobInfo.NETWORK_TYPE_CELLULAR)
                        .setPersisted(true)
                        .setPeriodic(15*60*1000)
                        .build();

                JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
                int resultCode = scheduler.schedule(info);
                if (resultCode == JobScheduler.RESULT_SUCCESS) {
                    Log.d(TAG, "job scheduled");
                } else {
                    Log.d(TAG, "job scheduling failed");
                }
            }
        });

        mCancelJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
                scheduler.cancel(123);
                Log.d(TAG, "job cancelled");
            }
        });

    }
}