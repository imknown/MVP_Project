package com.example.darkwh.mvp_project.module;

import com.example.darkwh.mvp_project.main.home.HomeContract;
import com.example.darkwh.mvp_project.main.home.HomeModel;
import com.example.darkwh.mvp_project.main.home.HomePresenter;
import com.example.darkwh.mvp_project.scope.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by darkwh on 2016/6/7.
 */
@Module
public class HomeModule {

    private final HomeContract.View view;

    public HomeModule(HomeContract.View view) {
        this.view = view;
    }

    @PerFragment
    @Provides
    public HomeContract.Presenter providePresenter(HomeModel model) {
        return new HomePresenter(view,model);
    }
}
