package com.example.sebastianlimaco.inceptionserius.Client;

import com.example.sebastianlimaco.inceptionserius.JavaModelling.PlaylistItemlist.FeedPlaylistItemlist;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface PlaylistItemlistClient {
    //@GET
    //Call<FeedPlaylistItemlist> getPlaylistItemlistRequest(@Url String url);

    @GET("/youtube/v3/playlistItems") //-?
    Call<FeedPlaylistItemlist> getPlaylistItemlistRequest (@Query("part") String part,
                                        @Query("playlistId") String playlistId,
                                        @Query("key") String YOUTUBE_API_KEY);
}
