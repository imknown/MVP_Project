package com.example.darkwh.mvp_project.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.example.darkwh.mvp_project.component.AppComponent;
import com.example.darkwh.mvp_project.component.DaggerFragmentComponent;
import com.example.darkwh.mvp_project.component.FragmentComponent;
import com.example.darkwh.mvp_project.bean.BaseBean;
import com.example.darkwh.mvp_project.module.FragmentModule;

import javax.inject.Inject;

/**
 * Created by darkwh on 2016/6/14.
 */
public class BaseFragment extends Fragment implements BaseView {

    private FragmentComponent fragmentComponent;

    @Inject
    Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initComponent();
    }

    private void initComponent(){
        fragmentComponent = DaggerFragmentComponent.builder()
                .appComponent(getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
        fragmentComponent.inject(this);
    }

    public FragmentModule getFragmentModule(){
        return new FragmentModule(this);
    }

    public AppComponent getAppComponent(){
        BaseApplication application = (BaseApplication) getActivity().getApplication();
        return application.getAppComponent();
    }

    @Override
    public void onNetError(Throwable e) {
        Toast.makeText(context,"网络请求异常",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getNetResDataError(BaseBean baseEntity) {
        Toast.makeText(context,"网络请求失败",Toast.LENGTH_SHORT).show();
    }
}
