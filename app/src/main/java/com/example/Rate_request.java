package com.example;

import com.google.gson.annotations.SerializedName;

public class Rate_request {

    @SerializedName("User_Phone")
    String User_Phone;

    public Rate_request(String user_Phone) {
        User_Phone = user_Phone;
    }

    public String getUser_Phone() {
        return User_Phone;
    }

    public void setUser_Phone(String user_Phone) {
        User_Phone = user_Phone;
    }
}
