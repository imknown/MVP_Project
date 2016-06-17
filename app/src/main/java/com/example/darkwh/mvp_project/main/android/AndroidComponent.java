package com.example.darkwh.mvp_project.main.android;

import com.example.darkwh.mvp_project.component.AppComponent;
import com.example.darkwh.mvp_project.component.FragmentComponent;
import com.example.darkwh.mvp_project.module.FragmentModule;
import com.example.darkwh.mvp_project.scope.PerFragment;

import dagger.Component;

/**
 * Created by darkwh on 2016/6/17.
 */
@PerFragment
@Component(dependencies = AppComponent.class, modules = {FragmentModule.class,AndroidModule.class})
public interface AndroidComponent extends FragmentComponent {

    void inject(AndroidFragment androidFragment);

}
