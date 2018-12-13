package com.example.sebastianlimaco.inceptionserius.Activity.SearchActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sebastianlimaco.inceptionserius.Activity.PlayerActivityVersions.SearchPlayerActivity;
import com.example.sebastianlimaco.inceptionserius.Adapter.SearchAdapter;
import com.example.sebastianlimaco.inceptionserius.Client.SearchListClient;
import com.example.sebastianlimaco.inceptionserius.OnItemClickListenerInterface.OnItemClickListener;
import com.example.sebastianlimaco.inceptionserius.ItemModel.VideoModel;
import com.example.sebastianlimaco.inceptionserius.JavaModelling.Video.FeedVideo;
import com.example.sebastianlimaco.inceptionserius.JavaModelling.Video.SubTreeFeedVideo.Items;
import com.example.sebastianlimaco.inceptionserius.R;

import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Call;


public class SearchActivity extends AppCompatActivity {

    private static final String TAG = "SearchActivity";

    private RecyclerView rvwSearchedItemList;
    private SearchAdapter sacSearchAdapter; //c for class xD
    static public ArrayList<VideoModel> alSearchedVideoList = new ArrayList<>();

    private EditText etUserInput;
    private Button btnSearchUpdate;
    private String svSearchRequest;

    /**for parameters in SearchQuery*/
    private static final String svPartParameter = "id%2C+snippet";
    private static final String ivMaxResultsParameter = "20"; //results per page
    private static final String svOrderParameter = "viewCount"; //defined by YouTube-API
    private static String query; //method for this one
    private static final String svTypeParameter = "video"; //defined by YouTube-API
    private static final String svVideoCategoryIDParameter = "10";// ID for just music marked videos**/
    static final String YOUTUBE_API_KEY = "AIzaSyBbCXZD5Sa6arNhOP7R-eW3zrAuk_48Hy0";
    final String BASE_URL = "https://www.googleapis.com/";
    //final String MAIN_URL = "https://www.googleapis.com/youtube/v3/";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //settings toolbar
        android.support.v7.widget.Toolbar tbSearchTitleBar = findViewById(R.id.tbSearchTitleBar);
        setSupportActionBar(tbSearchTitleBar);
        getSupportActionBar().setTitle(R.string.svSearchTag); //possibility to put logo and subtitle through toolbar

        //setting Views
        rvwSearchedItemList = findViewById(R.id.rvwSearchedItemList);
        etUserInput = findViewById(R.id.etUserInput);
        etUserInput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    switch (keyCode)
                    {
                        case KeyEvent.KEYCODE_ENTER:
                            onEnterPressed();
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });
        btnSearchUpdate = findViewById(R.id.btnSearchUpdate);
        btnSearchUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clearing old SearchRequest
                alSearchedVideoList.clear();
                svSearchRequest = etUserInput.getText().toString();
                query = cleaningSearchRequest(svSearchRequest);
                sendingNetworkRequest(query);
            }
        });
    }


    public void sendingNetworkRequest(String svSearchQuery) {

        Retrofit retrofit = new Retrofit.Builder()
                                        .baseUrl(BASE_URL)
                                        .addConverterFactory(GsonConverterFactory.create()) //for converting from JSON to GSON
                                        .build();

        SearchListClient client = retrofit.create(SearchListClient.class);

        //NOTE: it is truly an ugly way of doing the search request, but I tried using QUERY from retrofit,
        //      but couldn't find out how to make a dynamic parameter, that is custom-made, therefore I used a dynamic link

        String svRequestFull= "https://www.googleapis.com/youtube/v3/search?" +
                "part=" + svPartParameter +
                "&maxResults="+ ivMaxResultsParameter +
                "&order=" + svOrderParameter +
                "&q=" + svSearchQuery +
                "&type=" + svTypeParameter +
                "&videoCategoryId=" + svVideoCategoryIDParameter +
                "&key=" + YOUTUBE_API_KEY;


        Call<FeedVideo> call = client.getSearchRequest(svRequestFull);

        call.enqueue(new Callback<FeedVideo>() {
            @Override
            public void onResponse(Call<FeedVideo> call, Response<FeedVideo> response) {
                ArrayList<Items> itemsArrayList = response.body().getItems();
                initSearchedVideoList(itemsArrayList);
            }

            @Override
            public void onFailure(Call<FeedVideo> call, Throwable t) {
                Log.e(TAG, "onFailure: Something went wrong" + t.getMessage());
                Toast.makeText(SearchActivity.this, "Something went Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initSearchedVideoList(final ArrayList<Items> JAVAitemList) {
        for(int i = 0; i< JAVAitemList.size(); i++) {
            VideoModel videoModel = new VideoModel();
            videoModel.setSvTitle(JAVAitemList.get(i).getSnippet().getTitle());
            videoModel.setSvDescription(JAVAitemList.get(i).getSnippet().getDescription());
            videoModel.setSvThumbnailURL(JAVAitemList.get(i).getSnippet().getThumbnails().getMedium().getUrl());
            videoModel.setSvVideoID(JAVAitemList.get(i).getId().getVideoId());
            //could add additional Variables in videomodel for more versatility
            alSearchedVideoList.add(videoModel);
        }

            OnItemClickListener clickListener = new OnItemClickListener() {
            @Override
            public void onItemClick(VideoModel item) {
                VideoModel videoModel = item;
                Intent intent = new Intent(SearchActivity.this, SearchPlayerActivity.class);
                intent.putExtra(VideoModel.class.toString(),videoModel); //continues in next Activity!!
                startActivity(intent);
            }
        };
        rvwSearchedItemList.setLayoutManager(new LinearLayoutManager(this));
        sacSearchAdapter = new SearchAdapter(this, alSearchedVideoList, clickListener);
        rvwSearchedItemList.setAdapter(sacSearchAdapter);
    }

    public String cleaningSearchRequest(String query){
        String s1 = query.replaceAll("\\s+", " ").trim();
        String s2 = s1.replaceAll("%","%25");
        String s3 = s2.replace("+","%2B");
        String s4 = s3.replaceAll(" ", "+");
        String s5 = s4.replaceAll("&", "%26");
        String s6 = s5.replace("?", "%3F");
        String s7 = s6.replaceAll("=","%3D");
        String s8 = s7.replaceAll(",","%2C");
        String s9 = s8.replaceAll("%","%25");
        String networkSearchQuery = s9.replaceAll("#","%23");

        Log.d(TAG, "cleaningSearchRequest: " + networkSearchQuery);
        return networkSearchQuery;
    }

    public void onEnterPressed() {
        alSearchedVideoList.clear();
        svSearchRequest = etUserInput.getText().toString();
        query = cleaningSearchRequest(svSearchRequest);
        sendingNetworkRequest(query);
    }
}
