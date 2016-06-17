package com.example.darkwh.mvp_project.main.home;

import com.example.darkwh.mvp_project.component.AppComponent;
import com.example.darkwh.mvp_project.component.FragmentComponent;
import com.example.darkwh.mvp_project.module.FragmentModule;
import com.example.darkwh.mvp_project.scope.PerFragment;

import dagger.Component;

/**
 * Created by darkwh on 2016/6/7.
 */
@PerFragment
@Component(dependencies = AppComponent.class, modules = {FragmentModule.class, HomeModule.class})
public interface HomeComponent extends FragmentComponent {

    void inject(HomeFragment homeFragment);
}