package com.example.sebastianlimaco.inceptionserius.Client;

import com.example.sebastianlimaco.inceptionserius.JavaModelling.Trove.FeedTrove;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface TroveClient {
    //@GET
    //Call<FeedTrove> getTroveItemListRequest(@Url String url);

    @GET("/youtube/v3/videos") //-?
    Call<FeedTrove> getTroveItemListRequest (@Query("part") String part,
                                        @Query("id") String id,
                                        @Query("key") String YOUTUBE_API_KEY);
}
