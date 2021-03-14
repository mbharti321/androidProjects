package com.example.lab_13;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class PageAdapter extends FragmentPagerAdapter {
    private int numOfTabs;

    public PageAdapter(@NonNull FragmentManager fm, int behaviour) {
        super(fm,  behaviour);
        this.numOfTabs =  behaviour;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Summer();
            case 1:
                return new Winter();
            case 2:
                return new Autumn();
            case 3:
                return new Rainy();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }

}
