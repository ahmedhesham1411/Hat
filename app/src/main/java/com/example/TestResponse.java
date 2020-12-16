package com.example;

import com.google.gson.annotations.SerializedName;

public class TestResponse {
    @SerializedName("result")
    TestResponse2 result;

    public TestResponse(TestResponse2 result) {
        this.result = result;
    }

    public TestResponse2 getResult() {
        return result;
    }

    public void setResult(TestResponse2 result) {
        this.result = result;
    }
}
