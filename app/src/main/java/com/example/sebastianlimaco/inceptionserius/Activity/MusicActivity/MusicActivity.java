package com.example.sebastianlimaco.inceptionserius.Activity.MusicActivity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sebastianlimaco.inceptionserius.R;

public class MusicActivity extends AppCompatActivity {

    private TabLayout tlMusicLayout;
    private ViewPager vwpMainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        tlMusicLayout = findViewById(R.id.tlMusicTabLayout);
        vwpMainView = findViewById(R.id.vpMusicViewPager);

        //setting up TabLayout "tlMusicLayout"
        tlMusicLayout.addTab(tlMusicLayout.newTab().setText("Themed Music"));
        tlMusicLayout.addTab(tlMusicLayout.newTab().setText("Unique Music"));

        //settings toolbar
        android.support.v7.widget.Toolbar tbMusicTitleBar = findViewById(R.id.tbMusicTitleBar);
        setSupportActionBar(tbMusicTitleBar);
        getSupportActionBar().setTitle(R.string.svMusicTag);

        final PagerAdapter paMainAdapter = new com.example.sebastianlimaco.inceptionserius.Adapter.PagerAdapter
                (getSupportFragmentManager(), tlMusicLayout.getTabCount());

        vwpMainView.setAdapter(paMainAdapter);
        vwpMainView.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tlMusicLayout));

        tlMusicLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vwpMainView.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
