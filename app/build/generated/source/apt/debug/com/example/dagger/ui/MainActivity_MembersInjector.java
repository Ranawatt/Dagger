// Generated by Dagger (https://google.github.io/dagger).
package com.example.dagger.ui;

import dagger.MembersInjector;
import javax.inject.Provider;

public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<MainViewModel> mainViewModelProvider;

  public MainActivity_MembersInjector(Provider<MainViewModel> mainViewModelProvider) {
    this.mainViewModelProvider = mainViewModelProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<MainViewModel> mainViewModelProvider) {
    return new MainActivity_MembersInjector(mainViewModelProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectMainViewModel(instance, mainViewModelProvider.get());
  }

  public static void injectMainViewModel(MainActivity instance, MainViewModel mainViewModel) {
    instance.mainViewModel = mainViewModel;
  }
}
