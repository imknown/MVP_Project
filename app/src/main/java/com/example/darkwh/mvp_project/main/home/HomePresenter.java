package com.example.darkwh.mvp_project.main.home;

import com.example.darkwh.mvp_project.api.GankApi;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by darkwh on 2016/6/7.
 */
public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View view;
    private HomeContract.Model model;

    public HomePresenter(HomeContract.View view, HomeContract.Model model) {
        this.view = view;
        this.model = model;
    }


    public void setView(HomeContract.View view) {
        this.view = view;
    }

    //TODO 取消标记,再开一个方法(尽量少用标记,容易造成阅读困难)
    @Override
    public void getShareData(GankApi gankApi, String type, int num, int page, boolean isRefresh) {
        model.getShareData(gankApi, type, num, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(listBaseEntity -> listBaseEntity.getResults())
                .subscribe(
                        shareEntities -> {
                            if (isRefresh) {
                                view.onRefreshComplete(shareEntities);
                            }
                            else {
                                view.onLoadMoreComplete(shareEntities);
                            }
                        },
                        e -> view.onNetError(e)
                );
    }
}
