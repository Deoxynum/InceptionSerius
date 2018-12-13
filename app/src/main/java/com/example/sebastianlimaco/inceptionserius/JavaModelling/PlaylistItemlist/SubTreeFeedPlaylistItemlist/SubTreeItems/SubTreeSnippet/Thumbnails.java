package com.example.sebastianlimaco.inceptionserius.JavaModelling.PlaylistItemlist.SubTreeFeedPlaylistItemlist.SubTreeItems.SubTreeSnippet;

import com.example.sebastianlimaco.inceptionserius.JavaModelling.PlaylistItemlist.SubTreeFeedPlaylistItemlist.SubTreeItems.SubTreeSnippet.SubTreeThumbnails.High;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thumbnails {

    @SerializedName("high")
    @Expose
    private High high;

    public High getHigh() {
        return high;
    }

    public void setHigh(High high) {
        this.high = high;
    }

    @Override
    public String toString() {
        return "Thumbnails{" +
                "high=" + high +
                '}';
    }
}
