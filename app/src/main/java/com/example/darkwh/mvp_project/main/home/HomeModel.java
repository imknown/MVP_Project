package com.example.darkwh.mvp_project.main.home;

import com.example.darkwh.mvp_project.api.GankApi;
import com.example.darkwh.mvp_project.listener.CallBackListener;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by darkwh on 2016/6/22.
 */
public class HomeModel implements HomeContract.Model {

    @Inject
    GankApi gankApi;

    @Inject
    public HomeModel() {
    }


    @Override
    public void getData(String type, int num, int page, CallBackListener callBackListener) {
        gankApi.getShareData(type, num, page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(baseEntity -> baseEntity.getResults())
                .subscribe(
                        shareEntity -> {
                            callBackListener.onSucess(shareEntity);
                        },
                        e -> {
                            callBackListener.onError(e);
                        }
                );
    }

}
