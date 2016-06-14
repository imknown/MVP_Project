package com.example.darkwh.mvp_project.main.home;

import com.example.darkwh.mvp_project.api.GankApi;

/**
 * Created by darkwh on 2016/6/7.
 */
public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View view;
    private HomeContract.Model model;

    public HomePresenter(HomeContract.View view) {
        this.view = view;
    }


    public void setView(HomeContract.View view) {
        this.view = view;
    }

    @Override
    public void getShareData(GankApi gankApi, String type, int num, int page) {

    }
}
