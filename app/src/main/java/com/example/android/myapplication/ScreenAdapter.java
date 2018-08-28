package com.example.android.myapplication;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by macbook on 22.02.2018.
 */


public class ScreenAdapter extends FragmentPagerAdapter {
    public ScreenAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new CounterFragment();
        } else {
            return new DiscountFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Counter";
        } else {
            return "Discounts";
        }
    }
}