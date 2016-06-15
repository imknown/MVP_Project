package com.example.darkwh.mvp_project.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.darkwh.mvp_project.R;
import com.example.darkwh.mvp_project.entity.ShareEntity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by darkwh on 2016/6/14.
 */
public class MeiZhiHolder extends BaseHolder<ShareEntity> {

    @BindView(R.id.img_meizhi)
    ImageView img_meizhi;
    @BindView(R.id.text_description)
    TextView text_description;

    public MeiZhiHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void initViews() {

    }

    @Override
    public void dataBinding(ShareEntity data) {
        text_description.setText("Text");
    }
}
