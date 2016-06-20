package com.example.darkwh.mvp_project.api;

import com.example.darkwh.mvp_project.bean.BaseBean;
import com.example.darkwh.mvp_project.bean.ShareBean;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by darkwh on 2016/6/20.
 */
public class ApiManager {

    private final String BASE_URL="http://gank.io/api/";

    private final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;

    private GankApi gankApi;

    private ApiManager(){
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        gankApi = retrofit.create(GankApi.class);
    }

    public void getShareData(Subscriber<BaseBean<List<ShareBean>>> subscriber, String type, int num, int page){
        gankApi.getShareData(type, num, page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
