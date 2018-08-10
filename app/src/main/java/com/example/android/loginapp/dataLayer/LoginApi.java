package com.example.android.loginapp.dataLayer;

import com.example.android.loginapp.model.Response;

import java.util.HashMap;

import rx.Observable;

public interface LoginApi {

    Observable<Response> login(HashMap<String, String> body);

}
