package com.example.darkwh.mvp_project.main.home;

import com.example.darkwh.mvp_project.base.BasePresenter;
import com.example.darkwh.mvp_project.base.BaseView;

/**
 * Created by darkwh on 2016/6/7.
 */
public class HomeContract {

    public interface View extends BaseView{

        void setBanner();

        void setRecommend();

        void test();
    }

    public interface Presenter extends BasePresenter{

        //获取Banner数据
        void getBanner();

        //获取每日推荐内容
        void getRecommend();

        void test();
    }

    public interface Model {

    }
}
