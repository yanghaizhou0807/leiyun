package com.example.admin.leiyun_ic.HomePage.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.leiyun_ic.R;

public class Fragment_Group_buying_1 extends Fragment {

    private ViewPager viewPager;
    TextView textView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.group_buying_fragment_1, container,false);
        //viewPager = (ViewPager)view.findViewById(R.id.vp);

        return view;

    }
}
