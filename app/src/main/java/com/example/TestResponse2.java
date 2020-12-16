package com.example;

import com.google.gson.annotations.SerializedName;

public class TestResponse2 {

    @SerializedName("Code")
    String Code;

    @SerializedName("User_AccessToken")
    String User_AccessToken;

    @SerializedName("IsDelivery")
    Boolean IsDelivery;

    public TestResponse2(String code, String user_AccessToken, Boolean isDelivery) {
        Code = code;
        User_AccessToken = user_AccessToken;
        IsDelivery = isDelivery;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getUser_AccessToken() {
        return User_AccessToken;
    }

    public void setUser_AccessToken(String user_AccessToken) {
        User_AccessToken = user_AccessToken;
    }

    public Boolean getDelivery() {
        return IsDelivery;
    }

    public void setDelivery(Boolean delivery) {
        IsDelivery = delivery;
    }
}