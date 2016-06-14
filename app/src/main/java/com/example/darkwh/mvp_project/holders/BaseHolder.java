package com.example.darkwh.mvp_project.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by darkwh on 2016/6/14.
 */
public abstract class BaseHolder<T> extends RecyclerView.ViewHolder {

    View itemView;

    public BaseHolder(View itemView) {
        super(itemView);
    }

    public void setItemView(View itemView) {
        this.itemView = itemView;
    }

    public abstract void dataBinding(T data);

    public abstract void initViews();

}
