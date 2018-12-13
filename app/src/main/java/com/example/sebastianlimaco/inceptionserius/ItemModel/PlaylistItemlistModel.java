package com.example.sebastianlimaco.inceptionserius.ItemModel;

import android.os.Parcel;
import android.os.Parcelable;

public class PlaylistItemlistModel implements Parcelable {
    private String svTitle;
    private String svThumbnailURL;
    private String svPlaylistID;
    private int ivID;

    public PlaylistItemlistModel () { //for adding VideoModels elements to ArrayList
        super();
    }

    public String getSvTitle() {
        return svTitle;
    }

    public void setSvTitle(String svTitle) {
        this.svTitle = svTitle;
    }

    public String getSvThumbnailURL() {
        return svThumbnailURL;
    }

    public void setSvThumbnailURL(String svThumbnailURL) {
        this.svThumbnailURL = svThumbnailURL;
    }

    public int getIvID() { return ivID;    }

    public void setIvID(int ivID) {this.ivID = ivID;    }

    public String getSvPlaylistID() {
        return svPlaylistID;
    }

    public void setSvPlaylistID(String svPlaylistID) {
        this.svPlaylistID = svPlaylistID;
    }



    protected PlaylistItemlistModel(Parcel in) {
        svTitle = in.readString();
        svThumbnailURL = in.readString();
        svPlaylistID = in.readString();
        ivID = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(svTitle);
        dest.writeString(svThumbnailURL);
        dest.writeString(svPlaylistID);
        dest.writeInt(ivID);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<PlaylistItemlistModel> CREATOR = new Parcelable.Creator<PlaylistItemlistModel>() {
        @Override
        public PlaylistItemlistModel createFromParcel(Parcel in) {
            return new PlaylistItemlistModel(in);
        }

        @Override
        public PlaylistItemlistModel[] newArray(int size) {
            return new PlaylistItemlistModel[size];
        }
    };
}