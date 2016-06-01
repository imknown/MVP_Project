package com.example.darkwh.mvp_project.common.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.darkwh.mvp_project.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by darkwh on 2016/5/31.
 */
public class MyTitleBar extends LinearLayout implements Toolbar.OnMenuItemClickListener {

    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.titleBar)
    Toolbar titleBar;

    private Activity activity;
    private int icon_back = R.mipmap.ic_back;
    private int icon_reorder = R.mipmap.ic_reorder;

    public MyTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.common_titlebar, this);
        ButterKnife.bind(view);
    }

    public void bindActivity(Activity activity) {
        this.activity = activity;
    }

    public void setCanBack(boolean canback) {
        if (canback) {
            titleBar.setNavigationIcon(icon_back);
            titleBar.setNavigationOnClickListener(v -> {
                finishActivity();
            });
        }
    }

    public void setCanBack(boolean canBack, int resourceId) {
        if (canBack) {
            titleBar.setNavigationIcon(resourceId);
            titleBar.setNavigationOnClickListener(v -> {
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
        titleBar.setNavigationIcon(icon_reorder);
        setNavigationListener(listener);
    }

    public void setCustomNavigationIcon(int resourceId, OnClickListener listener) {
        titleBar.setNavigationIcon(resourceId);
        setNavigationListener(listener);
    }


    public void setNavigationListener(OnClickListener listener) {
        titleBar.setNavigationOnClickListener(listener);
    }

    public void setTextTitle(String str) {
        textTitle.setText(str);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
//                Toast.makeText(context,"测试一下",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    public Toolbar getTitleBar() {
        return titleBar;
    }
}
