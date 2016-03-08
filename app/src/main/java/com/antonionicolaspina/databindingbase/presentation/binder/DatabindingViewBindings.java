package com.antonionicolaspina.databindingbase.presentation.binder;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import java.util.Collection;

public class DatabindingViewBindings
{
  @SuppressWarnings("unchecked")
  @BindingAdapter({"items", "itemViewBinder"})
  public static <T> void setItems(RecyclerView recyclerView, Collection<T> items, ItemBinder<T> itemViewMapper) {
    recyclerView.setAdapter(new BindingRecyclerViewAdapter<>(itemViewMapper, items));
  }
}
