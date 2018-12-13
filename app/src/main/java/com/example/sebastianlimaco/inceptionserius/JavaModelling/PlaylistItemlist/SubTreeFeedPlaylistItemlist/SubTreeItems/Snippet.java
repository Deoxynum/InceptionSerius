package com.example.sebastianlimaco.inceptionserius.JavaModelling.PlaylistItemlist.SubTreeFeedPlaylistItemlist.SubTreeItems;

import com.example.sebastianlimaco.inceptionserius.JavaModelling.PlaylistItemlist.SubTreeFeedPlaylistItemlist.SubTreeItems.SubTreeSnippet.Thumbnails;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Snippet {
    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("thumbnails")
    @Expose
    private Thumbnails thumbnails;

    @SerializedName("playlistId")
    @Expose
    private String playlistId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Thumbnails thumbnails) {
        this.thumbnails = thumbnails;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    @Override
    public String toString() {
        return "Snippet{" +
                "title='" + title + '\'' +
                ", thumbnails=" + thumbnails +
                ", playlistId=" + playlistId +
                '}';
    }
}
