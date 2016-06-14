package com.example.darkwh.mvp_project.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.darkwh.mvp_project.holders.BaseHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darkwh on 2016/6/14.
 */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseHolder> {

    private int layoutId;
    private List<T> data_list = new ArrayList<>();

    public BaseRecyclerAdapter(int layoutId) {
        this.layoutId = layoutId;
    }

    public void setData(List<T> data) {
        data_list.clear();
        data_list.addAll(data);
    }

    public void getMore(List<T> data) {
        data_list.addAll(data);
    }

    @Override
    public int getItemCount() {
        return data_list.size();
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent,false);
        return provideBaseHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        holder.initViews();
        holder.dataBinding(data_list.get(position));
    }

    public abstract BaseHolder provideBaseHolder(View itemView);

}
