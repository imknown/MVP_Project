package com.example.darkwh.mvp_project.component;

import com.example.darkwh.mvp_project.base.BaseActivity;
import com.example.darkwh.mvp_project.module.ActivityModule;
import com.example.darkwh.mvp_project.scope.PerActivity;

import dagger.Component;

/**
 * Created by darkwh on 2016/6/8.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(BaseActivity activity);

    BaseActivity activity();

}
