package com.example.darkwh.mvp_project.main.android;

import com.example.darkwh.mvp_project.scope.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by darkwh on 2016/6/17.
 */
@PerFragment
@Module
public class AndroidModule {

    private final AndroidContract.View view;

    public AndroidModule(AndroidContract.View view) {
        this.view = view;
    }

    @PerFragment
    @Provides
    public AndroidContract.Presenter providePresenter(AndroidModel model) {
        return new AndroidPresenter(view, model);
    }
}
