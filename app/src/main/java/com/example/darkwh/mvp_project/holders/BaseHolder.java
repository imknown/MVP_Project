package com.example.darkwh.mvp_project.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by darkwh on 2016/6/14.
 */
public abstract class BaseHolder<T> extends RecyclerView.ViewHolder {

    protected Context context;
    View itemView;

    public BaseHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
    }

    public void setItemView(View itemView) {
        this.itemView = itemView;
    }

    public abstract void dataBinding(T data);

    public abstract void initViews();

}
