package com.example.dagger.ui;

import com.example.dagger.data.local.DatabaseService;
import com.example.dagger.data.remote.NetworkService;
import com.example.dagger.di.scope.FragmentScope;
import com.example.dagger.utils.NetworkHelper;

import javax.inject.Inject;

@FragmentScope
public class HomeViewModel {

    private DatabaseService databaseService;
    private NetworkService networkService;
    private NetworkHelper networkHelper;

    @Inject
    public HomeViewModel(DatabaseService databaseService,
                         NetworkService networkService,
                         NetworkHelper networkHelper) {
        this.databaseService = databaseService;
        this.networkService = networkService;
        this.networkHelper = networkHelper;
    }

    public String getSomeData() {
        return databaseService.getDummyData()
                + " : " + networkService.getDummyData()
                + " : " + networkHelper.isNetworkConnected();
    }
}
