package com.example.darkwh.mvp_project.base;

import android.app.Application;

import com.example.darkwh.mvp_project.component.AppComponent;
import com.example.darkwh.mvp_project.component.DaggerAppComponent;
import com.example.darkwh.mvp_project.module.AppModule;

/**
 * Created by darkwh on 2016/6/7.
 */
public class BaseApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        injectComponent();
    }

    private void injectComponent(){
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
