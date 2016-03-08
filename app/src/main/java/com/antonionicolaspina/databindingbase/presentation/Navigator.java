package com.antonionicolaspina.databindingbase.presentation;

import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

public class Navigator {
  private AppCompatActivity activity;

  @Inject
  public Navigator(AppCompatActivity activity) {
    this.activity = activity;
  }
}
