package com.example.sebastianlimaco.inceptionserius.Activity.PlayerActivityVersions;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sebastianlimaco.inceptionserius.ItemModel.TroveVideoModel;
import com.example.sebastianlimaco.inceptionserius.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PlayerTroveActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private static final String API_KEY = "AIzaSyBbCXZD5Sa6arNhOP7R-eW3zrAuk_48Hy0";
    private TroveVideoModel tvmcModelPGA;
    private TextView tvwVideoTitle;
    private TextView tvwDescription;
    public String svThumbnailURL;
    //private ImageView ivwThumbNail;
    static String svVideoID;
    private YouTubePlayerView ypvwVideoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_gamma);

        tvmcModelPGA = getIntent().getParcelableExtra(TroveVideoModel.class.toString());

        tvwVideoTitle = findViewById(R.id.tvwTitlePGA);
        tvwDescription = findViewById(R.id.tvwDescriptionPGA);

        tvwVideoTitle.setText(tvmcModelPGA.getSvTitle());
        tvwDescription.setText(tvmcModelPGA.getSvDescription());
        svThumbnailURL = tvmcModelPGA.getSvThumbnailURL();
        svVideoID = tvmcModelPGA.getSvVideoID();

        ypvwVideoPlayer = findViewById(R.id.ypvwVideoPlayerPGA);
        ypvwVideoPlayer.initialize(API_KEY, this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        if(!wasRestored){
            youTubePlayer.loadVideo(svVideoID);
        }

    }
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Failure to Initialize!", Toast.LENGTH_LONG).show();
    }

    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener(){

        @Override
        public void onPlaying() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };
}
