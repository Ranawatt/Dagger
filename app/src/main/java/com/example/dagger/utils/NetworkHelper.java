package com.example.dagger.utils;

import android.content.Context;

import com.example.dagger.di.qualifier.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class NetworkHelper {

    // Should be Application Context
    private Context context;

    @Inject
    public NetworkHelper(@ApplicationContext Context context) {
        this.context = context;
    }

    public boolean isNetworkConnected() {
        // will check for network connectivity
        return false;
    }
}
