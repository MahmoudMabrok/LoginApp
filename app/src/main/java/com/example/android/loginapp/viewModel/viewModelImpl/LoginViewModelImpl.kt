package com.example.android.loginapp.viewModel.viewModelImpl

import com.example.android.loginapp.dataLayer.LoginApi
import com.example.android.loginapp.model.LoginResponse
import com.example.android.loginapp.util.Constants
import com.example.android.loginapp.util.LoginThrowable
import com.example.android.loginapp.viewModel.LoginViewModel
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.HashMap

class LoginViewModelImpl : LoginViewModel {

    private var api: LoginApi

    constructor(api: LoginApi) {
        this.api = api
    }


    override fun login(type: String?, body: HashMap<String, String>?): Observable<LoginResponse> {
        return api.login(type, body).flatMap { Response ->
            if (Response.code() == Constants.OK_STATUS_CODE) {
                Observable.just(Response.body())
            } else {
                Observable.error(LoginThrowable())
            }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }
    }

    /**
     * Checks if one of user inputs is empty
     */
    override fun checkEmptyInputs(email: String, password: String): Boolean {
        return !(email.isEmpty() || password.isEmpty())
    }

    /**
     * checks if email is in valid format
     * Got from "https://codereview.stackexchange.com/questions/33546/simple-code-to-check-format-of-user-inputted-email-address"
     */
    override fun isValidEmail(email: String): Boolean {
        return email.matches("[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\-\\_\\.]+\\.[a-zA-Z0-9]{3}".toRegex())
    }

    /**
     * checks is password is valid(6 characters or more)
     */
    override fun isValidPassword(password: String): Boolean {
        return password.length >= 6
    }
}