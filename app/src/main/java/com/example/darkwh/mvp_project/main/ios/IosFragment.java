package com.example.darkwh.mvp_project.main.ios;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.darkwh.mvp_project.R;
import com.example.darkwh.mvp_project.adapter.BaseRecyclerAdapter;
import com.example.darkwh.mvp_project.base.BaseFragment;
import com.example.darkwh.mvp_project.bean.ShareBean;
import com.example.darkwh.mvp_project.holders.BaseHolder;
import com.example.darkwh.mvp_project.holders.CommonNewsHolder;
import com.example.darkwh.mvp_project.main.home.DaggerHomeComponent;
import com.example.darkwh.mvp_project.main.home.HomeComponent;
import com.example.darkwh.mvp_project.main.home.HomeContract;
import com.example.darkwh.mvp_project.main.home.HomeModule;
import com.example.darkwh.mvp_project.widget.ItemDivider;
import com.example.darkwh.mvp_project.widget.MyRecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Created by darkwh on 2016/6/12.
 * iOS
 */
public class IosFragment extends BaseFragment implements PtrHandler, HomeContract.View {

    private HomeComponent component;
    @Inject
    HomeContract.Presenter presenter;
    @Inject
    Context context;
    private String type = "iOS";

    @BindView(R.id.recycler_view)
    MyRecyclerView recyclerView;
    @BindView(R.id.refresh_view)
    PtrClassicFrameLayout refreshView;

    private BaseRecyclerAdapter<ShareBean> mAdapter = new BaseRecyclerAdapter<ShareBean>(R.layout.item_common_news) {
        @Override
        public BaseHolder provideBaseHolder(View itemView) {
            return new CommonNewsHolder(itemView, context);
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ios, null);
        unbinder = ButterKnife.bind(this, view);
        initComponent();
        initViews();
        presenter.refresh(type);
        return view;
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
        recyclerView.addItemDecoration(new ItemDivider(context,R.drawable.driver_shape));
        recyclerView.setAdapter(mAdapter);
        recyclerView.setScrolledToBottomListener(new MyRecyclerView.ScrolledToBottomListener() {
            @Override
            public void onScrolled() {
                presenter.getMore(type);
            }
        });
    }

    @Override
    public void onRefreshComplete(List<ShareBean> data) {
        mAdapter.setData(data);
        mAdapter.notifyDataSetChanged();
        refreshView.refreshComplete();
    }

    @Override
    public void onLoadMoreComplete(List<ShareBean> data) {
        mAdapter.getMore(data);
        mAdapter.notifyDataSetChanged();
        recyclerView.executeComplete();
    }

    @Override
    public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
        return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
    }

    @Override
    public void onRefreshBegin(PtrFrameLayout frame) {
        presenter.refresh(type);
    }
}
