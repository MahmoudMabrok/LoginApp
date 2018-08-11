package com.example.android.loginapp.service;

import com.example.android.loginapp.model.LoginResponse;

import java.util.HashMap;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface LoginService {

    @POST("login")
    Observable<LoginResponse> login(@Body HashMap<String, String> body);

}
