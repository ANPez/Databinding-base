package com.antonionicolaspina.databindingbase.presentation.di.components;

import com.antonionicolaspina.databindingbase.AndroidApplication;
import com.antonionicolaspina.databindingbase.presentation.di.modules.ApplicationModule;
import com.antonionicolaspina.databindingbase.presentation.views.activities.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
  void inject(BaseActivity baseActivity);

  //Exposed to sub-graphs.
  AndroidApplication application();
}