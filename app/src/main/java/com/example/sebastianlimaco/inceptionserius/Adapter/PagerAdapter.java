package com.example.sebastianlimaco.inceptionserius.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.sebastianlimaco.inceptionserius.Fragment.MusicActivity.PlaylistFragment;
import com.example.sebastianlimaco.inceptionserius.Fragment.MusicActivity.TroveFragment;


public class PagerAdapter extends FragmentStatePagerAdapter {

    int ivNumberOfTabsPA;

    public PagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.ivNumberOfTabsPA = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                PlaylistFragment pfTab1 = new PlaylistFragment();
                return pfTab1;
            case 1:
                TroveFragment tfTab2 = new TroveFragment();
                return tfTab2;
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return ivNumberOfTabsPA;
    }
}
