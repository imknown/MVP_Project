package com.example.darkwh.mvp_project.main.home;

import com.example.darkwh.mvp_project.api.GankApi;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by darkwh on 2016/6/7.
 */
public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View view;
    private GankApi gankApi;

    public HomePresenter(HomeContract.View view, GankApi gankApi) {
        this.view = view;
        this.gankApi = gankApi;
    }


    public void setView(HomeContract.View view) {
        this.view = view;
    }

    @Override
    public void getShareData(String type, int num, int page) {
        gankApi.getShareData(type, num, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(listBaseEntity -> listBaseEntity.getResults())
                .subscribe(
                        shareEntities -> {
                            view.onRefreshComplete(shareEntities);
                        },
                        e -> view.onNetError(e)
                );
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
}
