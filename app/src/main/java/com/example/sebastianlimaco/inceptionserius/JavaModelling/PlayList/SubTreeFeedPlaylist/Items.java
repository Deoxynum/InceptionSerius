package com.example.sebastianlimaco.inceptionserius.JavaModelling.PlayList.SubTreeFeedPlaylist;

import com.example.sebastianlimaco.inceptionserius.JavaModelling.PlayList.SubTreeFeedPlaylist.SubTreeItems.Snippet;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Items {
    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("etag")
    @Expose
    private String etag;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("snippet")
    @Expose
    private Snippet snippet;

    /**
     *  "kind": "youtube#searchResult",
     *  "etag": "\"XI7nbFXulYBIpL0ayR_gDh3eu1k/3I_KuMeJsc00F6HHu5dshJ-621s\"",
     *  "id": {
     *  "kind": "youtube#video",
     *  "videoId": "n92qIk6nU84"
     *    },
     *    "snippet": {
     *     ...
     *    }
     *    **/
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

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
                "kind='" + kind + '\'' +
                ", etag='" + etag + '\'' +
                ", id=" + id +
                ", snippet=" + snippet +
                '}';
    }
}