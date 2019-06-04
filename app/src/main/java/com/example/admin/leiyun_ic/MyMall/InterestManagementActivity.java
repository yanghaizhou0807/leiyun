package com.example.admin.leiyun_ic.MyMall;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.R;

import qiu.niorgai.StatusBarCompat;

public class InterestManagementActivity extends BaseActivity implements View.OnClickListener {

    private Button interest_btn_1;
    private int a =1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.interest_management_acty);
        StatusBarCompat.translucentStatusBar(this);
        initView();
    }

    private void initView() {
        interest_btn_1 = (Button)findViewById(R.id.interest_btn_1);
        interest_btn_1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.interest_btn_1:
                if(1==a) {
                    interest_btn_1.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.yellowd));
                    a=2;
                }else if(2==a){
                    interest_btn_1.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.textcolor_selector));
                    a=1;
                }
                break;
        }

    }
}
