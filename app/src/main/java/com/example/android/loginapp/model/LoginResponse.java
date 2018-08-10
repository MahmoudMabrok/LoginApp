package com.example.android.loginapp.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("user")
    private User user;

    public LoginResponse(String status, User user) {
        this.setStatus(status);
        this.setUser(user);
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
