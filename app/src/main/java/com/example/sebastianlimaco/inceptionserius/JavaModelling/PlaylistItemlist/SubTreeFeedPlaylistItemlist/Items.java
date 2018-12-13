package com.example.sebastianlimaco.inceptionserius.JavaModelling.PlaylistItemlist.SubTreeFeedPlaylistItemlist;

import com.example.sebastianlimaco.inceptionserius.JavaModelling.PlaylistItemlist.SubTreeFeedPlaylistItemlist.SubTreeItems.Snippet;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Items {
    @SerializedName("snippet")
    @Expose
    private Snippet snippet;

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
                '}';
    }
}
