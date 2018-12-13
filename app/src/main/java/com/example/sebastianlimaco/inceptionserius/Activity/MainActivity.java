package com.example.sebastianlimaco.inceptionserius.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sebastianlimaco.inceptionserius.Activity.MusicActivity.MusicActivity;
import com.example.sebastianlimaco.inceptionserius.Activity.SearchActivity.SearchActivity;
import com.example.sebastianlimaco.inceptionserius.R;

public class MainActivity extends AppCompatActivity {

    public Button btnSearch;
    public Button btnMusic;
    public Button btnTrend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting custom toolbar
        android.support.v7.widget.Toolbar tbMainTitleBar = findViewById(R.id.tbMainTitelBar);
        setSupportActionBar(tbMainTitleBar);

        //initializing buttons with OnClick-method
        initButtons();

    }

    public void initButtons (){
        btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iOpenSA = new Intent(btnSearch.getContext(), SearchActivity.class);
                startActivity(iOpenSA);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
        btnMusic = findViewById(R.id.btnMusic);
        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iOpenMA = new Intent(btnMusic.getContext(), MusicActivity.class);
                startActivity(iOpenMA);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        btnTrend = findViewById(R.id.btnTrend);
        btnTrend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iOpenTA = new Intent(btnTrend.getContext(), TrendActivity.class);
                startActivity(iOpenTA);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
    }

}
