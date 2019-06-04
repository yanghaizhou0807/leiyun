package com.example.admin.leiyun_ic.HomePage.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.leiyun_ic.R;

/**
 * 创建：
 * 日期：2019/4/29.
 * 注释：
 */
public class Fragment_1 extends Fragment {
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container,false);
        return view;

    }

}
