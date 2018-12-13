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

import com.example.sebastianlimaco.inceptionserius.Activity.MusicActivity.PreviewActivity;
import com.example.sebastianlimaco.inceptionserius.Adapter.PlaylistAdapter;
import com.example.sebastianlimaco.inceptionserius.Client.PlaylistListClient;
import com.example.sebastianlimaco.inceptionserius.ItemModel.PlaylistModel;
import com.example.sebastianlimaco.inceptionserius.JavaModelling.PlayList.FeedPlaylist;
import com.example.sebastianlimaco.inceptionserius.JavaModelling.PlayList.SubTreeFeedPlaylist.Items;
import com.example.sebastianlimaco.inceptionserius.OnItemClickListenerInterface.Music_PlaylistFragment.OnItemClickListener;
import com.example.sebastianlimaco.inceptionserius.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PlaylistFragment extends Fragment {

    private static final String TAG = "PlaylistFragment";

    //"https://www.googleapis.com/youtube/v3/playlists?part=snippet&channelId=UCIeiHcHsb5CdXnuXmAnmZiw&maxResults=20&key={YOUR_API_KEY}";
    static String BASE_URL = "https://www.googleapis.com";

    /**for parameters in SearchQuery*/
    private static final String svPartParameter = "snippet";
    private static final String svChannelID = "UCIeiHcHsb5CdXnuXmAnmZiw";
    private static final int ivMaxResultsParameter = 20; //results per page
    private static final String YOUTUBE_API_KEY = "AIzaSyBbCXZD5Sa6arNhOP7R-eW3zrAuk_48Hy0";



    private RecyclerView rvwPlaylistList;
    private PlaylistAdapter pacPlaylistAdapter;
    static public ArrayList<PlaylistModel> alPlaylistList = new ArrayList<>();


    public PlaylistFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vwRoot = inflater.inflate(R.layout.fragment_playlist, container, false);

        rvwPlaylistList = vwRoot.findViewById(R.id.rvwMusicPlaylistList);
        sendingNetworkRequest();

        return vwRoot;
    }

    public void sendingNetworkRequest() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //for converting from JSON to GSON
                .build();

        PlaylistListClient client = retrofit.create(PlaylistListClient.class);

        //String svRequestFull= "https://www.googleapis.com/youtube/v3/playlists?" +
                //"part="+ svPartParameter +
                //"&channelId=" + svChannelID +
                //"&maxResults="+ ivMaxResultsParameter +
                //"&key="+YOUTUBE_API_KEY;

        Call<FeedPlaylist> call = client.getPlaylistRequest(svPartParameter, svChannelID, ivMaxResultsParameter, YOUTUBE_API_KEY);

        call.enqueue(new Callback<FeedPlaylist>() {
            @Override
            public void onResponse(Call<FeedPlaylist> call, Response<FeedPlaylist> response) {
                Log.d(TAG, "onResponse: Server Response" + response.toString());
                //Log.d(TAG, "onResponse: received information: " + response.body().toString());

                ArrayList<Items> itemsArrayList = response.body().getItems();
                initPlaylistList(itemsArrayList);
            }

            @Override
            public void onFailure(Call<FeedPlaylist> call, Throwable t) {
                Log.e(TAG, "onFailure: Something went wrong" + t.getMessage());
                Toast.makeText(getContext(), "Something went Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initPlaylistList(ArrayList<Items> JAVAitemList) {
        for(int i = 0; i< JAVAitemList.size(); i++) {
            PlaylistModel playlistModel = new PlaylistModel();
            playlistModel.setSvTitle(JAVAitemList.get(i).getSnippet().getTitle());
            playlistModel.setSvDescription(JAVAitemList.get(i).getSnippet().getDescription());
            playlistModel.setSvThumbnailURL(JAVAitemList.get(i).getSnippet().getThumbnails().getHigh().getUrl());
            playlistModel.setSvPlaylistID(JAVAitemList.get(i).getId());
            //could add additional Variables in videomodel for more versatility
            alPlaylistList.add(playlistModel);
        }
        OnItemClickListener clickListener = new OnItemClickListener() {
            @Override
            public void onItemClick(PlaylistModel item) {
                PlaylistModel playlistModel = item;
                Intent intent = new Intent(getContext(), PreviewActivity.class);
                intent.putExtra(PlaylistModel.class.toString(),playlistModel); //continues in next Activity!!
                startActivity(intent);
            }

        };
        rvwPlaylistList.setLayoutManager(new LinearLayoutManager(getContext()));
        pacPlaylistAdapter = new PlaylistAdapter(getActivity(), alPlaylistList, clickListener);
        rvwPlaylistList.setAdapter(pacPlaylistAdapter);
    }

}
