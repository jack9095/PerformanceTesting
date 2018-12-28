package com.codemonkeylabs.fpslibrary.sample.UI;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FPSRecyclerView_MembersInjector implements MembersInjector<FPSRecyclerView> {
  private final Provider<FPSSampleAdpater> adapterProvider;

  public FPSRecyclerView_MembersInjector(Provider<FPSSampleAdpater> adapterProvider) {
    assert adapterProvider != null;
    this.adapterProvider = adapterProvider;
  }

  public static MembersInjector<FPSRecyclerView> create(
      Provider<FPSSampleAdpater> adapterProvider) {
    return new FPSRecyclerView_MembersInjector(adapterProvider);
  }

  @Override
  public void injectMembers(FPSRecyclerView instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.adapter = adapterProvider.get();
  }

  public static void injectAdapter(
      FPSRecyclerView instance, Provider<FPSSampleAdpater> adapterProvider) {
    instance.adapter = adapterProvider.get();
  }
}
