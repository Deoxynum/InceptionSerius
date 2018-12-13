package com.example.sebastianlimaco.inceptionserius.JavaModelling.PlayList.SubTreeFeedPlaylist.SubTreeItems.SubTreeSnippet;

import com.example.sebastianlimaco.inceptionserius.JavaModelling.PlayList.SubTreeFeedPlaylist.SubTreeItems.SubTreeSnippet.SubTreeThumbnails.Default;
import com.example.sebastianlimaco.inceptionserius.JavaModelling.PlayList.SubTreeFeedPlaylist.SubTreeItems.SubTreeSnippet.SubTreeThumbnails.High;
import com.example.sebastianlimaco.inceptionserius.JavaModelling.PlayList.SubTreeFeedPlaylist.SubTreeItems.SubTreeSnippet.SubTreeThumbnails.Medium;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thumbnails {

    @SerializedName("default")
    @Expose
    private Default defaultSize;

    @SerializedName("medium")
    @Expose
    private Medium medium;

    @SerializedName("high")
    @Expose
    private High high;



    /**
     * "default": {
     * "url": "https://i.ytimg.com/vi/n92qIk6nU84/default.jpg",
     * "width": 120,
     * "height": 90
     *},
     * "medium": {
     *"url": "https://i.ytimg.com/vi/n92qIk6nU84/mqdefault.jpg",
     * "width": 320,
     * "height": 180
     * },
     * "high": {
     * "url": "https://i.ytimg.com/vi/n92qIk6nU84/hqdefault.jpg",
     * "width": 480,
     * "height": 360
     * }
     */

    public Default getDefaultSize() {
        return defaultSize;
    }

    public void setDefaultSize(Default defaultSize) {
        this.defaultSize = defaultSize;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public High getHigh() {
        return high;
    }

    public void setHigh(High high) {
        this.high = high;
    }

    @Override
    public String toString() {
        return "Thumbnails{" +
                "defaultSize=" + defaultSize +
                ", medium=" + medium +
                ", high=" + high +
                '}';
    }
}