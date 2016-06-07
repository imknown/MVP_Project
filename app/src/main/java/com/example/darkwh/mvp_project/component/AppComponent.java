package com.example.darkwh.mvp_project.component;

import com.example.darkwh.mvp_project.base.BaseActivity;
import com.example.darkwh.mvp_project.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by darkwh on 2016/6/7.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(BaseActivity baseActivity);
}
