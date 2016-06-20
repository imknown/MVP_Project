package com.example.darkwh.mvp_project.main.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.darkwh.mvp_project.R;
import com.example.darkwh.mvp_project.adapter.BaseRecyclerAdapter;
import com.example.darkwh.mvp_project.base.BaseFragment;
import com.example.darkwh.mvp_project.holders.BaseHolder;
import com.example.darkwh.mvp_project.holders.MeiZhiHolder;
import com.example.darkwh.mvp_project.bean.ShareBean;
import com.example.darkwh.mvp_project.widget.MyRecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Created by darkwh on 2016/6/7.
 * 主页(福利)
 */
public class HomeFragment extends BaseFragment implements PtrHandler, HomeContract.View {

    @BindView(R.id.refresh_view)
    PtrClassicFrameLayout refreshView;
    @BindView(R.id.recyclerView)
    MyRecyclerView recyclerView;
    HomeComponent homeComponent;
    @Inject
    HomeContract.Presenter presenter;
    @Inject
    Context context;
    private Unbinder unbinder;
    private int num = 10;//每次请求图片的个数
    private int page = 1;//当前请求的页数
    private String type = "福利";//请求的种类

    private BaseRecyclerAdapter<ShareBean> mAdapter = new BaseRecyclerAdapter<ShareBean>(R.layout.item_meizhi) {
        @Override
        public BaseHolder provideBaseHolder(View itemView) {
            return new MeiZhiHolder(itemView, context);
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        unbinder = ButterKnife.bind(this, view);
        initComponent();
        initViews();
        presenter.getShareData(type, num, 1);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initComponent() {
        homeComponent = DaggerHomeComponent.builder()
                .appComponent(getAppComponent())
                .fragmentModule(getFragmentModule())
                .homeModule(new HomeModule(this))
                .build();
        homeComponent.inject(this);
    }

    private void initViews() {
        refreshView.setPtrHandler(this);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        recyclerView.setScrolledToBottomListener(() -> {
            presenter.getMoreData(type,num,page+1);
        });
    }

    @Override
    public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
        return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
    }

    @Override
    public void onRefreshBegin(PtrFrameLayout frame) {
        presenter.getShareData(type, num, 1);
    }

    @Override
    public void onRefreshComplete(List<ShareBean> data) {
        page = 1;
        mAdapter.setData(data);
        mAdapter.notifyDataSetChanged();
        refreshView.refreshComplete();
    }

    @Override
    public void onLoadMoreComplete(List<ShareBean> data) {
        if(data != null){
            page++;
            mAdapter.getMore(data);
            mAdapter.notifyDataSetChanged();
        }
        recyclerView.executeComplete();
    }
}
