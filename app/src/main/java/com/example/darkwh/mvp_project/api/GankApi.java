package com.example.darkwh.mvp_project.api;

import com.example.darkwh.mvp_project.bean.BaseBean;
import com.example.darkwh.mvp_project.bean.ShareBean;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by darkwh on 2016/6/12.
 */
public interface GankApi {

    /**
     * 共享数据查询
     *
     * @param type 数据类型
     * @param num  查询数量
     * @param page 页数
     * @return
     */
    @GET("data/{type}/{num}/{page}")
    Observable<BaseBean<List<ShareBean>>> getShareData(@Path("type") String type, @Path("num") int num, @Path("page") int page);
}
