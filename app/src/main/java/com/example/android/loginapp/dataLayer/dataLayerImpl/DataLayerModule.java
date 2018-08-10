package com.example.android.loginapp.dataLayer.dataLayerImpl;

import com.example.android.loginapp.dataLayer.LoginApi;
import com.example.android.loginapp.service.LoginService;
import com.example.android.loginapp.util.RetrofitFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataLayerModule {

    @Provides @Singleton
    LoginService provideLoginService(){
        return RetrofitFactory.createService(LoginService.class);
    }

    @Provides @Singleton
    LoginApi provideLoginApi(LoginService service){
        return new LoginApiImpl(service);
    }

}
