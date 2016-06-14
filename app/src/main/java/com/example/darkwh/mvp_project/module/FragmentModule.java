package com.example.darkwh.mvp_project.module;

import com.example.darkwh.mvp_project.base.BaseFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/6/14.
 */
@Module
public class FragmentModule {

    private final BaseFragment baseFragment;

    public FragmentModule(BaseFragment baseFragment) {
        this.baseFragment = baseFragment;
    }

    @Provides
    public BaseFragment provideFragment(){
        return baseFragment;
    }


}
