package com.example.sebastianlimaco.inceptionserius.Client;

import com.example.sebastianlimaco.inceptionserius.JavaModelling.Description.FeedDescription;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface DescriptionClient {
    //@GET
    //Call<FeedDescription> getDescriptionRequest(@Url String url);

    @GET("/youtube/v3/videos")
    Call<FeedDescription> getDescriptionRequest (@Query("part") String part,
                                                 @Query("id") String id,
                                                 @Query("key") String YOUTUBE_API_KEY);
}
