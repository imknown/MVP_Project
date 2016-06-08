package com.example.darkwh.mvp_project.module;

import com.example.darkwh.mvp_project.base.BaseActivity;
import com.example.darkwh.mvp_project.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by darkwh on 2016/6/8.
 */
@Module
public class ActivityModule {

    private final BaseActivity activity;

    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    @PerActivity
    @Provides
    public BaseActivity provideActivity() {
        return this.activity;
    }

}
