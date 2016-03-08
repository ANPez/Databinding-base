package com.antonionicolaspina.databindingbase;

import android.app.Application;

import com.antonionicolaspina.databindingbase.presentation.di.components.ApplicationComponent;
import com.antonionicolaspina.databindingbase.presentation.di.components.DaggerApplicationComponent;
import com.antonionicolaspina.databindingbase.presentation.di.modules.ApplicationModule;

public class AndroidApplication extends Application {
  protected ApplicationComponent applicationComponent;

  @Override public void onCreate() {
    super.onCreate();
    this.initializeInjector();
  }

  protected void initializeInjector() {
    applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(getApplicationModule())
            .build();
  }

  protected ApplicationModule getApplicationModule() {
    return new ApplicationModule(this);
  }

  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }
}
