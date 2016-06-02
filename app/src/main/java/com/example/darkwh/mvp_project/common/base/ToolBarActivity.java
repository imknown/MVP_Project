package com.example.darkwh.mvp_project.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.Toast;

import com.example.darkwh.mvp_project.R;
import com.example.darkwh.mvp_project.common.listener.MyTitlebarListener;
import com.example.darkwh.mvp_project.common.widget.MyTitleBar;

/**
 * Created by darkwh on 2016/5/31.
 */
public class ToolBarActivity extends AppCompatActivity implements MyTitlebarListener {

    private MyTitleBar titleBar;
    private int icon_save = R.mipmap.ic_save;
    private int icon_collection = R.mipmap.ic_collection;
    private int icon_share = R.mipmap.ic_share;
    private boolean hasSave = false;
    private boolean hasCollection = false;
    private boolean hasShare = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void setTitleBar(MyTitleBar titleBar) {
        this.titleBar = titleBar;
        setSupportActionBar(titleBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        titleBar.bindActivity(this);
        titleBar.setOnMenuItemClickListener(titleBar);
        titleBar.setTitlebarListener(this);
        configTitleBar();
    }


    protected void configTitleBar() {
        titleBar.setCanBack(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_title_bar, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (hasSave) {
            menu.findItem(icon_save).setVisible(true);
        }
        if (hasCollection) {
            menu.findItem(icon_collection).setVisible(true);
        }
        if (hasShare) {
            menu.findItem(icon_collection).setVisible(true);
        }
        return true;
    }

    /**
     * 初始化菜单
     * @param save  保存按钮的资源ID(若没有传0)
     * @param collection    收藏按钮的资源ID(若没有传0)
     * @param share 分享按钮的资源ID(若没有传0)
     */
    public void initMenu(int save, int collection, int share) {
        if (save != 0) {
            icon_save = save;
            this.hasSave = hasSave;
        }
        if(collection != 0){

        }
//        icon_collection
//                icon_share
    }

    public void initMenu(boolean hasSave, boolean hasCollection, boolean hasShare) {
        this.hasSave = hasSave;
        this.hasCollection = hasCollection;
        this.hasShare = hasShare;
    }

    @Override
    public void onNavigationClick() {

    }

    @Override
    public void onSaveBtnClick() {
        Toast.makeText(this, "保存按钮", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCollectionBtnClick() {
        Toast.makeText(this, "收藏按钮", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShareBtnClick() {
        Toast.makeText(this, "分享按钮", Toast.LENGTH_SHORT).show();
    }
}

