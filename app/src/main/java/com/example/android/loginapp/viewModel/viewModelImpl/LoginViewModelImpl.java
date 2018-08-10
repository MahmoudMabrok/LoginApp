package com.example.android.loginapp.viewModel.viewModelImpl;

import com.example.android.loginapp.dataLayer.LoginApi;
import com.example.android.loginapp.model.LoginResponse;
import com.example.android.loginapp.viewModel.LoginViewModel;

import java.util.HashMap;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginViewModelImpl implements LoginViewModel {

    private LoginApi api;

    public LoginViewModelImpl(LoginApi api) {
        this.api = api;
    }

    @Override
    public Observable<LoginResponse> login(HashMap<String, String> body) {
        return api.login(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                ;//Add flatMap
    }
}
