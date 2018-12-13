package com.example.sebastianlimaco.inceptionserius.Activity.MusicActivity;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.widget.TextView;

import com.example.sebastianlimaco.inceptionserius.Adapter.SwipeAdapter;
import com.example.sebastianlimaco.inceptionserius.ItemModel.PlaylistItemlistModel;
import com.example.sebastianlimaco.inceptionserius.ItemModel.PlaylistModel;
import com.example.sebastianlimaco.inceptionserius.R;


import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

public class PreviewActivity extends AppCompatActivity {
    private static final String TAG = "PreviewActivity";

    public PlaylistModel pmcModelPBA;
    private TextView tvwPlaylistTitle;

    private ViewPager vwpViewPager;
    private SwipeAdapter sacAdapter;

    private YouTubePlayerSupportFragment youTubePlayerFragment;
    public YouTubePlayer youTubePlayer;
    static final String YOUTUBE_API_KEY = "AIzaSyBbCXZD5Sa6arNhOP7R-eW3zrAuk_48Hy0";
    //private ImageView ivwPlaylistPreview;

    static String svTitle;
    static String svDescription;
    static String svPlaylistID;

    static PlaylistItemlistModel playlistItemlistModel;

    //private final String MAIN_URL = "https://www.googleapis.com/youtube/v3/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        pmcModelPBA = getIntent().getParcelableExtra(PlaylistModel.class.toString());
        converter(pmcModelPBA);
        //passing information from PlaylistFragment to Viewpager
        svDescription = pmcModelPBA.getSvDescription();
        svPlaylistID = pmcModelPBA.getSvPlaylistID();

        //setting viewpager up
        vwpViewPager = findViewById(R.id.vwpViewPager);
        vwpViewPager.setOffscreenPageLimit(1);
        sacAdapter = new SwipeAdapter(getSupportFragmentManager(), 2, svDescription, svPlaylistID);
        vwpViewPager.setAdapter(sacAdapter);
        vwpViewPager.setCurrentItem(0);

        svTitle = pmcModelPBA.getSvTitle();
        tvwPlaylistTitle = findViewById(R.id.tvwTitlePsaA);
        tvwPlaylistTitle.setText(svTitle);

        initializeYoutubePlayer();
    }

    //NOTE: was made for passing data from fragment to a basic YouTube-Player Activity,
    //      but wasn't necessary anymore after the solution of using a fragment for the player and implementing it on the PreviewActivity
    //      --> is now used to tell position from playlist with the getIvID
    private void converter(PlaylistModel playlistModel) {
        playlistItemlistModel = new PlaylistItemlistModel();
        playlistItemlistModel.setSvTitle(playlistModel.getSvTitle());
        playlistItemlistModel.setSvThumbnailURL(playlistModel.getSvThumbnailURL());
        playlistItemlistModel.setSvPlaylistID(playlistModel.getSvPlaylistID());
        playlistItemlistModel.setIvID(0);
    }

    private void initializeYoutubePlayer() {

        youTubePlayerFragment = (YouTubePlayerSupportFragment) getSupportFragmentManager()
                .findFragmentById(R.id.youtube_player_fragment);

        if (youTubePlayerFragment == null)
            return;

        youTubePlayerFragment.initialize(YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
                                                boolean wasRestored) {
                if(!wasRestored){
                    youTubePlayer = player;
                    youTubePlayer.cuePlaylist(playlistItemlistModel.getSvPlaylistID(), playlistItemlistModel.getIvID(), 1);
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {
                //print or show error if initialization failed
                Log.e(TAG, "Youtube Player View initialization failed");
            }
        });
    }

    public void changeVideoWithinList(PlaylistItemlistModel item){
        if (youTubePlayerFragment != null && youTubePlayer != null) {
            //load selected video
            youTubePlayer.cuePlaylist(item.getSvPlaylistID(), item.getIvID(), 1);
        }
    }
}
