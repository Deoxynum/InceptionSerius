package com.example.sebastianlimaco.inceptionserius.JavaModelling.Video.SubTreeFeedVideo.SubTreeItems;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Id{

    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("videoId")
    @Expose
    private String videoId;

    /**
     * "kind": "youtube#video",
     * "videoId": "n92qIk6nU84"
     */

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @Override
    public String toString() {
        return "Id{" +
                "kind='" + kind + '\'' +
                ", videoId='" + videoId + '\'' +
                '}';
    }
}
