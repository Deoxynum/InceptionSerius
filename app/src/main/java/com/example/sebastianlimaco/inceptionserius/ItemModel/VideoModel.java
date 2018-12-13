package com.example.sebastianlimaco.inceptionserius.ItemModel;

import android.os.Parcel;
import android.os.Parcelable;

public class VideoModel implements Parcelable {

    private String svTitle;
    private String svDescription;
    private String svThumbnailURL;
    private String svVideoID;

    public VideoModel () { //for adding VideoModels elements to ArrayList
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

    public String getSvThumbnailURL() {
        return svThumbnailURL;
    }

    public void setSvThumbnailURL(String svThumbnailURL) {
        this.svThumbnailURL = svThumbnailURL;
    }

    public String getSvVideoID() {
        return svVideoID;
    }

    public void setSvVideoID(String svVideoID) {
        this.svVideoID = svVideoID;
    }



    public VideoModel(Parcel in) {
        svTitle = in.readString();
        svDescription = in.readString();
        svThumbnailURL = in.readString();
        svVideoID = in.readString();
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
        dest.writeString(svVideoID);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<VideoModel> CREATOR = new Parcelable.Creator<VideoModel>() {
        @Override
        public VideoModel createFromParcel(Parcel in) {
            return new VideoModel(in);
        }

        @Override
        public VideoModel[] newArray(int size) {
            return new VideoModel[size];
        }
    };
}