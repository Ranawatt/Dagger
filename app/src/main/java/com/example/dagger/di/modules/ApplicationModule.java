package com.example.dagger.di.modules;

import android.content.Context;

import com.example.dagger.MyApplication;
import com.example.dagger.data.local.DatabaseService;
import com.example.dagger.data.remote.NetworkService;
import com.example.dagger.di.qualifier.DatabaseInfo;
import com.example.dagger.di.qualifier.NetworkInfo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private MyApplication application;

    public ApplicationModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    Context provideContext(){
        return application;
    }
    @DatabaseInfo
    @Provides
    String provideDatabaseName(){
        return "abc";
    }
    @Provides
    Integer provideVersion(){
        return 1;
    }
    @NetworkInfo
    @Provides
    String provideApiKey(){
        return "xyz";
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
