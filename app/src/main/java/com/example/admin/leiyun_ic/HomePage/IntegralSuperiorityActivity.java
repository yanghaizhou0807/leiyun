package com.example.admin.leiyun_ic.HomePage;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.R;

import qiu.niorgai.StatusBarCompat;

public class IntegralSuperiorityActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.integral_superiority_acty);
        StatusBarCompat.translucentStatusBar(this);
    }
}
