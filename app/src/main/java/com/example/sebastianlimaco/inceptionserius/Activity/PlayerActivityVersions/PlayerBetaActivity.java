package com.example.sebastianlimaco.inceptionserius.Activity.PlayerActivityVersions;

import android.os.Bundle;
import android.util.Log;

import com.example.sebastianlimaco.inceptionserius.ItemModel.PlaylistItemlistModel;
import com.example.sebastianlimaco.inceptionserius.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PlayerBetaActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{
    private static final String TAG = "PlayerBetaActivity";

    private YouTubePlayerView ypvwPlaylistPlayer;
    private static final String API_KEY = "AIzaSyBbCXZD5Sa6arNhOP7R-eW3zrAuk_48Hy0";
    static String svPlaylistID;
    static int ivID;

    private static PlaylistItemlistModel playlistItemlistModel;


    private final String MAIN_URL = "https://www.googleapis.com/youtube/v3/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_beta);

        playlistItemlistModel = getIntent().getParcelableExtra(PlaylistItemlistModel.class.toString());
        Log.d(TAG, "onCreate: playlistItemlistModel.getSvPlaylistID():" +playlistItemlistModel.getSvPlaylistID());

        ypvwPlaylistPlayer = findViewById(R.id.ypvwVideoPlayerBeta);
        ypvwPlaylistPlayer.initialize(API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        if(!wasRestored){
            youTubePlayer.cuePlaylist(playlistItemlistModel.getSvPlaylistID(), playlistItemlistModel.getIvID(), 1);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

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
