package com.example.gujianlong126.utils;
/*
 *@auther:谷建龙
 *@Date: 2019/12/6
 *@Time:9:04
 *@Description:
 * */


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.example.gujianlong126.R;
import com.example.gujianlong126.app.MyApp;

public class GlideUtils {
    public static void loadImage(String url, ImageView imageView) {
        Glide.with(MyApp.mContext)
                .load(url)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
