package com.example.dagger.di.components;

import android.app.Application;
import android.content.Context;

import com.example.dagger.MyApplication;
import com.example.dagger.data.local.DatabaseService;
import com.example.dagger.data.remote.NetworkService;
import com.example.dagger.di.modules.ApplicationModule;
import com.example.dagger.di.qualifier.ApplicationContext;
import com.example.dagger.utils.NetworkHelper;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MyApplication myApplication);

    @ApplicationContext
    Context getContext();

    NetworkService getNetworkService();

    DatabaseService getDatabaseService();

    NetworkHelper getNetworkHelper();
}
