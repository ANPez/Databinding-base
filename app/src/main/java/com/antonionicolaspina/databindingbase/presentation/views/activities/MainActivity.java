package com.antonionicolaspina.databindingbase.presentation.views.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.antonionicolaspina.databindingbase.R;
import com.antonionicolaspina.databindingbase.BR;
import com.antonionicolaspina.databindingbase.databinding.ActivityMainBinding;
import com.antonionicolaspina.databindingbase.presentation.binder.ItemBinderBase;
import com.antonionicolaspina.databindingbase.presentation.viewmodels.ElementsViewModel;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

  @Inject ElementsViewModel viewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    getActivityComponent().inject(this);

    ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    setSupportActionBar(binding.toolbar);

    binding.setItemsVM(viewModel);
    binding.setView(() -> new ItemBinderBase<>(BR.itemVM, R.layout.list_item));

    viewModel.initialize();
  }

  @Override
  protected void onPause() {
    super.onPause();
    viewModel.pause();
  }

  @Override
  protected void onResume() {
    super.onResume();
    viewModel.resume();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
