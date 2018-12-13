package com.example.sebastianlimaco.inceptionserius.Client;

import com.example.sebastianlimaco.inceptionserius.JavaModelling.Video.FeedVideo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface VideoListClient {

    @GET
    Call<FeedVideo> getSearchRequest(@Url String url);
}
