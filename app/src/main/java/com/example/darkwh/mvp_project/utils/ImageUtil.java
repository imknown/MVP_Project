package com.example.darkwh.mvp_project.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by darkwh on 2016/6/16.
 */
public class ImageUtil {

    public static void loadImage(Context context, String url, ImageView targetView) {
        Glide.with(context)
                .load(url)
                .crossFade()
                .into(targetView);
    }
}
