package com.antonionicolaspina.databindingbase.presentation.di.components;

import com.antonionicolaspina.databindingbase.presentation.views.activities.MainActivity;
import com.antonionicolaspina.databindingbase.presentation.di.PerActivity;
import com.antonionicolaspina.databindingbase.presentation.di.modules.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
  void inject(MainActivity mainActivity);
}
