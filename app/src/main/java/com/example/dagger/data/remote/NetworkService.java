package com.example.dagger.data.remote;

import android.content.Context;

import com.example.dagger.di.qualifier.ApplicationContext;
import com.example.dagger.di.qualifier.NetworkInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class NetworkService {
    private Context context;
    private String apiKey;

    @Inject
    public NetworkService(@ApplicationContext Context context, @NetworkInfo String apiKey) {
        this.context = context;
        this.apiKey = apiKey;
    }

    public String getDummyData() {
        return "NETWORK_DUMMY_DATA";
    }
}
