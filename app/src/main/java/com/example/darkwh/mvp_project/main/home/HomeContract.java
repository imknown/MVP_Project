package com.example.darkwh.mvp_project.main.home;

import com.example.darkwh.mvp_project.base.BasePresenter;
import com.example.darkwh.mvp_project.base.BaseView;

/**
 * Created by darkwh on 2016/6/7.
 */
public class HomeContract {

    public interface View extends BaseView {

        void updateUI();

    }

    public interface Presenter extends BasePresenter {

        void getShareData(String type, int num, int page);
    }

    public interface Model {

        void getShareData(String type, int num, int page);
    }
}
