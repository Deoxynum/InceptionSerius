package com.example.sebastianlimaco.inceptionserius.JavaModelling.Trend.SubTreeFeedTrend.SubTreeItems.SubTreeSnippet;

import com.example.sebastianlimaco.inceptionserius.JavaModelling.Trend.SubTreeFeedTrend.SubTreeItems.SubTreeSnippet.SubTreeThumbnails.High;
import com.example.sebastianlimaco.inceptionserius.JavaModelling.Trend.SubTreeFeedTrend.SubTreeItems.SubTreeSnippet.SubTreeThumbnails.Medium;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thumbnails {
    @SerializedName("medium")
    @Expose
    private Medium medium;

    @SerializedName("high")
    @Expose
    private High high;

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
                "medium=" + medium +
                ", high=" + high +
                '}';
    }
}
