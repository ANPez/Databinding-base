package com.antonionicolaspina.databindingbase.presentation.viewmodels;

import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.view.View;

import javax.inject.Inject;

public class ElementsViewModel extends ViewModel {
  @Bindable
  public ObservableArrayList<ViewModel> elements = new ObservableArrayList<>();

  private int total;

  @Inject
  public ElementsViewModel() {
    for(total=0;total<3; total++) {
      elements.add(new ElementViewModel(total));
    }
  }

  public void addItem(@SuppressWarnings("UnusedParameters") View view) {
    elements.add(new ElementViewModel(total++));
  }
}
