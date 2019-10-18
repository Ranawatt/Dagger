package com.example.dagger.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.dagger.MyApplication;
import com.example.dagger.R;
import com.example.dagger.di.components.DaggerActivityComponent;
import com.example.dagger.di.modules.ActivityModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerActivityComponent
                .builder()
//                .activityModule(new ActivityModule(this))
                .applicationComponent(((MyApplication)getApplication()).component)
                .build()
                .inject(this);

        TextView textView = findViewById(R.id.tvData);
        textView.setText(mainViewModel.getSomeData());


    }
}
