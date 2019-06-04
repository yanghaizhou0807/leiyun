package com.example.admin.leiyun_ic.HomePage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.Base.BaseApplication;
import com.example.admin.leiyun_ic.Base.BaseUrl;
import com.example.admin.leiyun_ic.Bean.ADInfo;
import com.example.admin.leiyun_ic.Bean.HomeEntityBean;
import com.example.admin.leiyun_ic.Bean.HomeRecycleViewBean;
import com.example.admin.leiyun_ic.Bean.HomepageNagtBean;
import com.example.admin.leiyun_ic.Bean.NavigationBean;
import com.example.admin.leiyun_ic.Bean.NewHomeEntityBean;
import com.example.admin.leiyun_ic.Bean.NewHomeRecycleViewBean;
import com.example.admin.leiyun_ic.Bean.NewHomepageNagtBean;
import com.example.admin.leiyun_ic.Bean.UserLoginBean;
import com.example.admin.leiyun_ic.Details.CommodityDetailsActivity;
import com.example.admin.leiyun_ic.LoginActivity;
import com.example.admin.leiyun_ic.R;
import com.example.admin.leiyun_ic.adapter.HomervAdapter;
import com.example.admin.leiyun_ic.utils.GsonQuick;
import com.example.admin.leiyun_ic.utils.ImageLoaderUtil;
import com.example.admin.leiyun_ic.views.CycleViewPager;
import com.heigo.http.okhttp.OkHttpUtils;
import com.heigo.http.okhttp.builder.GetBuilder;
import com.heigo.http.okhttp.callback.StringCallback;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;

public class HomePageActivity extends BaseActivity implements View.OnClickListener {

    private CycleViewPager cycleViewPager;
    private ViewPager vp;
    private NewHomeEntityBean homeEntityBean;
    private NewHomepageNagtBean homepageNagtBean;
    private NewHomeRecycleViewBean homeRecycleViewBean;
    private NavigationBean navigationBean;
    private RecyclerView rv;
    private ImageView banner1, banner2, banner3;
    private ImageView icon_1, icon_2, icon_3, icon_4, icon_5, icon_6, icon_7, icon_8;
    private ImageView home3_1, home3_2, home3_3, home3_4, home3_5, home3_6, home3_7, home3_8, home3_9, home3_10, home3_11, home3_12;
    private TextView icon_tv1, icon_tv2, icon_tv3, icon_tv4, icon_tv5, icon_tv6, icon_tv7, icon_tv8;
    private TextView not_login_tv;

