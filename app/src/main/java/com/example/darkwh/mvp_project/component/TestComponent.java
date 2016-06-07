package com.example.darkwh.mvp_project.component;

import com.example.darkwh.mvp_project.main.home.MainActivity;
import com.example.darkwh.mvp_project.module.TestModule;
import com.example.darkwh.mvp_project.scope.PerActivity;

import dagger.Component;

/**
 * Created by darkwh on 2016/6/7.
 */
@PerActivity
@Component(modules = TestModule.class)
public interface TestComponent {

    void inject(MainActivity activity);
}
