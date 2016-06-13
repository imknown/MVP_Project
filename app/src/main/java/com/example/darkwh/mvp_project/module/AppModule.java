package com.example.darkwh.mvp_project.module;

import android.content.Context;

import com.example.darkwh.mvp_project.api.GankApi;
import com.example.darkwh.mvp_project.base.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by darkwh on 2016/6/7.
 */
@Module
public class AppModule {

    private static final String BASE_URL="http://gank.io/api/";

    private final BaseApplication application;

    public AppModule(BaseApplication application) {
        this.application = application;
    }

    @Singleton
    @Provides
    public Context provideApplicationContext(){
        return application;
    }

    @Singleton
    @Provides
    public GankApi provideGankApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(GankApi.class);
    }

}
