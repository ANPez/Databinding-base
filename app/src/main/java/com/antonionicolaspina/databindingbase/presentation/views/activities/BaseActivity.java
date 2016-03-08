package com.antonionicolaspina.databindingbase.presentation.views.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.antonionicolaspina.databindingbase.AndroidApplication;
import com.antonionicolaspina.databindingbase.presentation.di.components.ActivityComponent;
import com.antonionicolaspina.databindingbase.presentation.di.components.ApplicationComponent;
import com.antonionicolaspina.databindingbase.presentation.di.components.DaggerActivityComponent;
import com.antonionicolaspina.databindingbase.presentation.di.modules.ActivityModule;

public abstract class BaseActivity extends AppCompatActivity {
  protected ActivityComponent activityComponent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    activityComponent = DaggerActivityComponent.builder()
            .activityModule(getActivityModule())
            .applicationComponent(getApplicationComponent())
            .build();
    getApplicationComponent().inject(this);
  }

  protected ApplicationComponent getApplicationComponent() {
    return ((AndroidApplication)getApplication()).getApplicationComponent();
  }
 
  protected ActivityModule getActivityModule() {
    return new ActivityModule(this);
  }

  public ActivityComponent getActivityComponent() {
    return activityComponent;
  }
}
