package com.example.dagger.di.components;

import com.example.dagger.di.modules.FragmentModule;
import com.example.dagger.di.scope.FragmentScope;
import com.example.dagger.ui.HomeFragment;

import dagger.Component;

@FragmentScope
@Component(dependencies = {ApplicationComponent.class}, modules = {FragmentModule.class})
public interface FragmentComponent {

    void inject(HomeFragment fragment);
}
