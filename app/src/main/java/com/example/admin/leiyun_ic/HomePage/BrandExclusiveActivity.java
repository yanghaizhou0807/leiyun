package com.example.admin.leiyun_ic.HomePage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.R;

import qiu.niorgai.StatusBarCompat;

public class BrandExclusiveActivity extends BaseActivity implements View.OnClickListener {

    private TextView charge_iv;
    private Button back_btn,search_btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brand_exclusive_acty);
        StatusBarCompat.translucentStatusBar(this);
        initView();
    }

    private void initView() {
        charge_iv =(TextView)findViewById(R.id.charge_iv);
        charge_iv.setText("品牌专供");
        back_btn = (Button)findViewById(R.id.back_btn);
        back_btn.setOnClickListener(this);
        search_btn = (Button)findViewById(R.id.search_btn);
        search_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
