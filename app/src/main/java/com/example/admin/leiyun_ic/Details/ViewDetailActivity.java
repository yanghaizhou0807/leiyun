package com.example.admin.leiyun_ic.Details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.Base.BaseApplication;
import com.example.admin.leiyun_ic.Base.BaseUrl;
import com.example.admin.leiyun_ic.Bean.UserLoginBean;
import com.example.admin.leiyun_ic.Details.Bean.ViewDetailBean;
import com.example.admin.leiyun_ic.Details.Bean.goodsDetailBean;
import com.example.admin.leiyun_ic.Details.adapter.ViewDetailAdapter;
import com.example.admin.leiyun_ic.R;
import com.example.admin.leiyun_ic.adapter.HomervAdapter;
import com.example.admin.leiyun_ic.utils.GsonQuick;
import com.heigo.http.okhttp.OkHttpUtils;
import com.heigo.http.okhttp.builder.GetBuilder;
import com.heigo.http.okhttp.callback.StringCallback;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import qiu.niorgai.StatusBarCompat;

public class ViewDetailActivity extends BaseActivity implements View.OnClickListener {

    private TextView all_evaluations_tv,new_evaluations_tv,good_evaluations_tv,middle_evaluations_tv,pic_evaluations_tv,add_evaluations_tv;
    private ViewDetailBean viewDetailBean;
    private UserLoginBean userLoginBean;
    private String nickname,deviceid,usertoken;
    private List<ViewDetailBean.DataBean.ListBean> list;
    private ArrayList<ViewDetailBean.DataBean.ListBean> allList;
    private RecyclerView rv_detail;
    private ViewDetailAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_details_acty);
        StatusBarCompat.translucentStatusBar(this);
        userLoginBean = BaseApplication.getInstance().getUserVO();
        if (!"".equals(userLoginBean) && null != userLoginBean) {
            deviceid = userLoginBean.getData().getDevice_id();
            Logger.e("response-22-deviceid--->>:" + deviceid);
            usertoken = userLoginBean.getData().getUser_token();
            Logger.e("response-22-usertoken--->>:" + usertoken);
        }
        initView();
    }

    private void initView() {
        rv_detail = (RecyclerView)findViewById(R.id.rv_detail);
        rv_detail.setNestedScrollingEnabled(false);
        LinearLayoutManager linerLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv_detail.setLayoutManager(linerLayoutManager);
        rv_detail.setLayoutManager(new GridLayoutManager(this, 1));

        allList = new ArrayList<ViewDetailBean.DataBean.ListBean>();

        add_evaluations_tv = (TextView)findViewById(R.id.add_evaluations_tv);
        pic_evaluations_tv = (TextView)findViewById(R.id.pic_evaluations_tv);
        good_evaluations_tv = (TextView)findViewById(R.id.good_evaluations_tv);
        new_evaluations_tv = (TextView)findViewById(R.id.new_evaluations_tv);
        all_evaluations_tv = (TextView)findViewById(R.id.all_evaluations_tv);
        middle_evaluations_tv = (TextView)findViewById(R.id.middle_evaluations_tv);

        viewDetailInfo();
    }

    private void viewDetailInfo() {
        GetBuilder builders = OkHttpUtils.get();
        builders.addParams("device_id",deviceid);
        builders.addParams("goods_id","121474");
        builders.addParams("order_state","0");//0-全部; 1-好评;  2-有图; 3-追加;
        builders.addParams("page","1");
        builders.addParams("per_page","10");
        builders.addParams("user_token",usertoken);
        builders.url(BaseUrl.viewDetailUrl).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int i) {
            }
            @Override
            public void onResponse(String s, int i) {
                Logger.d("response-22-全部评论页>>:" + s);
                viewDetailBean = GsonQuick.toObject(s, ViewDetailBean.class);
                if("请求成功".equals(viewDetailBean.getMsg())){
                    all_evaluations_tv.setText("全部("+viewDetailBean.getData().getListCount().getAll()+")");
                    new_evaluations_tv.setText("最新("+viewDetailBean.getData().getListCount().getAll()+")");
                    good_evaluations_tv.setText("好评("+viewDetailBean.getData().getListCount().getGood()+")");
                    middle_evaluations_tv.setText("中评("+viewDetailBean.getData().getListCount().getNormal()+")");
                    pic_evaluations_tv.setText("有图("+viewDetailBean.getData().getListCount().getImage()+")");
                    add_evaluations_tv.setText("追加("+viewDetailBean.getData().getListCount().getEval_again()+")");

                    if(viewDetailBean.getData().getList().size()>=1){
                        list = viewDetailBean.getData().getList();
                        allList.addAll(list);
                        adapter = new ViewDetailAdapter(context, allList);
                        rv_detail.setAdapter(adapter);

                    }
                }

            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
