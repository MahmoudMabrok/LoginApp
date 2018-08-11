package com.example.android.loginapp;

import com.example.android.loginapp.fragment.LoginFragment;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

    void inject(LoginFragment loginFragment);

}
