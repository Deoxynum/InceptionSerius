package com.example.sebastianlimaco.inceptionserius.Activity.PlayerActivityVersions;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sebastianlimaco.inceptionserius.Client.DescriptionClient;
import com.example.sebastianlimaco.inceptionserius.ItemModel.VideoModel;
import com.example.sebastianlimaco.inceptionserius.JavaModelling.Description.FeedDescription;
import com.example.sebastianlimaco.inceptionserius.JavaModelling.Description.SubTreeFeedDescription.Items;
import com.example.sebastianlimaco.inceptionserius.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchPlayerActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final String TAG = "SearchPlayerActivity";

    private static final String API_KEY = "AIzaSyBbCXZD5Sa6arNhOP7R-eW3zrAuk_48Hy0";
    private static VideoModel vmcModelPTA;
    private TextView tvwVideoTitle;
    private TextView tvwDescription;

    private YouTubePlayerView ypvwVideoPlayer;

    //Information for network request
    private static final String svPartParameter = "id,snippet";
    static String svVideoID;
    static final String YOUTUBE_API_KEY = "AIzaSyBbCXZD5Sa6arNhOP7R-eW3zrAuk_48Hy0";

    final String BASE_URL = "https://www.googleapis.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_delta);

        vmcModelPTA = getIntent().getParcelableExtra(VideoModel.class.toString());

        tvwVideoTitle = findViewById(R.id.tvwTitlePTA);
        tvwDescription = findViewById(R.id.tvwDescriptionPTA);

        tvwVideoTitle.setText(vmcModelPTA.getSvTitle());
        svVideoID = vmcModelPTA.getSvVideoID();

        ypvwVideoPlayer = findViewById(R.id.ypvwVideoPlayerPTA);
        ypvwVideoPlayer.initialize(API_KEY, this);

        sendingNetworkRequest(svVideoID);

    }

    private void sendingNetworkRequest(String svVideoID) {
     Retrofit retrofit = new Retrofit.Builder()
         .baseUrl(BASE_URL)
         .addConverterFactory(GsonConverterFactory.create())
         .build();

     DescriptionClient client = retrofit.create(DescriptionClient.class);

     //String svRequestFull= "https://www.googleapis.com/youtube/v3/videos?" +
         //"part="+ svPartParameter +
         //"&id=" + svVideoID +
         //"&key="+ YOUTUBE_API_KEY;

     Call<FeedDescription> call = client.getDescriptionRequest(svPartParameter, svVideoID, YOUTUBE_API_KEY );

     call.enqueue(new Callback<FeedDescription>() {
        @Override
        public void onResponse(Call<FeedDescription> call, Response<FeedDescription> response) {
            Log.d(TAG, "onResponse: Server Response" + response.toString());
            Log.d(TAG, "onResponse: received information:" + response.body().toString());

            ArrayList<Items> alInput = response.body().getItems();
            for(int i = 0; i<alInput.size(); i++){
                Log.d(TAG, "onResponse: \n" +
                "description:" + alInput.get(i).getSnippet().getDescription() + "\n"
                );
                Log.d(TAG, "onResponse: received information YELLOW: ");
            }
            initDescription(alInput);
        }
        @Override
        public void onFailure(Call<FeedDescription> call, Throwable t) {
            Log.e(TAG, "onFailure: Something went wrong" + t.getMessage());
            Toast.makeText(SearchPlayerActivity.this, "Something went Wrong", Toast.LENGTH_SHORT).show();
        }

        });
     }

    private void initDescription(ArrayList<Items> Input) {
        tvwDescription.setText(Input.get(0).getSnippet().getDescription());
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
