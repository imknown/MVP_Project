package com.example.darkwh.mvp_project.holders;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.darkwh.mvp_project.R;
import com.example.darkwh.mvp_project.bean.ShareBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by darkwh on 2016/6/17.
 */
public class CommonNewsHolder extends BaseHolder<ShareBean> {

    @BindView(R.id.text_title)
    TextView title;
    @BindView(R.id.text_time)
    TextView time;
    @BindView(R.id.text_author)
    TextView author;

    public CommonNewsHolder(View itemView, Context context) {
        super(itemView, context);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void initViews() {

    }

    @Override
    public void dataBinding(ShareBean data) {
        title.setText(data.getDesc());
        time.setText(data.getPublishedAt().substring(0,10));
    }
}
