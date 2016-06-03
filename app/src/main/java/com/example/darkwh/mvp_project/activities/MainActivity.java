package com.example.darkwh.mvp_project.activities;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;

import com.example.darkwh.mvp_project.R;
import com.example.darkwh.mvp_project.common.base.ToolBarActivity;
import com.example.darkwh.mvp_project.common.widget.MyTitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends ToolBarActivity {


    @BindView(R.id.title_bar)
    MyTitleBar titleBar;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setTitleBar(titleBar);
        initViews();
    }

    @Override
    protected void configTitleBar() {
        setTextTitle(R.string.app_title);
        setCustomNavigationIcon(v -> drawerlayout.openDrawer(Gravity.LEFT));
    }

    private void initViews() {
    }

}
