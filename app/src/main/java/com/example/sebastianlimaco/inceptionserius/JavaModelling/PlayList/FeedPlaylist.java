package com.example.sebastianlimaco.inceptionserius.JavaModelling.PlayList;

import com.example.sebastianlimaco.inceptionserius.JavaModelling.PlayList.SubTreeFeedPlaylist.Items;
import com.example.sebastianlimaco.inceptionserius.JavaModelling.PlayList.SubTreeFeedPlaylist.PageInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FeedPlaylist {
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


    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "FeedPlaylist{" +
                "kind='" + kind + '\'' +
                ", etag='" + etag + '\'' +
                ", pageInfo=" + pageInfo +
                ", items=" + items +
                '}';
    }
}
