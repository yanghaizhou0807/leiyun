package com.example.admin.leiyun_ic.MyMall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.R;

import qiu.niorgai.StatusBarCompat;

public class AccountSecurityActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_security_acty);
        StatusBarCompat.translucentStatusBar(this);
    }

    @Override
    public void onClick(View v) {

    }
}
