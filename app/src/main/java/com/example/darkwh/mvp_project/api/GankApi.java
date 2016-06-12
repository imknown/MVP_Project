package com.example.darkwh.mvp_project.api;

import com.example.darkwh.mvp_project.entity.BaseEntity;
import com.example.darkwh.mvp_project.entity.ShareEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by darkwh on 2016/6/12.
 */
public interface GankApi {

    @GET("/{type}/{num}/{page}")
    Observable<BaseEntity<ShareEntity>> getShareData(@Path("type") String type, @Path("num") String num, @Path("page") String page);
}
