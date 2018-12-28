package com.codemonkeylabs.fpslibrary.sample;

import com.codemonkeylabs.fpslibrary.sample.UI.FPSRecyclerView;
import com.codemonkeylabs.fpslibrary.sample.UI.FPSRecyclerView_MembersInjector;
import com.codemonkeylabs.fpslibrary.sample.UI.FPSSampleAdpater;
import com.codemonkeylabs.fpslibrary.sample.UI.FPSSampleAdpater_Factory;
import com.codemonkeylabs.fpslibrary.sample.UI.MainActivity;
import dagger.MembersInjector;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAppComponent implements AppComponent {
  private Provider<FPSSampleAdpater> fPSSampleAdpaterProvider;

  private MembersInjector<FPSRecyclerView> fPSRecyclerViewMembersInjector;

  private DaggerAppComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static AppComponent create() {
    return builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.fPSSampleAdpaterProvider =
        FPSSampleAdpater_Factory.create(MembersInjectors.<FPSSampleAdpater>noOp());

    this.fPSRecyclerViewMembersInjector =
        FPSRecyclerView_MembersInjector.create(fPSSampleAdpaterProvider);
  }

  @Override
  public void inject(FPSApplication a) {
    MembersInjectors.<FPSApplication>noOp().injectMembers(a);
  }

  @Override
  public void inject(MainActivity a) {
    MembersInjectors.<MainActivity>noOp().injectMembers(a);
  }

  @Override
  public void inject(FPSRecyclerView a) {
    fPSRecyclerViewMembersInjector.injectMembers(a);
  }

  public static final class Builder {
    private Builder() {}

    public AppComponent build() {
      return new DaggerAppComponent(this);
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This
     *     method is a no-op. For more, see https://google.github.io/dagger/unused-modules.
     */
    @Deprecated
    public Builder appModule(AppModule appModule) {
      Preconditions.checkNotNull(appModule);
      return this;
    }
  }
}
