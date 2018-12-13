package com.example.sebastianlimaco.inceptionserius.Client;

import com.example.sebastianlimaco.inceptionserius.JavaModelling.Trend.FeedTrend;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TrendingClient {

    @GET("/youtube/v3/videos") //-?
    Call<FeedTrend> getTrendingRequest (@Query("part") String part, //%2C+ for another tag
                                        @Query("chart") String chart,
                                        @Query("maxResults") int maxResults, //set to 20
                                        //@Query("videoCategoryId") int videoCategoryId, // 10 for music
                                        @Query("key") String YOUTUBE_API_KEY);
}
