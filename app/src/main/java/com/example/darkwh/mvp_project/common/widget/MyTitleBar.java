package com.example.darkwh.mvp_project.common.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;

import com.example.darkwh.mvp_project.common.listener.MyTitlebarListener;

/**
 * Created by darkwh on 2016/5/31.
 */
public class MyTitleBar extends Toolbar {

    private MyTitlebarListener titlebarListener;

    public MyTitleBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setListener(MyTitlebarListener listener) {
        titlebarListener = listener;
    }

    public void setLeftBtnId(int id) {
        setNavigationIcon(id);
    }

}
