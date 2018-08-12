package com.example.android.loginapp.service;

import com.example.android.loginapp.model.LoginResponse;
import com.example.android.loginapp.util.Constants;

import java.util.HashMap;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface LoginService {

    @POST("login")
    Observable<Response<LoginResponse>> login(@Query(Constants.TYPE_KEY) String type, @Body HashMap<String, String> body);

}
