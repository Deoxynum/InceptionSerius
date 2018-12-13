package com.example.sebastianlimaco.inceptionserius.JavaModelling.PlayList.SubTreeFeedPlaylist.SubTreeItems;

import com.example.sebastianlimaco.inceptionserius.JavaModelling.PlayList.SubTreeFeedPlaylist.SubTreeItems.SubTreeSnippet.Thumbnails;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Snippet {

    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;

    @SerializedName("channelId")
    @Expose
    private String channelId;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("thumbnails")
    @Expose
    private Thumbnails thumbnails;

    @SerializedName("channelTitle")
    @Expose
    private String channelTitle;

    //Wont use it
    //@SerializedName("liveBroadcastContent")
    //@Expose
    //private String liveBroadcastContent;



    /**
     * "publishedAt": "2018-02-12T04:30:03.000Z",
     *     "channelId": "UCopY0NAzASqmD6eVaRj2TFQ", //GO TO CHANNEL OPTION?
     *     "title": "Teeje Week (Full Song) Jordan Sandhu | Bunty Bains | Sonia Mann, New Punjabi Songs 2018 | White Hill",
     *     "description": "White Hill Music proudly presents the new Punjabi songs 2018 \"Teeje Week\" Produced by Gunbir Singh Sidhu & Manmord Sidhu. Don't forget to Like, share ...",
     *     "thumbnails": {
     *      "default": {
     *       "url": "https://i.ytimg.com/vi/n92qIk6nU84/default.jpg",
     *       "width": 120,
     *       "height": 90
     *      },
     *      "medium": {
     *       "url": "https://i.ytimg.com/vi/n92qIk6nU84/mqdefault.jpg",
     *       "width": 320,
     *       "height": 180
     *      },
     *      "high": {
     *       "url": "https://i.ytimg.com/vi/n92qIk6nU84/hqdefault.jpg",
     *       "width": 480,
     *       "height": 360
     *      }
     *     },
     *     "channelTitle": "White Hill Music", //GO TO CHANNEL OPTION?
     *     "liveBroadcastContent": "none"
     *
     */

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Thumbnails thumbnails) {
        this.thumbnails = thumbnails;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    @Override
    public String toString() {
        return "Snippet{" +
                "publishedAt='" + publishedAt + '\'' +
                ", channelId='" + channelId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", thumbnails=" + thumbnails +
                ", channelTitle='" + channelTitle + '\'' +
                '}';
    }
}