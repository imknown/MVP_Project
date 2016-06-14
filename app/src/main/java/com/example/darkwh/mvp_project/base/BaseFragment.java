package com.example.darkwh.mvp_project.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.darkwh.mvp_project.component.AppComponent;
import com.example.darkwh.mvp_project.component.DaggerFragmentComponent;
import com.example.darkwh.mvp_project.component.FragmentComponent;
import com.example.darkwh.mvp_project.module.FragmentModule;

/**
 * Created by darkwh on 2016/6/14.
 */
public class BaseFragment extends Fragment {

    private FragmentComponent fragmentComponent;

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
}
