package com.example.ttest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StoryResponse {

    @SerializedName("result")
    List<StoryDetails> storyDetails;

    public StoryResponse(List<StoryDetails> storyDetails) {
        this.storyDetails = storyDetails;
    }

    public List<StoryDetails> getStoryDetails() {
        return storyDetails;
    }

    public void setStoryDetails(List<StoryDetails> storyDetails) {
        this.storyDetails = storyDetails;
    }
}
