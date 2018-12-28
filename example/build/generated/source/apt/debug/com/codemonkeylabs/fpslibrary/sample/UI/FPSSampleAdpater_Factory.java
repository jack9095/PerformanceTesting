package com.codemonkeylabs.fpslibrary.sample.UI;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FPSSampleAdpater_Factory implements Factory<FPSSampleAdpater> {
  private final MembersInjector<FPSSampleAdpater> fPSSampleAdpaterMembersInjector;

  public FPSSampleAdpater_Factory(
      MembersInjector<FPSSampleAdpater> fPSSampleAdpaterMembersInjector) {
    assert fPSSampleAdpaterMembersInjector != null;
    this.fPSSampleAdpaterMembersInjector = fPSSampleAdpaterMembersInjector;
  }

  @Override
  public FPSSampleAdpater get() {
    return MembersInjectors.injectMembers(fPSSampleAdpaterMembersInjector, new FPSSampleAdpater());
  }

  public static Factory<FPSSampleAdpater> create(
      MembersInjector<FPSSampleAdpater> fPSSampleAdpaterMembersInjector) {
    return new FPSSampleAdpater_Factory(fPSSampleAdpaterMembersInjector);
  }
}
