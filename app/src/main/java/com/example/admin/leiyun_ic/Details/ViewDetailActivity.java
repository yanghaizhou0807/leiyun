package com.example.admin.leiyun_ic.Details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.R;

import qiu.niorgai.StatusBarCompat;

public class ViewDetailActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_details_acty);
        StatusBarCompat.translucentStatusBar(this);
    }

    @Override
    public void onClick(View v) {

    }
}
