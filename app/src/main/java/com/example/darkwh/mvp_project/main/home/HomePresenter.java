package com.example.darkwh.mvp_project.main.home;

import android.util.Log;

import com.example.darkwh.mvp_project.listener.CallBackListener;

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

    private CallBackListener refreshListener = new CallBackListener() {
        @Override
        public <ShareEntity> void onSucess(ShareEntity data) {
            Log.d("test","test");
        }

        @Override
        public void onError() {

        }

        @Override
        public void onComplete() {

        }
    };

//    private CallBackListener loadMoreListener = new CallBackListener() {
//        @Override
//        public void onSucess() {
//
//        }
//
//        @Override
//        public void onError() {
//
//        }
//
//        @Override
//        public void onComplete() {
//
//        }
//    };

    @Override
    public void refresh() {
        model.getShareData(type, num, 1, refreshListener);
    }

    @Override
    public void getMore() {

    }

//    @Override
//    public void getShareData(String type, int num, int page) {
//        Subscription subscription = gankApi.getShareData(type, num, page)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .map(listBaseEntity -> listBaseEntity.getResults())
//                .subscribe(
//                        shareEntities -> {
//                            view.onRefreshComplete(shareEntities);
//                        },
//                        e -> view.onNetError(e)
//                );
//        subscription.unsubscribe();
//    }
//
//    @Override
//    public void getMoreData(String type, int num, int page) {
//        gankApi.getShareData(type, num, page)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .map(listBaseEntity -> listBaseEntity.getResults())
//                .subscribe(
//                        shareEntities -> {
//                            view.onLoadMoreComplete(shareEntities);
//                        },
//                        e -> view.onNetError(e)
//                );
//    }

}
