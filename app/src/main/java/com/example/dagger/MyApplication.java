package com.example.dagger;

import android.app.Application;
import android.util.Log;

import com.example.dagger.data.local.DatabaseService;
import com.example.dagger.data.remote.NetworkService;
import com.example.dagger.di.components.ApplicationComponent;
import com.example.dagger.di.components.DaggerApplicationComponent;
import com.example.dagger.di.modules.ApplicationModule;

import javax.inject.Inject;


public class MyApplication extends Application {
    @Inject
    public NetworkService networkService;
    @Inject
    public DatabaseService databaseService;
//    @Inject
//    public NetworkService networkService2;

    public ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();

         component.inject(this);

        Log.d("DEBUG",networkService.toString());
    }
}
