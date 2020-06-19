package com.example.dagger.di.modules;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.example.dagger.di.qualifier.ActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @ActivityContext
    @Provides
    Context provideContext() {
        return fragment.getContext();
    }
}