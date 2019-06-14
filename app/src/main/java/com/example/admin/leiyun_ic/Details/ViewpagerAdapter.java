package com.example.admin.leiyun_ic.Details;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

public class ViewpagerAdapter extends PagerAdapter {
    Context context;
    List<String> list;
    public ViewpagerAdapter(Context context, List<String> list) {
        this.context=context;
        this.list=list;
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
    }

    @Override
    public int getCount() {

        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView=new ImageView(context);
        ImageLoader.getInstance().displayImage(list.get(position%list.size()),imageView);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(imageView);




        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


}
