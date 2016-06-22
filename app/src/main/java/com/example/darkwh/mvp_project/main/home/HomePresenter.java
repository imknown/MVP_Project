package com.example.darkwh.mvp_project.main.home;

import com.example.darkwh.mvp_project.bean.ShareBean;
import com.example.darkwh.mvp_project.listener.CallBackListener;

import java.util.List;

/**
 * Created by darkwh on 2016/6/7.
 */
public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View view;
    private HomeContract.Model model;
    private int num = 10;//每次请求图片的个数
    private int page = 1;//当前请求的页数
    private String type = "福利";//请求的种类

    public HomePresenter(HomeContract.View view, HomeContract.Model model) {
        this.view = view;
        this.model = model;
    }

    private CallBackListener refreshListener = new CallBackListener<List<ShareBean>>() {
        @Override
        public void onSucess(List<ShareBean> data) {
            page = 1;
            view.onRefreshComplete(data);
        }

        @Override
        public void onError(Throwable e) {
            view.onNetError(e);
        }

        @Override
        public void onComplete() {

        }
    };

    private CallBackListener loadMoreListener = new CallBackListener<List<ShareBean>>() {
        @Override
        public void onSucess(List<ShareBean> data) {
            if (data != null && data.size() != 0) {
                page++;
            }
            view.onLoadMoreComplete(data);
        }

        @Override
        public void onError(Throwable e) {
            view.onNetError(e);
        }

        @Override
        public void onComplete() {

        }
    };

    @Override
    public void refresh() {
        model.getData(type, num, 1, refreshListener);
    }

    @Override
    public void getMore() {
        model.getData(type, num, page + 1, loadMoreListener);
    }

}
