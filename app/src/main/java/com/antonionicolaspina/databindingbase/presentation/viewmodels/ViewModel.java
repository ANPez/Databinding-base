package com.antonionicolaspina.databindingbase.presentation.viewmodels;

import android.databinding.BaseObservable;
import android.os.Bundle;

public abstract class ViewModel extends BaseObservable {
  public void initialize() {}
  public void pause() {}
  public void resume() {}
  public void destroy() {}
  public void saveState(Bundle state) {}
  public void restoreState(Bundle state) {}
}
