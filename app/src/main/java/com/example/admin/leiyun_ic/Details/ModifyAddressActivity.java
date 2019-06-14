package com.example.admin.leiyun_ic.Details;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.Base.BaseApplication;
import com.example.admin.leiyun_ic.Base.BaseUrl;
import com.example.admin.leiyun_ic.Bean.NewHomeRecycleViewBean;
import com.example.admin.leiyun_ic.Bean.UserAddressListBean;
import com.example.admin.leiyun_ic.Bean.UserLoginBean;
import com.example.admin.leiyun_ic.R;
import com.example.admin.leiyun_ic.adapter.AddressListAdapter;
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

public class ModifyAddressActivity extends BaseActivity implements View.OnClickListener,AddressListAdapter.OnItemClickListener {

    private Button new_address_btn;
    private ImageView iv_address;
    private UserAddressListBean userAddressListBean;
    private RecyclerView rv;
    private UserLoginBean userLoginBean;
    private String nickname,deviceid,usertoken;
    private List<UserAddressListBean.DataBeanX.DataBean> list;
    private ArrayList<UserAddressListBean.DataBeanX.DataBean> allList;
    private AddressListAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify_address_acty);
        StatusBarCompat.translucentStatusBar(this);
        userLoginBean = BaseApplication.getInstance().getUserVO();
        if (!"".equals(userLoginBean) && null != userLoginBean) {
            nickname = userLoginBean.getData().getNickname();
            Logger.e("nickname--->>:" + nickname);
            deviceid = userLoginBean.getData().getDevice_id();
            Logger.e("response-22-deviceid--->>:" + deviceid);
            usertoken = userLoginBean.getData().getUser_token();
            Logger.e("response-22-usertoken--->>:" + usertoken);
        }
        new_address_btn = (Button)findViewById(R.id.new_address_btn);
        new_address_btn.setOnClickListener(this);
        iv_address = (ImageView) findViewById(R.id.iv_address);
        iv_address.setOnClickListener(this);
        rv = (RecyclerView)findViewById(R.id.add_rv);
        rv.setNestedScrollingEnabled(false);
        LinearLayoutManager linerLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linerLayoutManager);
        rv.setLayoutManager(new GridLayoutManager(this, 1));
        allList = new ArrayList<UserAddressListBean.DataBeanX.DataBean>();
        AddressListInfo();
    }

    private void AddressListInfo() {
        GetBuilder builders = OkHttpUtils.get();
        builders.addParams("device_id",deviceid);
        builders.addParams("user_token",usertoken);
        builders.addParams("list_rows","20");
        builders.addParams("page","");
        builders.url(BaseUrl.AddressListUrl).build().execute(new StringCallback() {

            @Override
            public void onError(Call call, Exception e, int i) {

            }

            @Override
            public void onResponse(String s, int i) {
                Logger.d("response-22-用户地址信息>>:" + s);
                if (!"".equals(s)) {
                    userAddressListBean = GsonQuick.toObject(s, UserAddressListBean.class);
                    if ("请求成功".equals(userAddressListBean.getMsg())) {
                        if (userAddressListBean.getData().getData().size() >= 1) {
                            rv.setVisibility(View.VISIBLE);
                            iv_address.setVisibility(View.GONE);
                            list = userAddressListBean.getData().getData();
                            allList.addAll(list);
                            adapter = new AddressListAdapter(context, allList);
                            rv.setAdapter(adapter);
                        } else {
                            rv.setVisibility(View.GONE);
                            iv_address.setVisibility(View.VISIBLE);
                        }
                    }

                }

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.new_address_btn:
            case R.id.iv_address:
                Intent intent = new Intent(ModifyAddressActivity.this, AddAddressActivity.class);
                ModifyAddressActivity.this.startActivity(intent);
                break;
        }

    }

    @Override
    public void onItemClick(View v, int position) {
        adapter.setOnItemClickListener(new AddressListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(ModifyAddressActivity.this,"---l1>>"+position+"---",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
