package com.example.admin.leiyun_ic.HomePage;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.Bean.ADInfo;
import com.example.admin.leiyun_ic.R;
import com.example.admin.leiyun_ic.views.CycleViewPager;

import java.util.ArrayList;
import java.util.List;

import qiu.niorgai.StatusBarCompat;

import static com.example.admin.leiyun_ic.HomePage.HomePageActivity.getImageView;

public class WelfareMallLevelActivity extends BaseActivity implements View.OnClickListener {

    private Button search_btn,back_btn;
    private LinearLayout headerParent;
    private ScrollView welfare_scrollview;
    private CycleViewPager cycleViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welfare_malllevel_acty);
        StatusBarCompat.translucentStatusBar(this);
        initView();
    }

    private void initView() {

        headerParent = (LinearLayout)findViewById(R.id.headerParent_welfare);
        welfare_scrollview = (ScrollView)findViewById(R.id.welfare_scrollview);

        Rect rectangle= new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rectangle);

         cycleViewPager = (CycleViewPager) getFragmentManager().findFragmentById(R.id.frame_layout);
         initialize();
        /*search_btn = (Button)findViewById(R.id.search_btn);
        search_btn.setOnClickListener(this);
        back_btn = (Button)findViewById(R.id.back_btn);
        back_btn.setOnClickListener(this);*/

    }

    private void initialize() {
        List<ADInfo> infos = new ArrayList<ADInfo>();
        List<ImageView> views = new ArrayList<ImageView>();
        List<String> listImageUrl = new ArrayList<>();
        listImageUrl.add("http://www.helibuy.cn/data/upload/mobile/special/s0/s0_05992208847673789.jpg");
        listImageUrl.add("http://www.helibuy.cn/data/upload/mobile/special/s0/s0_05999238668304550.jpg");
        for (int i = 0; i < listImageUrl.size(); i++) {
            ADInfo info = new ADInfo();
            info.setUrl(listImageUrl.get(i));
            info.setContent("http://www.baidu.com");
            infos.add(info);
        }
        // 将最后一个ImageView添加进来
        views.add(getImageView(this, infos.get(infos.size() - 1).getUrl()));
        for (int i = 0; i < infos.size(); i++) {
            views.add(getImageView(this, infos.get(i).getUrl()));
        }
        // 将第一个ImageView添加进来
        views.add(getImageView(this, infos.get(0).getUrl()));
        // 设置循环，在调用setData方法前调用
        cycleViewPager.setCycle(true);
        // 在加载数据前设置是否循环
        cycleViewPager.setData(views, infos, mAdCycleViewListener);
        //设置轮播
        cycleViewPager.setWheel(true);
        // 设置轮播时间，默认5000ms
        cycleViewPager.setTime(2000);
        //设置圆点指示图标组居中显示，默认靠右
        cycleViewPager.setIndicatorCenter();
    }

    /**
     * 设置底部轮播图的点击事件
     */
    private CycleViewPager.ImageCycleViewListener mAdCycleViewListener = new CycleViewPager.ImageCycleViewListener() {

        @Override
        public void onImageClick(ADInfo info, int position, View imageView) {
            if (info.getContent() != null && !"".equals(info.getContent())) {
               /* Uri uri = Uri.parse(info.getContent());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);*/

            }
        }
    };

    /**
     * 获取ImageView视图的同时加载显示url
     *
     * @param
     * @return
     */
    public static ImageView getImageView(Context context, String url) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.mipmap.bg_background)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.mipmap.bg_background);
        ImageView imageView = (ImageView) LayoutInflater.from(context).inflate(
                R.layout.view_banner, null);
        Glide.with(context)
                .load(url)
                .apply(requestOptions)
                .into(imageView);
        //imageView.setImageResource(R.mipmap.login_background);
        return imageView;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /*case R.id.back_btn:
                WelfareMallLevelActivity.this.finish();
                break;*/
        }

    }
}
