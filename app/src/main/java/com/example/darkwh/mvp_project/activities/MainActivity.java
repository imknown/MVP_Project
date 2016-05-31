package com.example.darkwh.mvp_project.activities;

import android.os.Bundle;

import com.example.darkwh.mvp_project.R;
import com.example.darkwh.mvp_project.common.base.ToolBarActivity;
import com.example.darkwh.mvp_project.common.widget.MyTitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends ToolBarActivity {


    @BindView(R.id.title_bar)
    MyTitleBar titleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews(){
        setSupportActionBar(titleBar);
        titleBar.setLeftBtnId(R.mipmap.ic_back);
    }
}
