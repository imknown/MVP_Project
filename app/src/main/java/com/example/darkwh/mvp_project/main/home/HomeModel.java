package com.example.darkwh.mvp_project.main.home;

import com.example.darkwh.mvp_project.api.GankApi;
import com.example.darkwh.mvp_project.entity.BaseEntity;
import com.example.darkwh.mvp_project.entity.ShareEntity;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by darkwh on 2016/6/13.
 */
public class HomeModel implements HomeContract.Model {

    @Inject
    public HomeModel(){}

    @Override
    public Observable<BaseEntity<List<ShareEntity>>> getShareData(GankApi gankApi, String type, int num, int page) {
        return gankApi.getShareData(type, num, page);
    }
}
