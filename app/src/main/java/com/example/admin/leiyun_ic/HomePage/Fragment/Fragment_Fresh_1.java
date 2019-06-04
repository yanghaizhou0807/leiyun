package com.example.admin.leiyun_ic.HomePage.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.admin.leiyun_ic.Bean.ADInfo;
import com.example.admin.leiyun_ic.R;
import com.example.admin.leiyun_ic.views.CycleViewPager;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Fresh_1 extends Fragment {

    private ViewPager viewPager;
    TextView textView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fresh_fragment_1, container,false);
        viewPager = (ViewPager)view.findViewById(R.id.vp);
        /*textView = (TextView) view.findViewById(R.id.text);
        textView.setText("这是第5个Fragment");*/

        return view;

    }



}
