package com.example.darkwh.mvp_project.main.home;

import com.example.darkwh.mvp_project.api.GankApi;
import com.example.darkwh.mvp_project.base.BasePresenter;
import com.example.darkwh.mvp_project.base.BaseView;
import com.example.darkwh.mvp_project.entity.BaseEntity;
import com.example.darkwh.mvp_project.entity.ShareEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by darkwh on 2016/6/7.
 */
public class HomeContract {

    public interface View extends BaseView {

        void updateUI();

    }

    public interface Presenter extends BasePresenter {

        void getShareData(GankApi gankApi, String type, int num, int page);
    }

    public interface Model {

        Observable<BaseEntity<List<ShareEntity>>> getShareData(GankApi gankApi, String type, int num, int page);

    }
}
