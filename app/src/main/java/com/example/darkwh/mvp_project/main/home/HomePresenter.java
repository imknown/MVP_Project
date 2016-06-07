package com.example.darkwh.mvp_project.main.home;

/**
 * Created by darkwh on 2016/6/7.
 */
public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View view;

    public HomePresenter(HomeContract.View view) {
        this.view = view;
    }

    @Override
    public void getBanner() {

    }

    @Override
    public void getRecommend() {

    }

    @Override
    public void test() {
        view.test();
    }

    public void setView(HomeContract.View view) {
        this.view = view;
    }
}
