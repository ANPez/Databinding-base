package com.antonionicolaspina.databindingbase.presentation.di.modules;

import android.support.v7.app.AppCompatActivity;

import com.antonionicolaspina.databindingbase.presentation.Navigator;
import com.antonionicolaspina.databindingbase.presentation.di.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
  private final AppCompatActivity activity;

  public ActivityModule(AppCompatActivity activity) {
    this.activity = activity;
  }

  @Provides
  @PerActivity
  AppCompatActivity provideActivity() {
    return this.activity;
  }

  @Provides
  @PerActivity
  Navigator provideNavigator(AppCompatActivity activity) {
    return new Navigator(activity);
  }
}
