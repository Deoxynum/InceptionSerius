package com.example.sebastianlimaco.inceptionserius.JavaModelling.PlaylistItemlist;

import com.example.sebastianlimaco.inceptionserius.JavaModelling.PlaylistItemlist.SubTreeFeedPlaylistItemlist.Items;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FeedPlaylistItemlist {
    @SerializedName("items")
    @Expose
    private ArrayList<Items> items;

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "FeedPlaylistItemlist{" +
                "items=" + items +
                '}';
    }
}
