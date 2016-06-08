package com.example.darkwh.mvp_project.component;

import com.example.darkwh.mvp_project.main.home.MainActivity;
import com.example.darkwh.mvp_project.module.ActivityModule;
import com.example.darkwh.mvp_project.module.HomeModule;
import com.example.darkwh.mvp_project.scope.PerActivity;

import dagger.Component;

/**
 * Created by darkwh on 2016/6/7.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class,HomeModule.class})
public interface HomeComponent extends ActivityComponent {

    void inject(MainActivity activity);
}
