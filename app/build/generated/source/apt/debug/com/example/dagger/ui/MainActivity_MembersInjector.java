// Generated by Dagger (https://dagger.dev).
package com.example.dagger.ui;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<MainViewModel> mainViewModelProvider;

  public MainActivity_MembersInjector(Provider<MainViewModel> mainViewModelProvider) {
    this.mainViewModelProvider = mainViewModelProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<MainViewModel> mainViewModelProvider) {
    return new MainActivity_MembersInjector(mainViewModelProvider);}

  @Override
  public void injectMembers(MainActivity instance) {
    injectMainViewModel(instance, mainViewModelProvider.get());
  }

  @InjectedFieldSignature("com.example.dagger.ui.MainActivity.mainViewModel")
  public static void injectMainViewModel(MainActivity instance, MainViewModel mainViewModel) {
    instance.mainViewModel = mainViewModel;
  }
}
