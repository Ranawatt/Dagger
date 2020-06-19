package com.example.dagger.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dagger.MyApplication;
import com.example.dagger.R;
import com.example.dagger.di.components.ApplicationComponent;
import com.example.dagger.di.components.DaggerActivityComponent;
import com.example.dagger.di.modules.ActivityModule;


import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getDependencies();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView = findViewById(R.id.tvData);
        textView.setText(mainViewModel.getSomeData());

        addHomeFragment();
    }

    private void getDependencies() {
        DaggerActivityComponent
                .builder()
                .applicationComponent(((MyApplication) getApplication()).component)
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);
    }

    private void addHomeFragment() {
        if(getSupportFragmentManager().findFragmentByTag(HomeFragment.TAG) == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container_fragment, HomeFragment.newInstance(), HomeFragment.TAG)
                    .commit();
        }
    }

}
