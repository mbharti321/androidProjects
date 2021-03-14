package com.example.lab_13;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem t1, t2, t3, t4;
    public PageAdapter pagerAdapter;

    Button f1, f2, f3, f4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialising the variables
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        t1 = (TabItem) findViewById(R.id.summer);
        t2 = (TabItem) findViewById(R.id.winter);
        t3 = (TabItem) findViewById(R.id.autumn);
        t4 = (TabItem) findViewById(R.id.rainy);

        ViewPager vp = findViewById(R.id.view_pager);

        pagerAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        vp.setAdapter(pagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                vp.setCurrentItem(tab.getPosition());
                vp.setOffscreenPageLimit(4);
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }


}


