package com.example.darkwh.mvp_project.module;

import android.content.Context;

import com.example.darkwh.mvp_project.base.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by darkwh on 2016/6/7.
 */
@Module
public class AppModule {

    private final BaseApplication application;

    public AppModule(BaseApplication application) {
        this.application = application;
    }

    @Singleton
    @Provides
    public Context provideApplicationContext(){
        return application;
    }

}
