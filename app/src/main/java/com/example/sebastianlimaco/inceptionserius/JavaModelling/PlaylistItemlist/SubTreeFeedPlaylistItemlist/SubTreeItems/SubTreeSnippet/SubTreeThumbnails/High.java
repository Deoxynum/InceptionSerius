package com.example.sebastianlimaco.inceptionserius.JavaModelling.PlaylistItemlist.SubTreeFeedPlaylistItemlist.SubTreeItems.SubTreeSnippet.SubTreeThumbnails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class High {
    @SerializedName("url")
    @Expose
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "High{" +
                "url='" + url + '\'' +
                '}';
    }
}
