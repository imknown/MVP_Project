package com.example.darkwh.mvp_project.base;

import com.example.darkwh.mvp_project.bean.BaseBean;

/**
 * Created by darkwh on 2016/6/7.
 */
public interface BaseView {


    /**
     * 网络访问异常的方法
     * @param e
     */
    void onNetError(Throwable e);

    /**
     * 获取网络资源失败的方法
     * 适用于服务端成功标记返回false的情况
     * @param baseEntity
     */
    void getNetResDataError(BaseBean baseEntity);
}
