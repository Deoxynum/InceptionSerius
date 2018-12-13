package com.example.sebastianlimaco.inceptionserius.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.sebastianlimaco.inceptionserius.Activity.PlayerActivityVersions.PlayerTrendActivity;
import com.example.sebastianlimaco.inceptionserius.Adapter.TrendAdapter;
import com.example.sebastianlimaco.inceptionserius.Client.TrendingClient;
import com.example.sebastianlimaco.inceptionserius.ItemModel.TrendModel;
import com.example.sebastianlimaco.inceptionserius.JavaModelling.Trend.FeedTrend;
import com.example.sebastianlimaco.inceptionserius.JavaModelling.Trend.SubTreeFeedTrend.Items;
import com.example.sebastianlimaco.inceptionserius.OnItemClickListenerInterface.Trend.OnItemClickListener;
import com.example.sebastianlimaco.inceptionserius.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TrendActivity extends AppCompatActivity {
    private static final String TAG = "TrendActivity";

    private RecyclerView rvwTrendItemlist;
    private TrendAdapter tacTrendAdapter;
    private ArrayList<TrendModel> alTrendVideoList = new ArrayList<>();
    //GET https://www.googleapis.com/youtube/v3/videos?part=snippet&chart=mostPopular&maxResults=20&videoCategoryId=10&key={YOUR_API_KEY}
    static String BASE_URL = "https://www.googleapis.com";

    static String svPart = "snippet";
    static String svChart = "mostPopular";
    static int ivMaxResults = 50;
    static int ivVideoCategoryId = 10;
    static final String YOUTUBE_API_KEY = "AIzaSyBbCXZD5Sa6arNhOP7R-eW3zrAuk_48Hy0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trend);

        android.support.v7.widget.Toolbar tbTrendTitleBar = findViewById(R.id.tbTrendTitleBar);
        setSupportActionBar(tbTrendTitleBar);
        getSupportActionBar().setTitle(R.string.svTrendTag);

        rvwTrendItemlist = findViewById(R.id.rvwTrendItemlist);
        sendingNetworkRequest();
    }

    public void sendingNetworkRequest() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TrendingClient client = retrofit.create(TrendingClient.class);

        //NOTE: ivVideoCategoryId resulted somehow in a empty response, was previously okay though
        Call<FeedTrend> call = client.getTrendingRequest(svPart, svChart, ivMaxResults, YOUTUBE_API_KEY); //ivVideoCategoryId

        call.enqueue(new Callback<FeedTrend>() {
            @Override
            public void onResponse(Call<FeedTrend> call, Response<FeedTrend> response) {
                Log.d(TAG, "onResponse: Server Response" + response.toString());
                Log.d(TAG, "onResponse: received information: " + response.body().toString());

                ArrayList<Items> itemsArrayList = response.body().getItems();
                initTrendVideoList(itemsArrayList);
            }

            @Override
            public void onFailure(Call<FeedTrend> call, Throwable t) {
                Log.e(TAG, "onFailure: Something went wrong" + t.getMessage());
                Toast.makeText(TrendActivity.this, "Something went Wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initTrendVideoList(ArrayList<Items> itemsArrayList) {
        for(int i = 0; i< itemsArrayList.size(); i++) {
            TrendModel trendModel = new TrendModel();
            trendModel.setSvTitle(itemsArrayList.get(i).getSnippet().getTitle());
            trendModel.setSvDescription(itemsArrayList.get(i).getSnippet().getDescription());
            trendModel.setSvThumbnailMediumURL(itemsArrayList.get(i).getSnippet().getThumbnails().getMedium().getUrl());
            trendModel.setSvThumbnailHighURL(itemsArrayList.get(i).getSnippet().getThumbnails().getHigh().getUrl());
            trendModel.setSvVideoID(itemsArrayList.get(i).getId());
            //could add additional variables in videomodel for more versatility
            alTrendVideoList.add(trendModel);
        }

        OnItemClickListener clickListener = new OnItemClickListener() {
            @Override
            public void onItemClick(TrendModel item) {
                TrendModel trendModel = item;
                Intent intent = new Intent(TrendActivity.this, PlayerTrendActivity.class);
                intent.putExtra(TrendModel.class.toString(),trendModel); //continues in next Activity!!
                startActivity(intent);
            }
        };

        rvwTrendItemlist.setLayoutManager(new LinearLayoutManager(this));
        tacTrendAdapter = new TrendAdapter(this, alTrendVideoList, clickListener);
        rvwTrendItemlist.setAdapter(tacTrendAdapter);
    }
}
