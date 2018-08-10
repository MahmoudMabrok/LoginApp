package com.example.android.loginapp.dataLayer.dataLayerImpl;

import com.example.android.loginapp.dataLayer.LoginApi;
import com.example.android.loginapp.model.Response;
import com.example.android.loginapp.service.LoginService;

import java.util.HashMap;

import rx.Observable;

public class LoginApiImpl implements LoginApi {

    private LoginService service;

    public LoginApiImpl(LoginService service) {
        this.service = service;
    }

    @Override
    public Observable<Response> login(HashMap<String, String> body) {
        return service.login(body);
    }
}
