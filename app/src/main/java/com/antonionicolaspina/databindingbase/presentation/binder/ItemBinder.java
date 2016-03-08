package com.antonionicolaspina.databindingbase.presentation.binder;

public interface ItemBinder<T>
{
  int getLayoutRes(T model);
  int getBindingVariable(T model);
  boolean canHandle(T model);
}
