package com.example.dagger.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dagger.MyApplication;
import com.example.dagger.R;
import com.example.dagger.di.components.DaggerFragmentComponent;
import com.example.dagger.di.modules.FragmentModule;

import javax.inject.Inject;

public class HomeFragment extends Fragment {

    public static final String TAG = "HomeFragment";

    @Inject
    HomeViewModel viewModel;

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        getDependencies();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvMessage = view.findViewById(R.id.tv_message);
        tvMessage.setText(viewModel.getSomeData());
    }

    @SuppressWarnings("ConstantConditions") // to suppress null pointer exception warning
    private void getDependencies() {
        DaggerFragmentComponent
                .builder()
                .applicationComponent(((MyApplication) getContext()
                        .getApplicationContext()).component)
                .fragmentModule(new FragmentModule(this)) // this is shown as deprecated as no instance provided by it is being injected
                .build()
                .inject(this);
    }

}