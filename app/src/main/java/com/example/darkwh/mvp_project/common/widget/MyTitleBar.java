package com.example.darkwh.mvp_project.common.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.darkwh.mvp_project.R;
import com.example.darkwh.mvp_project.common.listener.MyTitlebarListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by darkwh on 2016/5/31.
 */
public class MyTitleBar extends Toolbar implements Toolbar.OnMenuItemClickListener {

    @BindView(R.id.text_title)
    TextView textTitle;

    private MyTitlebarListener titlebarListener;
    private Activity activity;
    private int icon_back = R.mipmap.ic_back;
    private int icon_reorder = R.mipmap.ic_reorder;

    public MyTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.title_text, this);
        ButterKnife.bind(view);
    }

    public void bindActivity(Activity activity) {
        this.activity = activity;
    }

    public void setTitlebarListener(MyTitlebarListener titlebarListener) {
        this.titlebarListener = titlebarListener;
    }

    public void setCanBack(boolean canback) {
        if (canback) {
            setNavigationIcon(icon_back);
            setNavigationOnClickListener(v -> {
                finishActivity();
            });
        }
    }

    public void setCanBack(boolean canback, int resourceId) {
        if (canback) {
            setNavigationIcon(resourceId);
            setNavigationOnClickListener(v -> {
                finishActivity();
            });
        }
    }

    private void finishActivity() {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        }
        else {
            activity.finish();
        }
    }


    public void setCustomNavigationIcon(OnClickListener listener) {
        setNavigationIcon(icon_reorder);
        setNavigationListener(listener);
    }

    public void setCustomNavigationIcon(int resourceId, OnClickListener listener) {
        setNavigationIcon(resourceId);
        setNavigationListener(listener);
    }


    private void setNavigationListener(OnClickListener listener) {
        setNavigationOnClickListener(listener);
    }

    public void setTextTitle(String str) {
        textTitle.setText(str);
    }

    public void setTextTitle(int resourceID) {
        textTitle.setText(resourceID);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                titlebarListener.onSaveBtnClick();
                break;
            case R.id.action_collection:
                titlebarListener.onCollectionBtnClick();
                break;
            case R.id.action_share:
                titlebarListener.onShareBtnClick();
                break;
        }
        return true;
    }


}
