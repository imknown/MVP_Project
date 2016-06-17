package com.example.darkwh.mvp_project.holders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.darkwh.mvp_project.R;
import com.example.darkwh.mvp_project.entity.ShareEntity;
import com.example.darkwh.mvp_project.utils.ImageUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by darkwh on 2016/6/14.
 */
public class MeiZhiHolder extends BaseHolder<ShareEntity> {

    String[] str = {"测", "试", "文", "字", ",", "用", "于", "体", "现", "瀑", "布", "流", "效", "果", "测", "试", "文", "字", ",", "用", "于", "体", "现", "瀑", "布", "流", "效", "果", "测", "试", "文", "字", ",", "用", "于", "体", "现", "瀑", "布", "流", "效", "果"};

    @BindView(R.id.img_meizhi)
    ImageView img_meizhi;
    @BindView(R.id.text_description)
    TextView text_description;

    public MeiZhiHolder(View itemView, Context context) {
        super(itemView, context);
        ButterKnife.bind(this, itemView);
    }


    @Override
    public void initViews() {

    }

    @Override
    public void dataBinding(ShareEntity data) {
        ImageUtil.loadImage(context, data.getUrl(), img_meizhi);
        int x = 1 + (int) (Math.random() * 42);
        String content = data.getDesc();
        for (int i = 0; i < x; i++) {
            content += str[i];
        }
        text_description.setText(content);
    }
}
