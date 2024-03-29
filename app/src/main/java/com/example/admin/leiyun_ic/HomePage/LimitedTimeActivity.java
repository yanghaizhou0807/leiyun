package com.example.admin.leiyun_ic.HomePage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.HomePage.Fragment.Fragment_2;
import com.example.admin.leiyun_ic.HomePage.Fragment.Fragment_3;
import com.example.admin.leiyun_ic.HomePage.Fragment.Fragment_4;
import com.example.admin.leiyun_ic.HomePage.Fragment.Fragment_5;
import com.example.admin.leiyun_ic.HomePage.Fragment.Fragment_6;
import com.example.admin.leiyun_ic.HomePage.Fragment.Fragment_Child_1;
import com.example.admin.leiyun_ic.HomePage.Fragment.Fragment_Group_buying_1;
import com.example.admin.leiyun_ic.HomePage.adapter.PagerAdapter;
import com.example.admin.leiyun_ic.HomePage.model.SlideTabView;
import com.example.admin.leiyun_ic.R;

import java.util.ArrayList;
import java.util.List;

import qiu.niorgai.StatusBarCompat;

public class LimitedTimeActivity extends FragmentActivity implements View.OnClickListener {

    private Button search_btn,back_btn,danru;
    private SlideTabView tabView;
    private ViewPager viewPager;
    private PagerAdapter adapter;
    private List<String> strings;
    private List<Fragment> list;

    private TextView charge_iv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_episode_acty);
        StatusBarCompat.translucentStatusBar(this);
        initView();
    }
    private void initView() {

        charge_iv = (TextView) findViewById(R.id.charge_iv);
        charge_iv.setText("限时团购");

        search_btn = (Button) findViewById(R.id.search_btn);
        search_btn.setOnClickListener(this);
        back_btn = (Button) findViewById(R.id.back_btn);
        back_btn.setOnClickListener(this);
        danru = (Button) findViewById(R.id.danru);
        danru.setOnClickListener(this);

        tabView = (SlideTabView) findViewById(R.id.tab);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        strings = new ArrayList<>();
        list = new ArrayList<>();

        list.add(new Fragment_Group_buying_1());
        list.add(new Fragment_2());
        list.add(new Fragment_3());
        list.add(new Fragment_4());
        list.add(new Fragment_5());
        adapter = new PagerAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);
        strings.add("今日精选");
        strings.add("居家日用");
        strings.add("食品百货");
        strings.add("服饰鞋包");
        strings.add("3C家电");
        tabView.initTab(strings, viewPager);
    }

    @Override
    public void onClick(View v) {

    }
}
