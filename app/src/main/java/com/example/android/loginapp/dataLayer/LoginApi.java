package com.example.android.loginapp.dataLayer;

import com.example.android.loginapp.model.LoginResponse;

import java.util.HashMap;

import retrofit2.Response;
import rx.Observable;

public interface LoginApi {

    Observable<Response<LoginResponse>> login(String type, HashMap<String, String> body);

}
