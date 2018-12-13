package com.example.sebastianlimaco.inceptionserius.JavaModelling.Trend.SubTreeFeedTrend;

import com.example.sebastianlimaco.inceptionserius.JavaModelling.Trend.SubTreeFeedTrend.SubTreeItems.Snippet;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Items {
    @SerializedName("snippet")
    @Expose
    private Snippet snippet;

    @SerializedName("id")
    @Expose
    private String id;

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    @Override
    public String toString() {
        return "Items{" +
                "snippet=" + snippet +
                ", id='" + id + '\'' +
                '}';
    }
}
