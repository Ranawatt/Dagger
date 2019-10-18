package com.example.dagger.data.local;

import android.app.Application;
import android.content.Context;

import com.example.dagger.MyApplication;
import com.example.dagger.di.qualifier.DatabaseInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DatabaseService {

    private Context context;
    private String databaseName;
    private  int versions;

    @Inject
    public DatabaseService(Context context, @DatabaseInfo String databaseName, int versions) {
        this.context = context;
        this.databaseName = databaseName;
        this.versions = versions;
    }

    public String getDummyData() {
        return "DATABASE_DUMMY_DATA";
    }
}
