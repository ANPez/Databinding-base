package com.antonionicolaspina.databindingbase.presentation.di.modules;

import android.content.Context;

import com.antonionicolaspina.databindingbase.AndroidApplication;
import com.antonionicolaspina.databindingbase.domain.executor.PostExecutionThread;
import com.antonionicolaspina.databindingbase.domain.executor.ThreadExecutor;
import com.antonionicolaspina.databindingbase.presentation.executor.JobExecutor;
import com.antonionicolaspina.databindingbase.presentation.executor.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
  private final AndroidApplication application;

  public ApplicationModule(AndroidApplication application) {
    this.application = application;
  }

  @Provides
  @Singleton
  AndroidApplication provideAndroidApplication() {
    return this.application;
  }

  @Provides @Singleton
  Context provideApplicationContext() {
    return this.application;
  }

  @Provides @Singleton
  ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
    return jobExecutor;
  }

  @Provides @Singleton
  protected PostExecutionThread providePostExecutionThread(UIThread uiThread) {
    return uiThread;
  }
}
