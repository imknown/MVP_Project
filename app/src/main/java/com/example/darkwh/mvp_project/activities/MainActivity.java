package com.example.darkwh.mvp_project.activities;

import android.os.Bundle;
import android.widget.Toast;

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
        setTitleBar(titleBar);
        initViews();
    }

    @Override
    protected void configTitleBar() {
        titleBar.setTextTitle(R.string.app_title);
        titleBar.setCustomNavigationIcon(v->{
            Toast.makeText(getBaseContext(),"测试一下",Toast.LENGTH_SHORT).show();
        });
    }

    private void initViews() {
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_title_bar, menu);
        return true;
    }*/
}
