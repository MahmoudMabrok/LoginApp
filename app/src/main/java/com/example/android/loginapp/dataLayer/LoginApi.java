package com.example.android.loginapp.dataLayer;

import com.example.android.loginapp.model.LoginResponse;

import java.util.HashMap;

import rx.Observable;

public interface LoginApi {

    Observable<LoginResponse> login(HashMap<String, String> body);

}