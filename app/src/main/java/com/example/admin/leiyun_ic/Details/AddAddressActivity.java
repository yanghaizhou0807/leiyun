package com.example.admin.leiyun_ic.Details;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.Base.BaseApplication;
import com.example.admin.leiyun_ic.Base.BaseUrl;
import com.example.admin.leiyun_ic.Bean.UserLoginBean;
import com.example.admin.leiyun_ic.R;
import com.example.admin.leiyun_ic.utils.DialogUtils;
import com.google.gson.JsonObject;
import com.heigo.http.okhttp.OkHttpUtils;
import com.heigo.http.okhttp.builder.GetBuilder;
import com.heigo.http.okhttp.callback.StringCallback;
import com.orhanobut.logger.Logger;

import okhttp3.Call;
import qiu.niorgai.StatusBarCompat;

public class AddAddressActivity extends BaseActivity implements View.OnClickListener {

    private EditText user_name,mob_phone,address_et;
    private Button address_btn,delete,add_select_btn;
    private String name,phone,adddetail;
    private UserLoginBean userLoginBean;
    private String nickname,deviceid,usertoken;
    private BottomSheetDialog dialog;
    private String is_default="1";
    private CheckBox checkbox;
    private String truename,mobphone,areainfo,addressa,isdefault,addressids;
    private int addressid;
    private TextView area_info_tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_address_acty);
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


        initView();

        Intent intent = getIntent();
        truename=intent.getStringExtra("true_name");
        mobphone=intent.getStringExtra("mob_phone");
        areainfo=intent.getStringExtra("area_info");
        addressa=intent.getStringExtra("address");
        isdefault=intent.getStringExtra("is_default");
        addressids=intent.getStringExtra("address_id");
        if(!"".equals(truename)&&null!=truename){
            user_name.setText(truename);
            //addressid = Integer.parseInt(addressids);
            delete.setVisibility(View.VISIBLE);
        }else{
            delete.setVisibility(View.GONE);
        }
        if(!"".equals(mobphone)&&null!=mobphone){
            mob_phone.setText(mobphone);
        }
        if(!"".equals(areainfo)&&null!=areainfo){
            area_info_tv.setText(areainfo);
        }
        if(!"".equals(addressa)&&null!=addressa){
            address_et.setText(addressa);
        }




        SelectAddress();
    }

    private void initView() {

        area_info_tv = (TextView)findViewById(R.id.area_info_tv);

        user_name = (EditText)findViewById(R.id.user_name);
        mob_phone = (EditText)findViewById(R.id.mob_phone);
        address_et = (EditText)findViewById(R.id.address);
        address_btn = (Button)findViewById(R.id.address_btn);
        address_btn.setOnClickListener(this);
        delete = (Button)findViewById(R.id.delete);
        delete.setOnClickListener(this);
        add_select_btn = (Button)findViewById(R.id.add_select_btn);
        add_select_btn.setOnClickListener(this);
        checkbox = (CheckBox)findViewById(R.id.checkbox);
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    is_default ="1";
                    Logger.e("response-22-is_default--->>:" + is_default);
                }else{
                    is_default ="0";
                    Logger.e("response-22-is_default--->>:" + is_default);
                }

            }
        });

    }

    private void SelectAddress() {
        GetBuilder builders = OkHttpUtils.get();
        builders.addParams("device_id",deviceid);
        builders.addParams("user_token",usertoken);
        builders.url(BaseUrl.SelectAddressUrl).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int i) {

            }

            @Override
            public void onResponse(String s, int i) {
                Logger.d("response-22-查询省份地址>>:" + s);
            }
        });
    }



    private void DeleteAddress() {
        GetBuilder builders = OkHttpUtils.get();
        builders.addParams("device_id",deviceid);
        builders.addParams("user_token",usertoken);
        builders.addParams("address_id",addressids);
        builders.url(BaseUrl.deleteAddressUrl).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int i) {

            }

            @Override
            public void onResponse(String s, int i) {
                Logger.d("response-22-删除地址>>:" + s);
                JSONObject jsonObject = JSONObject.parseObject(s);
                String a = jsonObject.getString("code");
                int code = Integer.parseInt(a);
                if(200==code){
                    Toast.makeText(context, "删除成功", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.address_btn:
                name = user_name.getText().toString().trim();
                phone = mob_phone.getText().toString().trim();
                adddetail = address_et.getText().toString().trim();
                if (name == null || "".equals(name)) {
                    DialogUtils.showToast(this, this.getResources().getString(R.string.name_not_null));
                    return;
                }
                if (phone == null || "".equals(phone)) {
                    DialogUtils.showToast(this, this.getResources().getString(R.string.phone_not_null));
                    return;
                }
                if (adddetail == null || "".equals(adddetail)) {
                    DialogUtils.showToast(this, this.getResources().getString(R.string.detail_not_null));
                    return;
                }
                if(!"".equals(addressids)&&null!=addressids){
                    AddressModifyInfo();//修改
                }else{
                    AddressSubmissionInfo();//新增
                }

                break;

            case R.id.delete:
                //chooseMediaType();
                DeleteAddress();
                break;
            case R.id.add_select_btn:
                chooseMediaType();
                break;
            case R.id.provincial:

                break;
            case R.id.city:

                break;
            case R.id.street:

                break;

        }

    }


    private void chooseMediaType() {
        dialog = new BottomSheetDialog(AddAddressActivity.this);
        View bottomView = LayoutInflater.from(AddAddressActivity.this).inflate(R.layout.provincial_cities, null);

        RadioButton provincial = bottomView.findViewById(R.id.provincial);
        RadioButton city = bottomView.findViewById(R.id.city);
        RadioButton street = bottomView.findViewById(R.id.street);

        provincial.setOnClickListener(this);
        city.setOnClickListener(this);
        street.setOnClickListener(this);
//        tv_take_photo.setOnClickListener(this);


        dialog.setContentView(bottomView);
        dialog.show();

    }

    private void AddressSubmissionInfo() {
        GetBuilder builders = OkHttpUtils.get();
        builders.addParams("device_id",deviceid);
        builders.addParams("user_token",usertoken);
        builders.addParams("user_name",name);
        builders.addParams("mob_phone",phone);
        builders.addParams("address",adddetail);
        builders.addParams("is_default",is_default);
        builders.addParams("province_id","1");
        builders.addParams("area_id","36");
        builders.addParams("city_id","37");
        builders.addParams("area_info","1");
        builders.url(BaseUrl.SubmissionAddressUrl).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int i) {
                Logger.e("error--->>:" + e.getMessage());
            }

            @Override
            public void onResponse(String s, int i) {
                Logger.d("response-22-提交省份地址>>:" + s);
                JSONObject jsonObject = JSONObject.parseObject(s);
                String a = jsonObject.getString("code");
                int code = Integer.parseInt(a);
                if(200==code){
                    Toast.makeText(context, "添加修改成功", Toast.LENGTH_SHORT).show();
                    finish();
                }


            }

        });

    }



    private void AddressModifyInfo() {
        GetBuilder builders = OkHttpUtils.get();
        builders.addParams("device_id",deviceid);
        builders.addParams("user_token",usertoken);
        builders.addParams("user_name",name);
        builders.addParams("mob_phone",phone);
        builders.addParams("address",adddetail);
        builders.addParams("is_default",is_default);
        builders.addParams("province_id","1");
        builders.addParams("area_id","36");
        builders.addParams("city_id","37");
        builders.addParams("area_info","1");
        builders.addParams("address_id",addressids);
        builders.url(BaseUrl.modifyAddressUrl).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int i) {
                Logger.e("error--->>:" + e.getMessage());
            }

            @Override
            public void onResponse(String s, int i) {
                Logger.d("response-22-修改省份地址>>:" + s);
                JSONObject jsonObject = JSONObject.parseObject(s);
                String a = jsonObject.getString("code");
                int code = Integer.parseInt(a);
                if(200==code){
                    Toast.makeText(context, "修改成功", Toast.LENGTH_SHORT).show();
                    finish();
                }


            }

        });

    }

}
