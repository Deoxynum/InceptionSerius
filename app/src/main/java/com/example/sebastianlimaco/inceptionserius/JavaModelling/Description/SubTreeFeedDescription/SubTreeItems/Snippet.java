package com.example.sebastianlimaco.inceptionserius.JavaModelling.Description.SubTreeFeedDescription.SubTreeItems;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Snippet {
    @SerializedName("description")
    @Expose
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Snippet{" +
                "description='" + description + '\'' +
                '}';
    }
}
