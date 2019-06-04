package com.example.admin.leiyun_ic.ClassIfication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;

import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.ClassIfication.adapter.MostLeftAdapter;
import com.example.admin.leiyun_ic.ClassIfication.adapter.MostRightAdapter;
import com.example.admin.leiyun_ic.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import qiu.niorgai.StatusBarCompat;

public class ClassIficationActivity extends BaseActivity implements SpringsScrollewView.OnSlideListenerInterface{

    private RecyclerView leftListView,rightListView;
    private RelativeLayout relativeLayout;
    private MostLeftAdapter leftAdapter;
    private MostRightAdapter rightAdapter;
    List<ChoiceLeftBean> mPriceList = new ArrayList<>();
    Animation animation1;
    SpringsScrollewView springsScrollewView;
    int currentPostion = 0;
    private String h= "键盘敲烂月薪过万";

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.classification_acty);
        ButterKnife.bind(this);
        StatusBarCompat.translucentStatusBar(this);
        initView();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        leftListView.setLayoutManager(layoutManager);
        leftAdapter = new MostLeftAdapter(this);
        leftListView.setAdapter(leftAdapter);
        springsScrollewView = (SpringsScrollewView) findViewById(R.id.root_scroll_view);
        springsScrollewView.setOnSlideListener(this);
        GridLayoutManager layoutManager1 = new GridLayoutManager(this,3) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
//        layoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
//        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        layoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        rightListView.setLayoutManager(layoutManager1);
        rightAdapter = new MostRightAdapter(this);
        rightListView.setAdapter(rightAdapter);
        rightAdapter.addFooterView(LayoutInflater.from(this).inflate(R.layout.home_floor_footer,null));
        /* rightAdapter.setOnItemClickListener(new MostRightAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                startActivity(new Intent(MyActivity.this, testActivity.class));
            }
        });*/
        getLeftName();
    }

    private void initView() {
        leftListView = (RecyclerView)findViewById(R.id.left_list);
        rightListView = (RecyclerView)findViewById(R.id.right_list);
        relativeLayout = (RelativeLayout) findViewById(R.id.service_slide_layout);

    }

    //设置左边数据源
    private void getLeftName() {

        for (int i = 0; i < 12; i++) {
            ChoiceLeftBean bean = new ChoiceLeftBean();
            if (i == 0) {
                bean.setName("品牌推荐");
            }
            if (i == 1) {
                bean.setName("电脑设备");
            }
            if (i == 2) {
                bean.setName("办公电器");
            }
            if (i == 3) {
                bean.setName("办公用品");
            }
            if (i == 4) {
                bean.setName("数码通讯");
            }
            if (i == 5) {
                bean.setName("文体运动");
            }
            if (i == 6) {
                bean.setName("劳保装饰");
            }
            if (i == 7) {
                bean.setName("服饰首饰");
            }
            if (i == 8) {
                bean.setName("汽车用品");
            }
            if (i == 9) {
                bean.setName("图书资料");
            }
            if (i == 9) {
                bean.setName("食品生鲜");
            }
            if (i == 10) {
                bean.setName("鞋包钟表");
            }
            if (i == 11) {
                bean.setName("母婴玩具");
            }
            mPriceList.add(bean);
        }

        List<String> prices = new ArrayList<>();
        for (ChoiceLeftBean priceBean : mPriceList) {
            prices.add(priceBean.getName());
        }
        leftAdapter.setList(prices);
        //默认根据left的第一项数据去加载右边得数据
        requestRightData(0);
        leftAdapter.notifyDataSetChanged();
        leftAdapter.setOnItemClickListener(new MostLeftAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                relativeLayout.clearAnimation();
//                relativeLayout.startAnimation(animation1);
                currentPostion = position;
                //设置position，根据position的状态刷新
                leftAdapter.setPosition(position);
                leftAdapter.notifyDataSetChanged();
                requestRightData(position);
            }
        });

    }

    private void requestRightData(int position) {
        //这里为了方便，直接更改左边的数据为右边加载的数据了，实际开发中改为所传参数即可
        String category = leftAdapter.getList().get(position);
        List<MostSeriesBean> list = new ArrayList<>();
        MostSeriesBean beans = new MostSeriesBean();
        for (int i = 0; i < 15; i++) {
            beans.setName(category + i);
            beans.setPrice("2000$" + i);
            list.add(beans);
        }
        getRightData(list);

    }

    private void getRightData(List<MostSeriesBean> beans) {
        rightAdapter.setList(beans);
        rightAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnSlideListener(float coordinate) {
        int length = mPriceList.size();
        //上滑
        if (coordinate > -50 && coordinate < 600) {
            //设置position，根据position的状态刷新
            if (currentPostion == 0) {
                currentPostion = currentPostion + 1;
            } else if (currentPostion<length-1){
                currentPostion++;
            }else if (currentPostion >=length-1) {
                return;
            }
            setRightAnimation(R.anim.anim_slide_out_from_bottom);
            leftAdapter.setPosition(currentPostion);
            leftAdapter.notifyDataSetChanged();
            requestRightData(currentPostion);
        } else if (coordinate > 1000) {
            //下拉
            if (currentPostion ==0){
                return;
            }else {
                currentPostion --;
            }
            if (currentPostion >=length) {
                return;
            }
            setRightAnimation(R.anim.anim_slide_out_from_top);
            leftAdapter.setPosition(currentPostion);
            leftAdapter.notifyDataSetChanged();
            requestRightData(currentPostion);
        }
        Log.i("currentPostion=",currentPostion+"");
    }

    private void setRightAnimation(int rAnim) {
        animation1 = AnimationUtils.loadAnimation(ClassIficationActivity.this, rAnim);
        animation1.setInterpolator(new DecelerateInterpolator());
        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        relativeLayout.clearAnimation();
        relativeLayout.startAnimation(animation1);
    }

}
