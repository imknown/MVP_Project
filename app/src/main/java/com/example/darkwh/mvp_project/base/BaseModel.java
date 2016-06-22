package com.example.darkwh.mvp_project.base;

/**
 * Created by darkwh on 2016/6/17.
 */
public interface BaseModel {

    interface CallBackListener{

        void onSucess();

        void onError();

        void onComplete();
    }
}
