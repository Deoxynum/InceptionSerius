package com.example.sebastianlimaco.inceptionserius.Client;

import com.example.sebastianlimaco.inceptionserius.JavaModelling.PlayList.FeedPlaylist;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface PlaylistListClient {
    //@GET
    //Call<FeedPlaylist> getPlaylistRequest(@Url String url);

    @GET("/youtube/v3/playlists")
    Call<FeedPlaylist> getPlaylistRequest (@Query("part") String part,
                                           @Query("channelId") String channelId,
                                           @Query("maxResults") int maxResults,
                                           @Query("key") String YOUTUBE_API_KEY);
}
