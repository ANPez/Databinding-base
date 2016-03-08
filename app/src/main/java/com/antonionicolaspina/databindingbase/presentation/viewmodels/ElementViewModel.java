package com.antonionicolaspina.databindingbase.presentation.viewmodels;

import java.util.Locale;

import javax.inject.Inject;

public class ElementViewModel extends ViewModel {

  private int index;

  @Inject
  public ElementViewModel(int index) {
    this.index = index;
  }

  public String getName() {
    return String.format(Locale.US, "item %d", index);
  }
}
