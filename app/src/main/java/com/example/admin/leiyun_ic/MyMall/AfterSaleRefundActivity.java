package com.example.admin.leiyun_ic.MyMall;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.MyMall.adapter.BaseFragmentAdapter;
import com.example.admin.leiyun_ic.MyMall.fragment.AllOrdersFragment;
import com.example.admin.leiyun_ic.R;
import com.orhanobut.logger.Logger;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import qiu.niorgai.StatusBarCompat;

public class AfterSaleRefundActivity extends BaseActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView titleView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.after_sale_refund_acty);
        StatusBarCompat.translucentStatusBar(this);
        initView();
    }
    private void initView() {

        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        addTabs(tabLayout);
        //添加完所有tab后调用！！
        reflex(tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewpager);

        titleView = (TextView) findViewById(R.id.head_title);
        titleView.setText("售后退款");
        /*initSelect();*/
        initViewPager();

    }

    private List<String> mTitles = new ArrayList<String>() {
        {
            add("售后申请");
            add("申请记录");
        }
    };

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

        FragmentPagerAdapter fragmentAdapter = new BaseFragmentAdapter(getSupportFragmentManager(), fragmentList, mTitles);
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(1);//预加载
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

    public void reflex(final TabLayout tabLayout){
        //了解源码得知 线的宽度是根据 tabView的宽度来设置的
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                try {
                    //拿到tabLayout的mTabStrip属性
                    Field mTabStripField = tabLayout.getClass().getDeclaredField("mTabStrip");
                    mTabStripField.setAccessible(true);

                    LinearLayout mTabStrip = (LinearLayout) mTabStripField.get(tabLayout);

                    int dp10 = dip2px(tabLayout.getContext(), 40);

                    for (int i = 0; i < mTabStrip.getChildCount(); i++) {
                        View tabView = mTabStrip.getChildAt(i);

                        //拿到tabView的mTextView属性
                        Field mTextViewField = tabView.getClass().getDeclaredField("mTextView");
                        mTextViewField.setAccessible(true);

                        TextView mTextView = (TextView) mTextViewField.get(tabView);

                        tabView.setPadding(0, 0, 0, 0);

                        //因为我想要的效果是   字多宽线就多宽，所以测量mTextView的宽度
                        int width = 0;
                        width = mTextView.getWidth();
                        if (width == 0) {
                            mTextView.measure(0, 0);
                            width = mTextView.getMeasuredWidth();
                        }

                        //设置tab左右间距为10dp  注意这里不能使用Padding 因为源码中线的宽度是根据 tabView的宽度来设置的
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                        params.width = width ;
                        params.leftMargin = dp10;
                        params.rightMargin = dp10;
                        tabView.setLayoutParams(params);

                        tabView.invalidate();
                    }

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public static int dip2px(Context context, float dipValue) {

        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public void addTabs(TabLayout tabLayout){
        tabLayout.addTab(tabLayout.newTab().setText("售后申请"));
        tabLayout.addTab(tabLayout.newTab().setText("申请记录"));

    }
}
