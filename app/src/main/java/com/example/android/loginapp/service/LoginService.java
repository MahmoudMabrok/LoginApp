package com.example.android.loginapp.service;

import com.example.android.loginapp.model.Response;

import java.util.HashMap;

import retrofit2.http.Body;
import retrofit2.http.GET;
import rx.Observable;

public interface LoginService {

    @GET("login")
    Observable<Response> login(@Body HashMap<String, String> body);

}
