package com.example.android.loginapp.viewModel.viewModelImpl;

import com.example.android.loginapp.dataLayer.LoginApi;
import com.example.android.loginapp.viewModel.LoginViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelModule {

    @Provides @Singleton
    LoginViewModel provideLoginViewModel(LoginApi api){
        return new LoginViewModelImpl(api);
    }

}
