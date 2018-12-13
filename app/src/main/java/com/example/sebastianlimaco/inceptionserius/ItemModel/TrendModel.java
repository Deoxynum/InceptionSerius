package com.example.sebastianlimaco.inceptionserius.ItemModel;

import android.os.Parcel;
import android.os.Parcelable;

public class TrendModel implements Parcelable {
    private String svTitle;
    private String svDescription;
    private String svThumbnailMediumURL;
    private String svThumbnailHighURL;
    private String svVideoID;

    public TrendModel () { //for adding VideoModels elements to ArrayList
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

    public String getSvThumbnailMediumURL() {
        return svThumbnailMediumURL;
    }

    public void setSvThumbnailMediumURL(String svThumbnailMediumURL) {
        this.svThumbnailMediumURL = svThumbnailMediumURL;
    }

    public String getSvThumbnailHighURL() {
        return svThumbnailHighURL;
    }

    public void setSvThumbnailHighURL(String svThumbnailHighURL) {
        this.svThumbnailHighURL = svThumbnailHighURL;
    }

    public String getSvVideoID() {
        return svVideoID;
    }

    public void setSvVideoID(String svVideoID) {
        this.svVideoID = svVideoID;
    }

    protected TrendModel(Parcel in) {
        svTitle = in.readString();
        svDescription = in.readString();
        svThumbnailMediumURL = in.readString();
        svThumbnailHighURL = in.readString();
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
        dest.writeString(svThumbnailMediumURL);
        dest.writeString(svThumbnailHighURL);
        dest.writeString(svVideoID);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<TrendModel> CREATOR = new Parcelable.Creator<TrendModel>() {
        @Override
        public TrendModel createFromParcel(Parcel in) {
            return new TrendModel(in);
        }

        @Override
        public TrendModel[] newArray(int size) {
            return new TrendModel[size];
        }
    };
}