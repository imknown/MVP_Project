package com.example.darkwh.mvp_project.main.android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.darkwh.mvp_project.R;
import com.example.darkwh.mvp_project.base.BaseFragment;

/**
 * Created by darkwh on 2016/6/12.
 * Android
 */
public class AndroidFragment extends BaseFragment implements AndroidContract.View {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_android,null);
    }
}
