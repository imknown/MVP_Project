package com.example.darkwh.mvp_project.main.exresources;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.darkwh.mvp_project.R;
import com.example.darkwh.mvp_project.base.BaseFragment;

/**
 * Created by darkwh on 2016/6/12.
 * 扩展资源
 */
public class ExResourcesFragment extends BaseFragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exresources,null);
        return view;
    }
}
