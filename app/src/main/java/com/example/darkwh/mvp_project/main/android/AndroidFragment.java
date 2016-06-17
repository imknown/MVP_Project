package com.example.darkwh.mvp_project.main.android;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.darkwh.mvp_project.R;
import com.example.darkwh.mvp_project.adapter.BaseRecyclerAdapter;
import com.example.darkwh.mvp_project.api.GankApi;
import com.example.darkwh.mvp_project.base.BaseFragment;
import com.example.darkwh.mvp_project.entity.ShareEntity;
import com.example.darkwh.mvp_project.holders.BaseHolder;
import com.example.darkwh.mvp_project.holders.CommonNewsHolder;
import com.example.darkwh.mvp_project.main.home.DaggerHomeComponent;
import com.example.darkwh.mvp_project.main.home.HomeComponent;
import com.example.darkwh.mvp_project.main.home.HomeContract;
import com.example.darkwh.mvp_project.main.home.HomeModule;
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
 * Created by darkwh on 2016/6/12.
 * Android
 */
public class AndroidFragment extends BaseFragment implements HomeContract.View, PtrHandler {

    private Unbinder unbinder;
    private HomeComponent component;
    @Inject
    HomeContract.Presenter presenter;
    @Inject
    GankApi gankApi;
    @Inject
    Context context;
    private String type = "Android";
    private int num = 10;
    private int page = 1;

    private BaseRecyclerAdapter<ShareEntity> mAdapter = new BaseRecyclerAdapter<ShareEntity>(R.layout.item_common_news) {
        @Override
        public BaseHolder provideBaseHolder(View itemView) {
            return new CommonNewsHolder(itemView, context);
        }
    };

    @BindView(R.id.recycler_view)
    MyRecyclerView recyclerView;
    @BindView(R.id.refresh_view)
    PtrClassicFrameLayout refreshView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_android, null);
        unbinder = ButterKnife.bind(this, view);
        initComponent();
        initViews();
        presenter.getShareData(gankApi, type, num, 1);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initComponent() {
        component = DaggerHomeComponent.builder()
                .appComponent(getAppComponent())
                .fragmentModule(getFragmentModule())
                .homeModule(new HomeModule(this))
                .build();
        component.inject(this);
    }

    private void initViews() {
        refreshView.setPtrHandler(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mAdapter);
        recyclerView.setScrolledToBottomListener(new MyRecyclerView.ScrolledToBottomListener() {
            @Override
            public void onScrolled() {
                Log.d("recyclerview","测试一下");
            }
        });
    }

    @Override
    public void onRefreshComplete(List<ShareEntity> data) {
        if(data != null){
            page =1;
            mAdapter.setData(data);
            mAdapter.notifyDataSetChanged();
        }
        refreshView.refreshComplete();
    }

    @Override
    public void onLoadMoreComplete(List<ShareEntity> data) {

    }

    @Override
    public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
        return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
    }

    @Override
    public void onRefreshBegin(PtrFrameLayout frame) {

    }
}
