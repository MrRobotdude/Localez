package com.project.localez;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Adapter extends FragmentPagerAdapter {

    int count;

    public Adapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        count = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Popular();
            case 1:
                return new Health();
            case 2:
                return new Sport();
            case 3:
                return new Technology();
            case 4:
                return new Business();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return count;
    }
}
