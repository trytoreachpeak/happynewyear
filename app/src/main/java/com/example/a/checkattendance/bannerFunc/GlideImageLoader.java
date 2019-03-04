package com.example.a.checkattendance.bannerFunc;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.youth.banner.loader.ImageLoader;

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        Glide.with(context).load(path).apply(RequestOptions.bitmapTransform(new GlideRoundCropTransform(context, 10))).into(imageView);
    }
}
