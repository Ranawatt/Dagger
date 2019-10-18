package com.example.dagger.di.components;

import com.example.dagger.di.modules.ActivityModule;
import com.example.dagger.di.scope.ActivityScope;
import com.example.dagger.ui.MainActivity;
import com.example.dagger.ui.MainViewModel;

import javax.inject.Singleton;

import dagger.Component;
@ActivityScope
@Component(dependencies = {ApplicationComponent.class},modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
