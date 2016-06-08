package com.example.darkwh.mvp_project.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.darkwh.mvp_project.component.ActivityComponent;
import com.example.darkwh.mvp_project.component.AppComponent;
import com.example.darkwh.mvp_project.component.DaggerActivityComponent;
import com.example.darkwh.mvp_project.module.ActivityModule;

/**
 * Created by darkwh on 2016/6/7.
 */
public class BaseActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initComponent();
    }

    private void initComponent(){
        activityComponent = DaggerActivityComponent.builder()
                .appComponent(getAppComponent())
                .activityModule(getActivityModule())
                .build();
        activityComponent.inject(this);
    }

    public ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }

    public AppComponent getAppComponent(){
        return ((BaseApplication)getApplication()).getAppComponent();
    }

}
