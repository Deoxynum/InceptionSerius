package com.example.sebastianlimaco.inceptionserius.ItemModel;

import android.os.Parcel;
import android.os.Parcelable;

public class PlaylistModel implements Parcelable {

    private String svTitle;
    private String svDescription;
    private String svThumbnailURL;
    private String svPlaylistID;

    public PlaylistModel () { //for adding VideoModels elements to ArrayList
        super();
    }

    public String getSvTitle() {
        return svTitle;
    }

    public void setSvTitle(String svTitle) {
        this.svTitle = svTitle;
    }

    public String getSvDescription() {
        return svDescription;
    }

    public void setSvDescription(String svDescription) {
        this.svDescription = svDescription;
    }

    public String getSvThumbnailURL() { return svThumbnailURL;    }

    public void setSvThumbnailURL(String svThumbnailURL) {
        this.svThumbnailURL = svThumbnailURL;
    }

    public String getSvPlaylistID() {
        return svPlaylistID;
    }

    public void setSvPlaylistID(String svPlaylistID) {
        this.svPlaylistID = svPlaylistID;
    }

    protected PlaylistModel(Parcel in) {
        svTitle = in.readString();
        svDescription = in.readString();
        svThumbnailURL = in.readString();
        svPlaylistID = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(svTitle);
        dest.writeString(svDescription);
        dest.writeString(svThumbnailURL);
        dest.writeString(svPlaylistID);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<PlaylistModel> CREATOR = new Parcelable.Creator<PlaylistModel>() {
        @Override
        public PlaylistModel createFromParcel(Parcel in) {
            return new PlaylistModel(in);
        }

        @Override
        public PlaylistModel[] newArray(int size) {
            return new PlaylistModel[size];
        }
    };
}
