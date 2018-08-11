package com.example.android.loginapp;

import android.app.Application;
import android.content.Context;

import com.example.android.loginapp.dataLayer.dataLayerImpl.DataLayerModule;
import com.example.android.loginapp.viewModel.viewModelImpl.ViewModelModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {DataLayerModule.class, ViewModelModule.class})
public class AppModule {

    private Application app;

    public AppModule(Application app) {
        this.app = app;
    }

    @Provides @Singleton
    Context provideContext(){
        return app;
    }

}
