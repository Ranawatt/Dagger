// Generated by Dagger (https://google.github.io/dagger).
package com.example.dagger.data.remote;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class NetworkService_Factory implements Factory<NetworkService> {
  private final Provider<Context> contextProvider;

  private final Provider<String> apiKeyProvider;

  public NetworkService_Factory(
      Provider<Context> contextProvider, Provider<String> apiKeyProvider) {
    this.contextProvider = contextProvider;
    this.apiKeyProvider = apiKeyProvider;
  }

  @Override
  public NetworkService get() {
    return provideInstance(contextProvider, apiKeyProvider);
  }

  public static NetworkService provideInstance(
      Provider<Context> contextProvider, Provider<String> apiKeyProvider) {
    return new NetworkService(contextProvider.get(), apiKeyProvider.get());
  }

  public static NetworkService_Factory create(
      Provider<Context> contextProvider, Provider<String> apiKeyProvider) {
    return new NetworkService_Factory(contextProvider, apiKeyProvider);
  }

  public static NetworkService newNetworkService(Context context, String apiKey) {
    return new NetworkService(context, apiKey);
  }
}
