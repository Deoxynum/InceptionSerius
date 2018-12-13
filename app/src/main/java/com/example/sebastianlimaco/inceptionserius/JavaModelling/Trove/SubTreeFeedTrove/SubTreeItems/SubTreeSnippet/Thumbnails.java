package com.example.sebastianlimaco.inceptionserius.JavaModelling.Trove.SubTreeFeedTrove.SubTreeItems.SubTreeSnippet;

import com.example.sebastianlimaco.inceptionserius.JavaModelling.Trove.SubTreeFeedTrove.SubTreeItems.SubTreeSnippet.SubTreeThumbnails.Medium;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thumbnails {
    @SerializedName("medium")
    @Expose
    private Medium medium;

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    @Override
    public String toString() {
        return "Thumbnails{" +
                "medium=" + medium +
                '}';
    }
}
