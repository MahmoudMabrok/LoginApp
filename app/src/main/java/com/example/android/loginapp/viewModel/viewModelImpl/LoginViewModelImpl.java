package com.example.android.loginapp.viewModel.viewModelImpl;

import com.example.android.loginapp.dataLayer.LoginApi;
import com.example.android.loginapp.model.LoginResponse;
import com.example.android.loginapp.util.Constants;
import com.example.android.loginapp.util.LoginThrowable;
import com.example.android.loginapp.viewModel.LoginViewModel;

import java.util.HashMap;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
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
                .flatMap((Func1<? super LoginResponse, ? extends Observable<? extends LoginResponse>>) new Func1<LoginResponse, Observable<?>>() {
                    @Override
                    public Observable<?> call(LoginResponse loginResponse) {
                        if(loginResponse.getStatus().matches(Constants.SUCCESS_STATUS)){
                            return Observable.just(loginResponse.getUser());
                        }
                        return Observable.error(new LoginThrowable(Constants.FAILURE_STATUS));
                    }

                });
    }
}
