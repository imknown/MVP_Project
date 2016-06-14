package com.example.darkwh.mvp_project.component;

import com.example.darkwh.mvp_project.base.BaseFragment;
import com.example.darkwh.mvp_project.module.FragmentModule;
import com.example.darkwh.mvp_project.scope.PerFragment;

import dagger.Component;

/**
 * Created by darkwh on 2016/6/14.
 */
@PerFragment
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(BaseFragment baseFragment);

    BaseFragment fragment();

}
