package com.example.darkwh.mvp_project.main.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.darkwh.mvp_project.R;
import com.example.darkwh.mvp_project.adapter.BaseRecyclerAdapter;
import com.example.darkwh.mvp_project.base.BaseFragment;
import com.example.darkwh.mvp_project.component.DaggerHomeComponent;
import com.example.darkwh.mvp_project.component.HomeComponent;
import com.example.darkwh.mvp_project.entity.ShareEntity;
import com.example.darkwh.mvp_project.holders.BaseHolder;
import com.example.darkwh.mvp_project.holders.MeiZhiHolder;
import com.example.darkwh.mvp_project.module.HomeModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
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
    @BindView(R.id.recyckerView)
    RecyclerView recyckerView;

    HomeComponent homeComponent;
    @Inject
    HomeContract.Presenter presenter;
    @Inject
    Context context;

    private BaseRecyclerAdapter<ShareEntity> mAdapter = new BaseRecyclerAdapter<ShareEntity>(R.layout.item_meizhi) {
        @Override
        public BaseHolder provideBaseHolder(View itemView) {
            return new MeiZhiHolder(itemView);
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, view);
        initComponent();
        initViews();
        return view;
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
        recyckerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyckerView.setAdapter(mAdapter);
    }

    @Override
    public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
        return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
    }

    @Override
    public void onRefreshBegin(PtrFrameLayout frame) {
        Toast.makeText(getActivity(), "开始刷新", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateUI() {

    }
}
