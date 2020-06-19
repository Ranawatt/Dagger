// Generated by Dagger (https://dagger.dev).
package com.example.dagger.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ActivityModule_ProvideContextFactory implements Factory<Context> {
  private final ActivityModule module;

  public ActivityModule_ProvideContextFactory(ActivityModule module) {
    this.module = module;
  }

  @Override
  public Context get() {
    return provideContext(module);
  }

  public static ActivityModule_ProvideContextFactory create(ActivityModule module) {
    return new ActivityModule_ProvideContextFactory(module);
  }

  public static Context provideContext(ActivityModule instance) {
    return Preconditions.checkNotNull(instance.provideContext(), "Cannot return null from a non-@Nullable @Provides method");
  }
}