package com.example.sebastianlimaco.inceptionserius.Adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import com.example.sebastianlimaco.inceptionserius.Fragment.MusicActivity.PreviewActivity.DescriptionFragment;
import com.example.sebastianlimaco.inceptionserius.Fragment.MusicActivity.PreviewActivity.ItemlistFragment;


public class SwipeAdapter extends FragmentStatePagerAdapter {
    private int ivNumberOfPagesSA;
    private String svInfoDescription;
    private String svInfoPlaylistID;

    private static Bundle bundleDescription = new Bundle();
    private static Bundle bundlePlaylistID = new Bundle();

    public SwipeAdapter(FragmentManager fm, int numberOfPages, String infoDescription, String infoPlaylistID) {
        super(fm);
        this.ivNumberOfPagesSA = numberOfPages;
        svInfoDescription = infoDescription;
        svInfoPlaylistID = infoPlaylistID;


        bundleDescription.putString("svDescription", svInfoDescription);
        bundlePlaylistID.putString("svPlaylistID", svInfoPlaylistID);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                DescriptionFragment dfPage1 = new DescriptionFragment();
                dfPage1.setArguments(bundleDescription);
                return dfPage1;
            case 1:
                ItemlistFragment ifPage2 = new ItemlistFragment();
                ifPage2.setArguments(bundlePlaylistID);
                return ifPage2;
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return ivNumberOfPagesSA;
    }
}