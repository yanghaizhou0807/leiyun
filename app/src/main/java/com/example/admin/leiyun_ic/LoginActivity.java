package com.example.admin.leiyun_ic;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.Base.BaseApplication;
import com.example.admin.leiyun_ic.Base.BaseUrl;
import com.example.admin.leiyun_ic.Bean.NavigationBean;
import com.example.admin.leiyun_ic.Bean.UserLoginBean;
import com.example.admin.leiyun_ic.HomePage.HomePageActivity;
import com.example.admin.leiyun_ic.utils.DeviceUtil;
import com.example.admin.leiyun_ic.utils.DialogUtils;
import com.example.admin.leiyun_ic.utils.GsonQuick;
import com.example.admin.leiyun_ic.utils.ProgressDialogManager;
import com.example.admin.leiyun_ic.utils.RegularUtils;
import com.heigo.http.okhttp.callback.StringCallback;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import qiu.niorgai.StatusBarCompat;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private TextView not_login_tv;
    private Button  login_btn;
    private EditText phone_et, password_et;
    private String phone, password,device,username;
    private UserLoginBean userLoginBean;
    private ImageView top_close_btn;
    private LinearLayout password_llyt,message_llyt;
    private ImageView password_login_iv,message_login_iv;
    private NavigationBean navigationBean;
    private String user_token;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_acty);
        StatusBarCompat.translucentStatusBar(this);
        navigationBean = BaseApplication.getInstance().getNavigationBean();
        if (!"".equals(navigationBean) && null != navigationBean) {
            user_token = navigationBean.getData().getUser_token();
            Logger.e("user_token--->>:" + user_token);
        }
        initView();
    }

    private void initView() {

        device = DeviceUtil.getDeviceId(context);
        Log.d("success-->>>", device);
        top_close_btn = (ImageView) findViewById(R.id.top_close_btn);
        top_close_btn.setOnClickListener(this);
        phone_et = findViewById(R.id.phone_et);
        phone_et.setOnClickListener(this);
        password_et = findViewById(R.id.password_et);
        password_et.setOnClickListener(this);
        login_btn = findViewById(R.id.login_btn);
        login_btn.setOnClickListener(this);

        password_llyt = (LinearLayout)findViewById(R.id.password_llyt);
        password_llyt.setOnClickListener(this);
        message_llyt = (LinearLayout)findViewById(R.id.message_llyt);
        message_llyt.setOnClickListener(this);
        message_login_iv = (ImageView)findViewById(R.id.message_login_iv);
        password_login_iv = (ImageView)findViewById(R.id.password_login_iv);

    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.password_llyt:
                password_login_iv.setVisibility(View.VISIBLE);
                message_login_iv.setVisibility(View.INVISIBLE);
                break;
            case R.id.message_llyt:
                password_login_iv.setVisibility(View.INVISIBLE);
                message_login_iv.setVisibility(View.VISIBLE);
                break;
            case R.id.top_close_btn:
                LoginActivity.this.finish();
                break;
            case R.id.login_btn:
                phone = phone_et.getText().toString().trim();
                password = password_et.getText().toString();
                if (phone == null || "".equals(phone)) {
                    DialogUtils.showToast(this, this.getResources().getString(R.string.input_telephone_strg));
                    return;
                }
                if (password == null || "".equals(password)) {
                    DialogUtils.showToast(this, this.getResources().getString(R.string.input_pwd_strg));
                    return;
                }
                if (RegularUtils.checkChinese(password)) {
                    DialogUtils.showToast(this, this.getResources().getString(R.string.pwd_descri_strg));
                    return;
                }
                ProgressDialogManager.getInstance().showWait(this, "正在加载...");
                Map<String, String> param = new HashMap<>();
                param.put("name", phone);
                param.put("password", password);
                param.put("device_id", device);
                param.put("user_token", user_token);
                post(param, BaseUrl.loginUrl, new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int i) {
                        ProgressDialogManager.getInstance().dissmiss();
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onResponse(String s, int i) {
                        ProgressDialogManager.getInstance().dissmiss();
                        Log.d("success-->>>", s);
                        userLoginBean = GsonQuick.toObject(s, UserLoginBean.class);
                        BaseApplication.getInstance().setUserVO(userLoginBean);
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });

                break;

        }

    }
}