    //List<String> list = new ArrayList<>();
    private HomervAdapter adapter;
    private UserLoginBean userLoginBean;
    private String nickname;
    private RelativeLayout rl_user_info;
    private TextView tv_user_name, title_3;
    private ImageView com_1, com_2, com_3, com_4, com_5, com_6, com_7, com_8;
    private TextView price_1, price_2, price_3, price_4, price_5, price_6, price_7, price_8;
    private ScrollView scrollview;
    //private List<HomeRecycleViewBean.JsonResultBean> list;
    // private ArrayList<HomeRecycleViewBean.JsonResultBean> allList;
    private List<NewHomeRecycleViewBean.DataBean.ListBean> list;
    private ArrayList<NewHomeRecycleViewBean.DataBean.ListBean> allList;
    private RelativeLayout top_background, sliding_top_background;
    private String url = "http://api.weboo.top";
    //
    private TextView pinpai_tv, jinkou_tv, koubei_tv, renqi_tv, pintuan_tv, daren_tv;
    private LinearLayout pinpai_llyt, jinkou_llyt;
    private String device_id, user_token;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.homepage_acty);
        userLoginBean = BaseApplication.getInstance().getUserVO();
        if (!"".equals(userLoginBean) && null != userLoginBean) {
            nickname = userLoginBean.getData().getNickname();
            Logger.e("nickname--->>:" + nickname);
        }
        navigationBean = BaseApplication.getInstance().getNavigationBean();
        if (!"".equals(navigationBean) && null != navigationBean) {
            device_id = navigationBean.getData().getDevice_id();
            user_token = navigationBean.getData().getUser_token();
            Logger.e("device_id--->>:" + device_id);
            Logger.e("user_token--->>:" + user_token);
        }
        initView();
        //initdata();

        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setNestedScrollingEnabled(false);
        LinearLayoutManager linerLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linerLayoutManager);
        rv.setLayoutManager(new GridLayoutManager(this, 2));
        //设置分隔线
        //mRecycleView.addItemDecoration(new DividerItemDecoration(this , DividerItemDecoration.VERTICAL_LIST));
        //设置增加或删除条目动画
        //rv.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    protected void onStart() {
        userLoginBean = BaseApplication.getInstance().getUserVO();
        if (!"".equals(userLoginBean) && null != userLoginBean) {
            nickname = userLoginBean.getData().getNickname();
            Logger.e("nickname--->>:" + nickname);
        }
        if (!"".equals(nickname) && null != nickname) {
            not_login_tv.setVisibility(View.GONE);
            rl_user_info.setVisibility(View.VISIBLE);
            tv_user_name.setText(nickname);
        } else {
            not_login_tv.setVisibility(View.VISIBLE);
            rl_user_info.setVisibility(View.GONE);
        }
        super.onStart();
    }

    /*private void initdata() {
        mData = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            mData.add("item" + i);
            Log.i(TAG, "initdata: item" + i);
        }
    }*/


    //icon接口
    private void HomepageNagtInterface() {
        GetBuilder builders = OkHttpUtils.get();
        //builder.addParams("method", "wap_home.special");
        //map.put("method", "wap_home.wap_nav");
        builders.addParams("device_id", "70468f8cf496b15a");
        builders.addParams("user_token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJKV1QiLCJpYXQiOjE1NTk1NDgyNDUsImV4cCI6MzExOTA5NjQ5MCwiYXVkIjoiYXBpQmFzZSIsInN1YiI6IjExMTFhcGlCYXNlIiwiZGF0YSI6eyJkZXZpY2VfaWQiOiI3MDQ2OGY4Y2Y0OTZiMTVhIn19.6J3Q9XzrvqRIcxOW5phCTqcEUfazYXlXYZBDlLK2JVQ");
        builders.url(BaseUrl.iconUrl).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int i) {

            }

            @Override
            public void onResponse(String s, int i) {
                Logger.d("response2--->>:" + s);
                if (!"".equals(s)) {
                    homepageNagtBean = GsonQuick.toObject(s, NewHomepageNagtBean.class);
                    if ("请求成功".equals(homeEntityBean.getMsg())) {
                        if (!"".equals(homepageNagtBean.getData().get(0).getNav_pic())) {
                            Glide.with(context).load(url + homepageNagtBean.getData().get(0).getNav_pic()).into(icon_1);
                            icon_tv1.setText(homepageNagtBean.getData().get(0).getNav_name());
                        }
                        if (!"".equals(homepageNagtBean.getData().get(1).getNav_pic())) {
                            Glide.with(context).load(url + homepageNagtBean.getData().get(1).getNav_pic()).into(icon_2);
                            icon_tv2.setText(homepageNagtBean.getData().get(1).getNav_name());
                        }
                        if (!"".equals(homepageNagtBean.getData().get(2).getNav_pic())) {
                            Glide.with(context).load(url + homepageNagtBean.getData().get(2).getNav_pic()).into(icon_3);
                            icon_tv3.setText(homepageNagtBean.getData().get(2).getNav_name());
                        }
                        if (!"".equals(homepageNagtBean.getData().get(3).getNav_pic())) {
                            Glide.with(context).load(url + homepageNagtBean.getData().get(3).getNav_pic()).into(icon_4);
                            icon_tv4.setText(homepageNagtBean.getData().get(3).getNav_name());
                        }
                        if (!"".equals(homepageNagtBean.getData().get(4).getNav_pic())) {
                            Glide.with(context).load(url + homepageNagtBean.getData().get(4).getNav_pic()).into(icon_5);
                            icon_tv5.setText(homepageNagtBean.getData().get(4).getNav_name());
                        }
                        if (!"".equals(homepageNagtBean.getData().get(5).getNav_pic())) {
                            Glide.with(context).load(url + homepageNagtBean.getData().get(5).getNav_pic()).into(icon_6);
                            icon_tv6.setText(homepageNagtBean.getData().get(5).getNav_name());
                        }
                        if (!"".equals(homepageNagtBean.getData().get(6).getNav_pic())) {
                            Glide.with(context).load(url + homepageNagtBean.getData().get(6).getNav_pic()).into(icon_7);
                            icon_tv7.setText(homepageNagtBean.getData().get(6).getNav_name());
                        }
                        if (!"".equals(homepageNagtBean.getData().get(7).getNav_pic())) {
                            Glide.with(context).load(url + homepageNagtBean.getData().get(7).getNav_pic()).into(icon_8);
                            icon_tv8.setText(homepageNagtBean.getData().get(7).getNav_name());
                        }

                    }
                }

            }
        });

    }

    //楼层接口
    private void HomeStartInterface() {
        GetBuilder builder = OkHttpUtils.get();
        //builder.addParams("method", "wap_home.special");
        builder.addParams("device_id", "70468f8cf496b15a");
        //builder.addParams("debug", "1");
        builder.addParams("user_token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJKV1QiLCJpYXQiOjE1NTk1NDgyNDUsImV4cCI6MzExOTA5NjQ5MCwiYXVkIjoiYXBpQmFzZSIsInN1YiI6IjExMTFhcGlCYXNlIiwiZGF0YSI6eyJkZXZpY2VfaWQiOiI3MDQ2OGY4Y2Y0OTZiMTVhIn19.6J3Q9XzrvqRIcxOW5phCTqcEUfazYXlXYZBDlLK2JVQ");
        builder.url(BaseUrl.baseUrl).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int i) {
                Logger.e("error--->>:" + e.getMessage());
            }

            @Override
            public void onResponse(String s, int i) {
                //   ProgressDialogManager.getInstance().dissmiss();
                Logger.d("response1--->>:" + s);
                if (!"".equals(s)) {
                    homeEntityBean = GsonQuick.toObject(s, NewHomeEntityBean.class);
                    // 1 banner
                    if ("请求成功".equals(homeEntityBean.getMsg())) {
                        if ("".equals(homeEntityBean.getData().get(0).getData1().getImg_url())) {
                            ImageLoaderUtil.LoadImage(context, R.mipmap.advertising_background, banner1);
                        } else {
                            Glide.with(context).load(url + homeEntityBean.getData().get(0).getData1().getImg_url()).into(banner1);
                        }
                        // 2
                        if (!"".equals(homeEntityBean.getData().get(1).getData2().getList().get(0).getGoodsInfo().get(0).getImg())) {
                            Glide.with(context).load(homeEntityBean.getData().get(1).getData2().getList().get(0).getGoodsInfo().get(0).getImg()).into(home3_1);
                        }
                        if (!"".equals(homeEntityBean.getData().get(1).getData2().getList().get(0).getGoodsInfo().get(1).getImg())) {
                            Glide.with(context).load(homeEntityBean.getData().get(1).getData2().getList().get(0).getGoodsInfo().get(1).getImg()).into(home3_2);
                        }
                        if (!"".equals(homeEntityBean.getData().get(1).getData2().getList().get(1).getGoodsInfo().get(0).getImg())) {
                            Glide.with(context).load(homeEntityBean.getData().get(1).getData2().getList().get(1).getGoodsInfo().get(0).getImg()).into(home3_3);
                        }
                        if (!"".equals(homeEntityBean.getData().get(1).getData2().getList().get(1).getGoodsInfo().get(1).getImg())) {
                            Glide.with(context).load(homeEntityBean.getData().get(1).getData2().getList().get(1).getGoodsInfo().get(1).getImg()).into(home3_4);
                        }

                        // 3 banner 福利
                        if ("".equals(homeEntityBean.getData().get(2).getData3().getImg_url())) {
                            ImageLoaderUtil.LoadImage(context, R.mipmap.advertising_background, banner2);
                        } else {
                            Glide.with(context).load(url + homeEntityBean.getData().get(2).getData3().getImg_url()).into(banner2);
                            title_3.setText(homeEntityBean.getData().get(2).getData3().getTitle());
                        }
                        if (!"".equals(homeEntityBean.getData().get(2).getData3().getList().get(0).getImg())) {
                            Glide.with(context).load(homeEntityBean.getData().get(2).getData3().getList().get(0).getImg()).into(com_1);
                            price_1.setText("￥" + homeEntityBean.getData().get(2).getData3().getList().get(0).getGoods_marketprice());
                        }
                        if (!"".equals(homeEntityBean.getData().get(2).getData3().getList().get(1).getImg())) {
                            Glide.with(context).load(homeEntityBean.getData().get(2).getData3().getList().get(1).getImg()).into(com_2);
                            price_2.setText("￥" + homeEntityBean.getData().get(2).getData3().getList().get(1).getGoods_marketprice());
                        }
                        if (!"".equals(homeEntityBean.getData().get(2).getData3().getList().get(2).getImg())) {
                            Glide.with(context).load(homeEntityBean.getData().get(2).getData3().getList().get(2).getImg()).into(com_3);
                            price_3.setText("￥" + homeEntityBean.getData().get(2).getData3().getList().get(2).getGoods_marketprice());
                        }
                        if (!"".equals(homeEntityBean.getData().get(2).getData3().getList().get(3).getImg())) {
                            Glide.with(context).load(homeEntityBean.getData().get(2).getData3().getList().get(3).getImg()).into(com_4);
                            price_4.setText("￥" + homeEntityBean.getData().get(2).getData3().getList().get(3).getGoods_marketprice());
                        }
                        if (!"".equals(homeEntityBean.getData().get(2).getData3().getList().get(4).getImg())) {
                            Glide.with(context).load(homeEntityBean.getData().get(2).getData3().getList().get(4).getImg()).into(com_5);
                            price_5.setText("￥" + homeEntityBean.getData().get(2).getData3().getList().get(4).getGoods_marketprice());
                        }
                        if (!"".equals(homeEntityBean.getData().get(2).getData3().getList().get(5).getImg())) {
                            Glide.with(context).load(homeEntityBean.getData().get(2).getData3().getList().get(5).getImg()).into(com_6);
                            price_6.setText("￥" + homeEntityBean.getData().get(2).getData3().getList().get(5).getGoods_marketprice());
                        }
                        if (!"".equals(homeEntityBean.getData().get(2).getData3().getList().get(6).getImg())) {
                            Glide.with(context).load(homeEntityBean.getData().get(2).getData3().getList().get(6).getImg()).into(com_7);
                            price_7.setText("￥" + homeEntityBean.getData().get(2).getData3().getList().get(6).getGoods_marketprice());
                        }
                        if (!"".equals(homeEntityBean.getData().get(2).getData3().getList().get(7).getImg())) {
                            Glide.with(context).load(homeEntityBean.getData().get(2).getData3().getList().get(7).getImg()).into(com_8);
                            price_8.setText("￥" + homeEntityBean.getData().get(2).getData3().getList().get(7).getGoods_marketprice());
                        }

                        //5 优惠专区
                        if (!"".equals(homeEntityBean.getData().get(3).getData4().getList().get(0).getGoodsInfo().get(0).getImg())) {
                            Glide.with(context).load(homeEntityBean.getData().get(3).getData4().getList().get(0).getGoodsInfo().get(0).getImg()).into(home3_5);
                        }
                        if (!"".equals(homeEntityBean.getData().get(3).getData4().getList().get(0).getGoodsInfo().get(1).getImg())) {
                            Glide.with(context).load(homeEntityBean.getData().get(3).getData4().getList().get(0).getGoodsInfo().get(1).getImg()).into(home3_6);
                        }
                        if (!"".equals(homeEntityBean.getData().get(3).getData4().getList().get(1).getGoodsInfo().get(0).getImg())) {
                            Glide.with(context).load(homeEntityBean.getData().get(3).getData4().getList().get(1).getGoodsInfo().get(0).getImg()).into(home3_7);
                        }
                        if (!"".equals(homeEntityBean.getData().get(3).getData4().getList().get(1).getGoodsInfo().get(1).getImg())) {
                            Glide.with(context).load(homeEntityBean.getData().get(3).getData4().getList().get(1).getGoodsInfo().get(1).getImg()).into(home3_8);
                        }
                        if (!"".equals(homeEntityBean.getData().get(3).getData4().getList().get(2).getGoodsInfo().get(0).getImg())) {
                            Glide.with(context).load(homeEntityBean.getData().get(3).getData4().getList().get(2).getGoodsInfo().get(0).getImg()).into(home3_9);
                        }
                        if (!"".equals(homeEntityBean.getData().get(3).getData4().getList().get(2).getGoodsInfo().get(1).getImg())) {
                            Glide.with(context).load(homeEntityBean.getData().get(3).getData4().getList().get(2).getGoodsInfo().get(1).getImg()).into(home3_10);
                        }
                        if (!"".equals(homeEntityBean.getData().get(3).getData4().getList().get(3).getGoodsInfo().get(0).getImg())) {
                            Glide.with(context).load(homeEntityBean.getData().get(3).getData4().getList().get(3).getGoodsInfo().get(0).getImg()).into(home3_11);
                        }
                        if (!"".equals(homeEntityBean.getData().get(3).getData4().getList().get(3).getGoodsInfo().get(1).getImg())) {
                            Glide.with(context).load(homeEntityBean.getData().get(3).getData4().getList().get(3).getGoodsInfo().get(1).getImg()).into(home3_12);
                        }
                        // banner3
                        if ("".equals(homeEntityBean.getData().get(4).getData1().getImg_url())) {
                            ImageLoaderUtil.LoadImage(context, R.mipmap.advertising_background, banner3);
                        } else {
                            Glide.with(context).load(url + homeEntityBean.getData().get(4).getData1().getImg_url()).into(banner3);
                        }

                    }

                }

            }
        });
    }

    private void initView() {//
        pinpai_llyt = (LinearLayout) findViewById(R.id.pinpai_llyt);
        pinpai_llyt.setOnClickListener(this);
        jinkou_llyt = (LinearLayout) findViewById(R.id.jinkou_llyt);
        jinkou_llyt.setOnClickListener(this);

        pinpai_tv = (TextView) findViewById(R.id.pinpai_tv);
        Shader shader = new LinearGradient(0, 0, 0, 40, Color.YELLOW, Color.RED, Shader.TileMode.CLAMP);
        pinpai_tv.getPaint().setShader(shader);
        jinkou_tv = (TextView) findViewById(R.id.jinkou_tv);
        jinkou_tv.getPaint().setShader(shader);
        koubei_tv = (TextView) findViewById(R.id.koubei_tv);
        koubei_tv.getPaint().setShader(shader);
        renqi_tv = (TextView) findViewById(R.id.renqi_tv);
        renqi_tv.getPaint().setShader(shader);
        pintuan_tv = (TextView) findViewById(R.id.pintuan_tv);
        pintuan_tv.getPaint().setShader(shader);
        daren_tv = (TextView) findViewById(R.id.daren_tv);
        daren_tv.getPaint().setShader(shader);

        allList = new ArrayList<NewHomeRecycleViewBean.DataBean.ListBean>();

        sliding_top_background = (RelativeLayout) findViewById(R.id.sliding_top_background);
        top_background = (RelativeLayout) findViewById(R.id.top_background);

        icon_1 = (ImageView) findViewById(R.id.icon_1);//福利商城
        icon_1.setOnClickListener(this);
        icon_2 = (ImageView) findViewById(R.id.icon_2);//新品首发
        icon_2.setOnClickListener(this);
        icon_3 = (ImageView) findViewById(R.id.icon_3);//劳保专区
        icon_3.setOnClickListener(this);
        icon_4 = (ImageView) findViewById(R.id.icon_4);//限时团购
        icon_4.setOnClickListener(this);
        icon_5 = (ImageView) findViewById(R.id.icon_5);//生鲜优选
        icon_5.setOnClickListener(this);
        icon_6 = (ImageView) findViewById(R.id.icon_6);//办公好物
        icon_6.setOnClickListener(this);
        icon_7 = (ImageView) findViewById(R.id.icon_7);//亲子家庭
        icon_7.setOnClickListener(this);
        icon_8 = (ImageView) findViewById(R.id.icon_8);//积分优享
        icon_8.setOnClickListener(this);

        icon_tv1 = (TextView) findViewById(R.id.icon_tv1);
        icon_tv2 = (TextView) findViewById(R.id.icon_tv2);
        icon_tv3 = (TextView) findViewById(R.id.icon_tv3);
        icon_tv4 = (TextView) findViewById(R.id.icon_tv4);
        icon_tv5 = (TextView) findViewById(R.id.icon_tv5);
        icon_tv6 = (TextView) findViewById(R.id.icon_tv6);
        icon_tv7 = (TextView) findViewById(R.id.icon_tv7);
        icon_tv8 = (TextView) findViewById(R.id.icon_tv8);

        home3_1 = (ImageView) findViewById(R.id.home3_1);
        home3_1.setOnClickListener(this);
        home3_2 = (ImageView) findViewById(R.id.home3_2);
        home3_3 = (ImageView) findViewById(R.id.home3_3);
        home3_4 = (ImageView) findViewById(R.id.home3_4);
        home3_5 = (ImageView) findViewById(R.id.home3_5);
        home3_6 = (ImageView) findViewById(R.id.home3_6);
        home3_7 = (ImageView) findViewById(R.id.home3_7);
        home3_8 = (ImageView) findViewById(R.id.home3_8);
        home3_9 = (ImageView) findViewById(R.id.home3_9);
        home3_10 = (ImageView) findViewById(R.id.home3_10);
        home3_11 = (ImageView) findViewById(R.id.home3_11);
        home3_12 = (ImageView) findViewById(R.id.home3_12);

        //福利精选...
        com_1 = (ImageView) findViewById(R.id.com_1);
        com_2 = (ImageView) findViewById(R.id.com_2);
        com_3 = (ImageView) findViewById(R.id.com_3);
        com_4 = (ImageView) findViewById(R.id.com_4);
        com_5 = (ImageView) findViewById(R.id.com_5);
        com_6 = (ImageView) findViewById(R.id.com_6);
        com_7 = (ImageView) findViewById(R.id.com_7);
        com_8 = (ImageView) findViewById(R.id.com_8);
        price_1 = (TextView) findViewById(R.id.price_1);
        price_2 = (TextView) findViewById(R.id.price_2);
        price_3 = (TextView) findViewById(R.id.price_3);
        price_4 = (TextView) findViewById(R.id.price_4);
        price_5 = (TextView) findViewById(R.id.price_5);
        price_6 = (TextView) findViewById(R.id.price_6);
        price_7 = (TextView) findViewById(R.id.price_7);
        price_8 = (TextView) findViewById(R.id.price_8);


        banner1 = (ImageView) findViewById(R.id.banner_1);
        banner2 = (ImageView) findViewById(R.id.banner2);
        banner3 = (ImageView) findViewById(R.id.banner3);
        title_3 = (TextView) findViewById(R.id.title_3);

        not_login_tv = (TextView) findViewById(R.id.not_login_tv);
        not_login_tv.setOnClickListener(this);
        rl_user_info = (RelativeLayout) findViewById(R.id.rl_user_info);
        tv_user_name = (TextView) findViewById(R.id.tv_user_name);

        if (!"".equals(nickname) && null != nickname) {
            not_login_tv.setVisibility(View.GONE);
            rl_user_info.setVisibility(View.VISIBLE);
            tv_user_name.setText(nickname);
        } else {
            not_login_tv.setVisibility(View.VISIBLE);
            rl_user_info.setVisibility(View.GONE);
        }

        scrollview = (ScrollView) findViewById(R.id.scrollview);
        scrollview.setOnTouchListener(new TouchListenerImpl());


        //楼层
        HomeStartInterface();
        //icon
        HomepageNagtInterface();
        //猜你喜欢
        HomeRecyclerViewInterface();

        // cycleViewPager = (CycleViewPager) getFragmentManager().findFragmentById(R.id.frame_layout);
        // initialize();

    }

    private class TouchListenerImpl implements View.OnTouchListener {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:

                    break;
                case MotionEvent.ACTION_MOVE:
                    int scrollY = view.getScrollY();
                    int height = view.getHeight();
                    int scrollViewMeasuredHeight = scrollview.getChildAt(0).getMeasuredHeight();
                    if (scrollY == 0) {
                        //System.out.println("滑动到了顶端 view.getScrollY()="+scrollY);
                        Logger.d("response---滑动到了顶端>>:" + scrollY);

                    }
                    if ((scrollY + height) == scrollViewMeasuredHeight) {
                        //System.out.println("滑动到了底部 scrollY="+scrollY);
                        Logger.d("response---滑动到了底部>>:" + scrollY);
                        // HomeRecyclerViewInterface();
                        //new Thread(new CustomThread()).start();
                        //System.out.println("滑动到了底部 height="+height);
                        //System.out.println("滑动到了底部 scrollViewMeasuredHeight="+scrollViewMeasuredHeight);
                    }
                    break;

                default:
                    break;
            }
            return false;
        }

    }

    public class CustomThread implements Runnable {
        @Override
        public void run() {
            // 处理耗时逻辑
            try {
                Thread.sleep(1000);
                // HomeRecyclerViewInterface();
            } catch (Exception e) {

            }

        }
    }

    private void HomeRecyclerViewInterface() {
        //ProgressDialogManager.getInstance().showWait(this, "正在加载...");
        GetBuilder builderss = OkHttpUtils.get();
        //builder.addParams("method", "wap_home.product_list");
        builderss.addParams("device_id", "70468f8cf496b15a");
        builderss.addParams("user_token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJKV1QiLCJpYXQiOjE1NTk1NDgyNDUsImV4cCI6MzExOTA5NjQ5MCwiYXVkIjoiYXBpQmFzZSIsInN1YiI6IjExMTFhcGlCYXNlIiwiZGF0YSI6eyJkZXZpY2VfaWQiOiI3MDQ2OGY4Y2Y0OTZiMTVhIn19.6J3Q9XzrvqRIcxOW5phCTqcEUfazYXlXYZBDlLK2JVQ");
        builderss.url(BaseUrl.recyclerViewUrl).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int i) {
                //ProgressDialogManager.getInstance().dissmiss();
            }

            @Override
            public void onResponse(String s, int i) {
                // ProgressDialogManager.getInstance().dissmiss();
                Logger.d("response3---rv>>:" + s);
                if (!"".equals(s)) {
                    homeRecycleViewBean = GsonQuick.toObject(s, NewHomeRecycleViewBean.class);
                    if ("请求成功".equals(homeEntityBean.getMsg())) {
                        if (homeRecycleViewBean.getData().getList().size() >= 1) {
                            list = homeRecycleViewBean.getData().getList();
                            allList.addAll(list);
                            adapter = new HomervAdapter(context, allList);
                            rv.setAdapter(adapter);
                        }
                    }

                }
            }
        });
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
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.not_login_tv:
                Intent intent = new Intent(HomePageActivity.this, LoginActivity.class);
                //intent.putExtra("itemIdNum",itemIdNum);
                //intent.putExtra("categoryIds",categoryIds);
                HomePageActivity.this.startActivity(intent);
                break;
            case R.id.icon_1:
                Intent welfare = new Intent(HomePageActivity.this, WelfareMallLevelActivity.class);//福利商城
                HomePageActivity.this.startActivity(welfare);

                break;
            case R.id.icon_2:
                Intent first = new Intent(HomePageActivity.this, FirstEpisodeActivity.class);//新品首发
                HomePageActivity.this.startActivity(first);

                break;
            case R.id.icon_3:
                Intent labor = new Intent(HomePageActivity.this, LaborActivity.class);//劳保专区
                HomePageActivity.this.startActivity(labor);

                break;
            case R.id.icon_4:
                Intent limit = new Intent(HomePageActivity.this, LimitedTimeActivity.class);//限时团购
                HomePageActivity.this.startActivity(limit);

                break;
            case R.id.icon_5:
                Intent fresh = new Intent(HomePageActivity.this, FreshSelectionActivity.class);//生鲜优选
                HomePageActivity.this.startActivity(fresh);

                break;
            case R.id.icon_6:
                Intent offic = new Intent(HomePageActivity.this, OfficeGoodActivity.class);//办公好物
                HomePageActivity.this.startActivity(offic);

                break;
            case R.id.icon_7:
                Intent parent = new Intent(HomePageActivity.this, ParentChildActivity.class);//亲子家庭
                HomePageActivity.this.startActivity(parent);

                break;
            case R.id.icon_8:
                Intent integral = new Intent(HomePageActivity.this, IntegralSuperiorityActivity.class);//积分优享
                HomePageActivity.this.startActivity(integral);

                break;

            case R.id.home3_1:
                Intent commdetail = new Intent(HomePageActivity.this, CommodityDetailsActivity.class);
                HomePageActivity.this.startActivity(commdetail);

                break;

            case R.id.pinpai_llyt:
                Intent pinpai = new Intent(HomePageActivity.this, BrandExclusiveActivity.class);
                HomePageActivity.this.startActivity(pinpai);

                break;


        }

    }

    private long exitTime = 0;

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
