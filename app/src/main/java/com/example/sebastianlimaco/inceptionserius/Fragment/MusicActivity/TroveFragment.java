package com.example.sebastianlimaco.inceptionserius.Fragment.MusicActivity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sebastianlimaco.inceptionserius.Activity.PlayerActivityVersions.PlayerTroveActivity;
import com.example.sebastianlimaco.inceptionserius.Adapter.TroveAdapter;
import com.example.sebastianlimaco.inceptionserius.Client.TroveClient;
import com.example.sebastianlimaco.inceptionserius.ItemModel.TroveVideoModel;
import com.example.sebastianlimaco.inceptionserius.JavaModelling.Trove.FeedTrove;
import com.example.sebastianlimaco.inceptionserius.JavaModelling.Trove.SubTreeFeedTrove.Items;
import com.example.sebastianlimaco.inceptionserius.OnItemClickListenerInterface.Music_TroveFragment.OnItemClickListener;
import com.example.sebastianlimaco.inceptionserius.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class TroveFragment extends Fragment {
    private static final String TAG = "TroveFragment";

    //wrong! for PLayerbeta subfragment: private String REQUEST_URL = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet%2C+contentDetails&playlistId=PLH_wzEY1hu00aQCGk-gkzOm_ikCr4-oAu&key={YOUR_API_KEY}";
    private String REQUEST_URL = "https://www.googleapis.com/youtube/v3/videos?part=snippet&id=Lx1e_fdnNxA%2C++qTSFl5O4acE&key={YOUR_API_KEY}";
    private final String MAIN_URL = "https://www.googleapis.com/youtube/v3/";

    private RecyclerView rvwTroveVideoList;
    private TroveAdapter tacTroveAdapter;
    static public ArrayList<TroveVideoModel> alTroveItemlist = new ArrayList<>();

    private static final String svPartParameter = "snippet";
    private static final String svIDParameter =
            "BTdBc2Ba8ts" + "," +
            "5OeR5XBEahU" + "," +
            "--BHuKeveg4" + "," +
            "vZPOiMzUBCE" + "," +
            "V1Pl8CzNzCw" + "," +
            "UOxkGD8qRB4" + "," +
            "WkVvG4QTO9M" + "," +
            "hPokJFyUq1s" + "," +
            "xlSLKQhLm5Q" + "," +
            "d1vQMIisJuc" + "," +
            "Ej_onDLqCPA" + "," +
            "HyHNuVaZJ-k" + "," +
            "pRfmrE0ToTo" + "," +
            "_fWiSYBFn8M" + "," +
            "WPiEbYSF9kE" + "," +
            "0R7NOVt_DJs" + "," +
            "0k6Ecz5uPV8" + "," +
            "h208HbsyTzs" + "," +
            "WnaarwLvgJI" + "," +
            "CvFH_6DNRCY" + "," +
            "HYmn5BQIxdQ";



    //defined by YouTube-API, divided by %2C, including all videos
    private static final String YOUTUBE_API_KEY = "AIzaSyBbCXZD5Sa6arNhOP7R-eW3zrAuk_48Hy0";


    public TroveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vwRoot = inflater.inflate(R.layout.fragment_trove, container, false);

        rvwTroveVideoList = vwRoot.findViewById(R.id.rvwTroveVideoList);
        sendingNetworkRequest();

        return vwRoot;
    }

    public void sendingNetworkRequest() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MAIN_URL)
                .addConverterFactory(GsonConverterFactory.create()) //for converting from JSON to GSON
                .build();

        TroveClient client = retrofit.create(TroveClient.class);

        //String svRequestFull= "https://www.googleapis.com/youtube/v3/videos?" +
                //"part="+ svPartParameter +
                //"&id=" + svIDParameter +
                //"&key="+ YOUTUBE_API_KEY;

        Call<FeedTrove> call = client.getTroveItemListRequest(svPartParameter, svIDParameter, YOUTUBE_API_KEY);

        call.enqueue(new Callback<FeedTrove>() {
            @Override
            public void onResponse(Call<FeedTrove> call, Response<FeedTrove> response) {
                Log.d(TAG, "onResponse: Server Response" + response.toString());
                Log.d(TAG, "onResponse: received information: " + response.body().toString());

                ArrayList<Items> itemsArrayList = response.body().getItems();
                initTroveItemlist(itemsArrayList);
            }

            @Override
            public void onFailure(Call<FeedTrove> call, Throwable t) {
                Log.e(TAG, "onFailure: Something went wrong" + t.getMessage());
                Toast.makeText(getContext(), "Something went Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initTroveItemlist(final ArrayList<Items> JAVAitemList) {
        for(int i = 0; i< JAVAitemList.size(); i++) {
            TroveVideoModel troveVideoModel = new TroveVideoModel();
            troveVideoModel.setSvTitle(JAVAitemList.get(i).getSnippet().getTitle());
            troveVideoModel.setSvDescription(JAVAitemList.get(i).getSnippet().getDescription());
            troveVideoModel.setSvThumbnailURL(JAVAitemList.get(i).getSnippet().getThumbnails().getMedium().getUrl());
            troveVideoModel.setSvVideoID(JAVAitemList.get(i).getId());
            //could add additional Variables in videomodel for more versatility
            alTroveItemlist.add(troveVideoModel);
        }

        OnItemClickListener clickListener = new OnItemClickListener() {
            @Override
            public void onItemClick(TroveVideoModel item) {
                TroveVideoModel troveVideoModel = item;
                Intent intent = new Intent(getContext(), PlayerTroveActivity.class);
                intent.putExtra(TroveVideoModel.class.toString(),troveVideoModel); //continues in next Activity!!
                startActivity(intent);
            }
        };
        rvwTroveVideoList.setLayoutManager(new LinearLayoutManager(getContext()));
        tacTroveAdapter = new TroveAdapter(getContext(), alTroveItemlist, clickListener);
        rvwTroveVideoList.setAdapter(tacTroveAdapter);
    }

}
