package com.example.sebastianlimaco.inceptionserius.JavaModelling.Video;

import com.example.sebastianlimaco.inceptionserius.JavaModelling.Video.SubTreeFeedVideo.Items;
import com.example.sebastianlimaco.inceptionserius.JavaModelling.Video.SubTreeFeedVideo.PageInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FeedVideo {
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("etag")
    @Expose
    private String etag;
    //@SerializedName("nextPageToken")
    //@Expose
    //private String nextPageToken;
    //@SerializedName("regionCode")
    //@Expose
    //private String regionCode;
    @SerializedName("pageInfo")
    @Expose
    private PageInfo pageInfo;
    @SerializedName("items")
    @Expose
    private ArrayList<Items> items;

    //kind": "youtube#searchListResponse",
    //"etag": "\"XI7nbFXulYBIpL0ayR_gDh3eu1k/rAFrEdyR2Fmf8ASi4_rNda6FN2U\"",
    //"nextPageToken": "CAoQAA",
    //"regionCode": "CH",
    //"pageInfo": {
    // "totalResults": 276553,
    // "resultsPerPage": 10},
    //"items": [...]

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

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "FeedVideo{" +
                "kind='" + kind + '\'' +
                ", etag='" + etag + '\'' +
                ", pageInfo=" + pageInfo +
                ", items=" + items +
                '}';
    }
}