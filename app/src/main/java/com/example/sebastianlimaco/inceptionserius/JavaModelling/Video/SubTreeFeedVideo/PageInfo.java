package com.example.sebastianlimaco.inceptionserius.JavaModelling.Video.SubTreeFeedVideo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PageInfo {

    @SerializedName("totalResults")
    @Expose
    private String totalResults;

    @SerializedName("resultsPerPage")
    @Expose
    private String resultsPerPage;

    //"totalResults": 276553,
    //"resultsPerPage": 10


    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(String resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "totalResults='" + totalResults + '\'' +
                ", resultsPerPage='" + resultsPerPage + '\'' +
                '}';
    }
}
