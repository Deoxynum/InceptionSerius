package com.example.sebastianlimaco.inceptionserius.JavaModelling.Trove.SubTreeFeedTrove.SubTreeItems.SubTreeSnippet.SubTreeThumbnails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Medium {
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
        return "Medium{" +
                "url='" + url + '\'' +
                '}';
    }
}
