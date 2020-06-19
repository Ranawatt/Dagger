package com.example.dagger.di.modules;

import android.app.Application;
import android.content.Context;

import com.example.dagger.MyApplication;
import com.example.dagger.data.local.DatabaseService;
import com.example.dagger.data.remote.NetworkService;
import com.example.dagger.di.qualifier.ApplicationContext;
import com.example.dagger.di.qualifier.DatabaseInfo;
import com.example.dagger.di.qualifier.NetworkInfo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private MyApplication myApplication;

    public ApplicationModule(MyApplication application) {
        this.myApplication = application;
    }

    @ApplicationContext
    @Provides
    Context provideContext(){
        return myApplication;
    }

    @DatabaseInfo
    @Provides
    String provideDatabaseName(){
        return "dummy_db";
    }

    @DatabaseInfo
    @Provides
    Integer provideVersion(){
        return 1;
    }

    @NetworkInfo
    @Provides
    String provideApiKey(){
        return "SOME_API_KEY";
    }
//    @Singleton
//    @Provides
//    NetworkService provideNetworkService(){
//        return  new NetworkService(application,"abc");
//    }
//    @Provides
//    DatabaseService provideDatabaseService(){
//        return new DatabaseService(application,"xyz",1);
//    }
}
