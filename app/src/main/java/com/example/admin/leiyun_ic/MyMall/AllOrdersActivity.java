package com.example.admin.leiyun_ic.MyMall;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.HomePage.Fragment.Fragment_1;
import com.example.admin.leiyun_ic.HomePage.Fragment.Fragment_2;
import com.example.admin.leiyun_ic.HomePage.Fragment.Fragment_3;
import com.example.admin.leiyun_ic.HomePage.Fragment.Fragment_4;
import com.example.admin.leiyun_ic.HomePage.Fragment.Fragment_5;
import com.example.admin.leiyun_ic.MyMall.adapter.BaseFragmentAdapter;
import com.example.admin.leiyun_ic.MyMall.fragment.AllOrdersFragment;
import com.example.admin.leiyun_ic.R;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import qiu.niorgai.StatusBarCompat;

public class AllOrdersActivity extends BaseActivity implements View.OnClickListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView titleView;
    private String itemIdNum;
    private int pages=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_orders_acty);
        StatusBarCompat.translucentStatusBar(this);
        itemIdNum = getIntent().getStringExtra("itemIdNum");
        Log.d(TAG, "initView: ---itemIdNum"+itemIdNum);
        pages = Integer.parseInt(itemIdNum);
        initView();
    }


    private List<String> mTitles = new ArrayList<String>() {
        {
            add("全部");
            add("待付款");
            add("待发货");
            add("待收货");
            add("待评价");
        }
    };

    private void initView() {

        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        viewPager = (ViewPager)findViewById(R.id.viewpager);

        titleView = (TextView) findViewById(R.id.head_title);
        titleView.setText("我的订单");
        initSelect();
        initViewPager();


    }

    /**
     * 初始化水平选择栏
     */
    private void initSelect() {
        //设置TabLayout的模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        //需要自定义布局时，需要在绑定viewpager前加入布局
        for (int i = 0; i < mTitles.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(mTitles.get(i)));
        }
    }

    /**
     * 初始化ViewPager
     */
    private void initViewPager() {
        final ArrayList<Fragment> fragmentList = new ArrayList<>();
        /*MerchandiseListBaseFragment merchandiseListAll = MerchandiseListBaseFragment.
                newInstance(0);
        MerchandiseListBaseFragment merchandiseListDisPatch = MerchandiseListBaseFragment.
                newInstance(1);
        MerchandiseListBaseFragment merchandiseListReceive = MerchandiseListBaseFragment.
                newInstance(2);
        MerchandiseListBaseFragment merchandiseListFinish = MerchandiseListBaseFragment.
                newInstance(3);
        MerchandiseListBaseFragment.firstGetData();*/

        fragmentList.add(new AllOrdersFragment());
        fragmentList.add(new AllOrdersFragment());//
        fragmentList.add(new AllOrdersFragment());//
        fragmentList.add(new AllOrdersFragment());//
        fragmentList.add(new AllOrdersFragment());//

        FragmentPagerAdapter fragmentAdapter = new BaseFragmentAdapter(getSupportFragmentManager(), fragmentList, mTitles);
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setCurrentItem(pages);
        viewPager.setOffscreenPageLimit(2);//预加载
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.getTabAt(position).select();
                Logger.d("position---position>>:" + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //viewpager状态 1 正在滑动 2滑动完毕 0 什么都没做
            }
        });
        tabLayout.setupWithViewPager(viewPager);//联动
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
//                ((MerchandiseListBaseFragment) fragmentList.get(tab.getPosition())).fresh();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
