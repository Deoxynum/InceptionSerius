package com.example.sebastianlimaco.inceptionserius.Client;


import com.example.sebastianlimaco.inceptionserius.JavaModelling.Video.FeedVideo;
import com.example.sebastianlimaco.inceptionserius.JavaModelling.Video.SubTreeFeedVideo.Items;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface SearchListClient {
    String YOUTUBE_API_KEY = "AIzaSyBbCXZD5Sa6arNhOP7R-eW3zrAuk_48Hy0";
    String BASE_URL = "https://www.googleapis.com/";
    String SEARCH_REQUEST = "search?part=id%2C+snippet&maxResults=10&order=viewCount&q=vik&type=video&videoCategoryId=10&key=\"+YOUTUBE_API_KEY+\"\"";

    @GET
    Call<FeedVideo> getSearchRequest(@Url String url);

    /**
    @Headers("Content-Type: application/json")
    @GET("search")
    Call<FeedVideo> getPlaylistRequest (@Query("part") String part1, //%2C+ for another tag
                                      @Query("part") String part2,
                                      @Query("maxResults") int maxResults, //set to 10
                                      @Query("order") String order, //viewCount
                                      @Query ("q") String query, //searchRequest
                                      @Query("type") String type, //video
                                      @Query("videoCategoryId") int videoCategoryId, // 10 for music
                                      @Query("key") String YOUTUBE_API_KEY);**/


}
