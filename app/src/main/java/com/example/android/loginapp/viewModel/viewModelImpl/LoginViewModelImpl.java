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
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * Checks if one of user inputs is empty
     * @param email input
     * @param password input
     * @return
     */
    @Override
    public Boolean checkEmptyInputs(String email, String password){
        if(email.isEmpty() || password.isEmpty()){
            return false;
        }
        return true;
    }

    /**
     * checks if email is in valid format
     * Got from "https://codereview.stackexchange.com/questions/33546/simple-code-to-check-format-of-user-inputted-email-address"
     * @param email
     * @return
     */
    @Override
    public Boolean isValidEmail(String email) {
        return email.matches("[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\-\\_\\.]+\\.[a-zA-Z0-9]{3}");
    }

    /**
     * checks is password is valid(6 characters or more)
     * @param password
     * @return
     */
    @Override
    public Boolean isValidPassword(String password){
        Boolean isValid = (password.length() >= 6)? true : false;
        return isValid;
    }

}
