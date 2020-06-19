package com.example.dagger.ui;

import com.example.dagger.data.local.DatabaseService;
import com.example.dagger.data.remote.NetworkService;
import com.example.dagger.di.scope.ActivityScope;

import javax.inject.Inject;

@ActivityScope
public class MainViewModel {

    private DatabaseService databaseService;
    private NetworkService networkService;

    @Inject
    public MainViewModel(DatabaseService databaseService, NetworkService networkService) {
        this.databaseService = databaseService;
        this.networkService = networkService;
    }

    public String getSomeData(){
        return databaseService.getDummyData()+" : "+networkService.getDummyData();
    }
}
