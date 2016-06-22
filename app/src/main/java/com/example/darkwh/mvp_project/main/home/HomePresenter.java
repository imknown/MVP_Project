package com.example.darkwh.mvp_project.main.home;

import com.example.darkwh.mvp_project.api.GankApi;
import com.example.darkwh.mvp_project.base.BaseModel;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by darkwh on 2016/6/7.
 */
public class HomePresenter implements HomeContract.Presenter,BaseModel.CallBackListener {

    private HomeContract.View view;
    private GankApi gankApi;
    private int num = 10;//每次请求图片的个数
    private int page = 1;//当前请求的页数
    private String type = "福利";//请求的种类

    public HomePresenter(HomeContract.View view, GankApi gankApi) {
        this.view = view;
        this.gankApi = gankApi;
    }

    @Override
    public void getShareData(String type, int num, int page) {
        Subscription subscription = gankApi.getShareData(type, num, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(listBaseEntity -> listBaseEntity.getResults())
                .subscribe(
                        shareEntities -> {
                            view.onRefreshComplete(shareEntities);
                        },
                        e -> view.onNetError(e)
                );
        subscription.unsubscribe();
    }

    @Override
    public void getMoreData(String type, int num, int page) {
        gankApi.getShareData(type, num, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(listBaseEntity -> listBaseEntity.getResults())
                .subscribe(
                        shareEntities -> {
                            view.onLoadMoreComplete(shareEntities);
                        },
                        e -> view.onNetError(e)
                );
    }

    @Override
    public void onSucess() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onComplete() {

    }
}
