package com.example.darkwh.mvp_project.main.android;

/**
 * Created by darkwh on 2016/6/17.
 */
public class AndroidPresenter implements AndroidContract.Presenter {

    private AndroidContract.View view;
    private AndroidContract.Model model;

    public AndroidPresenter(AndroidContract.View view, AndroidContract.Model model) {
        this.view = view;
        this.model = model;
    }

}
