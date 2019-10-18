package com.example.dagger.di.modules;

import android.app.Activity;
import android.content.Context;

import com.example.dagger.data.local.DatabaseService;
import com.example.dagger.data.remote.NetworkService;
import com.example.dagger.ui.MainViewModel;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity activity;


    public ActivityModule(Activity activity) {
        this.activity = activity;
    }
//    @Provides
//    MainViewModel provideMainViewModel(DatabaseService databaseService, NetworkService networkService){
//        return new MainViewModel(databaseService,networkService);
//    }

    @Provides
    Context provideContext(){
        return activity;
    }
}
