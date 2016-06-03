package com.example.darkwh.mvp_project.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;

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
            menu.findItem(R.id.action_save).setVisible(true);
        }
        if (hasCollection) {
            menu.findItem(R.id.action_collection).setVisible(true);
        }
        if (hasShare) {
            menu.findItem(R.id.action_share).setVisible(true);
        }
        return true;
    }

    /**
     * 初始化菜单
     *
     * @param save       保存按钮的资源ID(若没有传0)
     * @param collection 收藏按钮的资源ID(若没有传0)
     * @param share      分享按钮的资源ID(若没有传0)
     */
    protected void initMenu(int save, int collection, int share) {
        if (save != 0) {
            icon_save = save;
            this.hasSave = true;
        }
        if (collection != 0) {
            icon_collection = collection;
            this.hasCollection = true;
        }
        if (share != 0) {
            icon_share = share;
            this.hasShare = true;
        }
    }

    /**
     * 初始化菜单
     *
     * @param hasSave       是否显示保存按钮
     * @param hasCollection 是否显示收藏按钮
     * @param hasShare      是否显示分享按钮
     */
    protected void initMenu(boolean hasSave, boolean hasCollection, boolean hasShare) {
        this.hasSave = hasSave;
        this.hasCollection = hasCollection;
        this.hasShare = hasShare;
    }

    /**
     * 设置是否有返回键
     *
     * @param canback
     */
    protected void setCanBack(boolean canback) {
        titleBar.setCanBack(canback);
    }

    /**
     * 设置是否有返回键
     *
     * @param canback
     * @param resourceId 返回键的图片资源ID
     */
    protected void setCanBack(boolean canback, int resourceId) {
        titleBar.setCanBack(canback, resourceId);
    }

    /**
     * 设置标题
     *
     * @param str
     */
    protected void setTextTitle(String str) {
        titleBar.setTextTitle(str);
    }

    /**
     * 设置标题
     *
     * @param resourceID 文字资源ID
     */
    protected void setTextTitle(int resourceID) {
        titleBar.setTextTitle(resourceID);
    }

    /**
     * 设置自定义的导航图标(左侧按钮)
     *
     * @param listener 点击事件的监听器
     */
    protected void setCustomNavigationIcon(View.OnClickListener listener) {
        titleBar.setCustomNavigationIcon(listener);
    }

    /**
     * 设置自定义的导航图标(左侧按钮)
     *
     * @param resourceId 图片资源的ID
     * @param listener   点击事件的监听器
     */
    protected void setCustomNavigationIcon(int resourceId, View.OnClickListener listener) {
        titleBar.setCustomNavigationIcon(resourceId, listener);
    }

    @Override
    public void onSaveBtnClick() {
    }

    @Override
    public void onCollectionBtnClick() {
    }

    @Override
    public void onShareBtnClick() {
    }
}

