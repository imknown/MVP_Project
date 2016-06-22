package com.example.darkwh.mvp_project.listener;

/**
 * Created by darkwh on 2016/6/22.
 */
public interface CallBackListener<T> {

    void onSucess(T data);

    void onError(Throwable e);

    void onComplete();
}
