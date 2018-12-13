package com.example.sebastianlimaco.inceptionserius.Fragment.MusicActivity.PreviewActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sebastianlimaco.inceptionserius.Activity.MusicActivity.PreviewActivity;

import com.example.sebastianlimaco.inceptionserius.Adapter.PlaylistItemlistAdapter;
import com.example.sebastianlimaco.inceptionserius.Client.PlaylistItemlistClient;
import com.example.sebastianlimaco.inceptionserius.ItemModel.PlaylistItemlistModel;
import com.example.sebastianlimaco.inceptionserius.JavaModelling.PlaylistItemlist.FeedPlaylistItemlist;
import com.example.sebastianlimaco.inceptionserius.JavaModelling.PlaylistItemlist.SubTreeFeedPlaylistItemlist.Items;
import com.example.sebastianlimaco.inceptionserius.OnItemClickListenerInterface.Music_Preview_ItemlistFragment.OnItemClickListener;
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
public class ItemlistFragment extends Fragment {
    private static final String TAG = "ItemlistFragment";



    private RecyclerView rvwPlaylistItemist;
    private PlaylistItemlistAdapter piacPlaylistAdapter;
    static public ArrayList<PlaylistItemlistModel> alPlaylistItemlist = new ArrayList<>();

    static String BASE_URL = "https://www.googleapis.com";
    // GET https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLH_wzEY1hu00aQCGk-gkzOm_ikCr4-oAu&key={YOUR_API_KEY}
    private static final String svPartParameter = "snippet";
    public static String svPlaylistID;
    private static final String YOUTUBE_API_KEY = "AIzaSyBbCXZD5Sa6arNhOP7R-eW3zrAuk_48Hy0";


    public ItemlistFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vwRoot = inflater.inflate(R.layout.fragment_itemlist, container, false);

        Bundle playlistID = getArguments();
        svPlaylistID = playlistID.getString("svPlaylistID");


        alPlaylistItemlist = new ArrayList<>();
        rvwPlaylistItemist = vwRoot.findViewById(R.id.rvwPreviewItemlist);
        sendingNetworkRequest();


        return vwRoot;
    }

    public void sendingNetworkRequest() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PlaylistItemlistClient client = retrofit.create(PlaylistItemlistClient.class);

        //String svRequestFull= "https://www.googleapis.com/youtube/v3/playlistItems?" +
                //"part="+ svPartParameter +
                //"&playlistId=" + svPlaylistID +
                //"&key="+YOUTUBE_API_KEY;

        Call<FeedPlaylistItemlist> call = client.getPlaylistItemlistRequest(svPartParameter, svPlaylistID, YOUTUBE_API_KEY);

        call.enqueue(new Callback<FeedPlaylistItemlist>() {
            @Override
            public void onResponse(Call<FeedPlaylistItemlist> call, Response<FeedPlaylistItemlist> response) {
                Log.d(TAG, "onResponse: Server Response" + response.toString());
                Log.d(TAG, "onResponse: received information: " + response.body().toString());

                ArrayList<Items> itemsArrayList = response.body().getItems();
                initPlaylistList(itemsArrayList);
            }

            @Override
            public void onFailure(Call<FeedPlaylistItemlist> call, Throwable t) {
                Log.e(TAG, "onFailure: Something went wrong" + t.getMessage());
                Toast.makeText(getContext(), "Something went Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initPlaylistList(ArrayList<Items> JAVAitemList) {
        for(int i = 0; i< JAVAitemList.size(); i++) {
            PlaylistItemlistModel playlistItemlistModel = new PlaylistItemlistModel();
            playlistItemlistModel.setSvTitle(JAVAitemList.get(i).getSnippet().getTitle());
            playlistItemlistModel.setSvThumbnailURL(JAVAitemList.get(i).getSnippet().getThumbnails().getHigh().getUrl());
            playlistItemlistModel.setSvPlaylistID(JAVAitemList.get(i).getSnippet().getPlaylistId());
            playlistItemlistModel.setIvID(i);
            //could add additional variables in videomodel for more versatility
            alPlaylistItemlist.add(playlistItemlistModel);
        }

        OnItemClickListener clickListener = new OnItemClickListener() {
            @Override
            public void onItemClick(PlaylistItemlistModel item) {
                PlaylistItemlistModel playlistItemlistModel = item;
                ((PreviewActivity)getActivity()).changeVideoWithinList(playlistItemlistModel);

            }
        };

        rvwPlaylistItemist.setLayoutManager(new LinearLayoutManager(getContext()));
        piacPlaylistAdapter = new PlaylistItemlistAdapter(getActivity(), alPlaylistItemlist, clickListener);
        rvwPlaylistItemist.setAdapter(piacPlaylistAdapter);
    }

}
