package com.example.sebastianlimaco.inceptionserius.JavaModelling.Trove.SubTreeFeedTrove;

import com.example.sebastianlimaco.inceptionserius.JavaModelling.Trove.SubTreeFeedTrove.SubTreeItems.Snippet;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Items {
    @SerializedName("snippet")
    @Expose
    private Snippet snippet;

    @SerializedName("id")
    @Expose
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }


    @Override
    public String toString() {
        return "Items{" +
                "snippet=" + snippet +
                ", id='" + id + '\'' +
                '}';
    }
}
