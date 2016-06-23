package com.example.darkwh.mvp_project.main.home;

import com.example.darkwh.mvp_project.base.BaseModel;
import com.example.darkwh.mvp_project.base.BasePresenter;
import com.example.darkwh.mvp_project.base.BaseView;
import com.example.darkwh.mvp_project.bean.ShareBean;
import com.example.darkwh.mvp_project.listener.CallBackListener;

import java.util.List;

/**
 * Created by darkwh on 2016/6/7.
 */
public class HomeContract {

    public interface View extends BaseView {

        void onRefreshComplete(List<ShareBean> data);

        void onLoadMoreComplete(List<ShareBean> data);

    }

    public interface Presenter extends BasePresenter {

        void refresh(String type);

        void getMore(String type);

    }

    public interface Model extends BaseModel{

        void getData(String type, int num, int page,CallBackListener callBackListener);

    }

}
