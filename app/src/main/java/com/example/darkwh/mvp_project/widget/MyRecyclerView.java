package com.example.darkwh.mvp_project.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;

/**
 * Created by darkwh on 2016/6/16.
 * TODO 很多很多...
 * 自定义的RecyclerView
 */
public class MyRecyclerView extends RecyclerView {

    public interface ScrolledToBottomListener {

        void onScrolled();

    }


    private ScrolledToBottomListener bottomListener;
    private boolean isOnload = false;
    int[] lastPositions;
    int lastVisibleItemPosition;

    public MyRecyclerView(Context context) {
        super(context);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onScrolled(int dx, int dy) {
        super.onScrolled(dx, dy);
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) getLayoutManager();
        if (lastPositions == null) {
            lastPositions = new int[staggeredGridLayoutManager.getSpanCount()];
        }
        staggeredGridLayoutManager.findLastVisibleItemPositions(lastPositions);//不是很理解
        lastVisibleItemPosition = findMax(lastPositions);
    }

    @Override
    public void onScrollStateChanged(int state) {
        super.onScrollStateChanged(state);
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        int visibleItemCount = layoutManager.getChildCount();
        int totalItemCount = layoutManager.getItemCount();
        if (visibleItemCount > 0 && state == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItemPosition == totalItemCount - 1) {
            if (bottomListener != null) {
                if (!isOnload) {
                    isOnload = true;
                    bottomListener.onScrolled();
                }
            }
        }
    }

    public void setScrolledToBottomListener(ScrolledToBottomListener bottomListener) {
        this.bottomListener = bottomListener;
    }

    //滑到底部的监听方法执行完之后应该调用此方法,将标记重置
    public void executeComplete() {
        isOnload = false;
    }

    private int findMax(int[] lastPositions) {
        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
