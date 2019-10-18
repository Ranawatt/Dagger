package com.example.dagger.di.components;

import com.example.dagger.MyApplication;
import com.example.dagger.data.local.DatabaseService;
import com.example.dagger.data.remote.NetworkService;
import com.example.dagger.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MyApplication myApplication);

    NetworkService getNetworkService();

    DatabaseService getDatabaseService();
}
