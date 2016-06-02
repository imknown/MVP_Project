package com.example.darkwh.mvp_project.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.darkwh.mvp_project.common.widget.MyTitleBar;

/**
 * Created by darkwh on 2016/5/31.
 */
public abstract class ToolBarActivity extends AppCompatActivity {

    private MyTitleBar titleBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void setTitleBar(MyTitleBar titleBar){
        this.titleBar = titleBar;
        setSupportActionBar(titleBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        titleBar.bindActivity(this);
        configTitleBar();
    }


    protected void configTitleBar() {
        titleBar.setCanBack(true);
    }

}

