package com.example.android.loginapp.viewModel;

import com.example.android.loginapp.model.LoginResponse;

import java.util.HashMap;

import rx.Observable;

public interface LoginViewModel {

    Observable<LoginResponse> login(HashMap<String, String> body);
    Boolean checkEmptyInputs(String email, String password);
    Boolean isValidEmail(String email);
    Boolean isValidPassword(String password);

}
