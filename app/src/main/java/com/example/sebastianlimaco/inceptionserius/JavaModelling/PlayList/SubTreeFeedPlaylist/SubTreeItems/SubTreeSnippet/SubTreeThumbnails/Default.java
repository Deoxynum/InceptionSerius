package com.example.sebastianlimaco.inceptionserius.JavaModelling.PlayList.SubTreeFeedPlaylist.SubTreeItems.SubTreeSnippet.SubTreeThumbnails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Default{

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("width")
    @Expose
    private int width;

    @SerializedName("height")
    @Expose
    private int height;

    /**
     * "url": "https://i.ytimg.com/vi/n92qIk6nU84/default.jpg",
     * "width": 120,
     * "height": 90
     */

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Default{" +
                "url='" + url + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}