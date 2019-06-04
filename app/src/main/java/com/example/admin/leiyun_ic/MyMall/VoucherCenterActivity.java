package com.example.admin.leiyun_ic.MyMall;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.R;

import qiu.niorgai.StatusBarCompat;

public class VoucherCenterActivity extends BaseActivity implements View.OnClickListener {
    private Button pay_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.voucher_center_acty);
        StatusBarCompat.translucentStatusBar(this);
        pay_btn = (Button)findViewById(R.id.pay_btn);
        pay_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pay_btn:
                Intent intent = new Intent(VoucherCenterActivity.this, SuccessfulPaymentActivity.class);
                VoucherCenterActivity.this.startActivity(intent);
                break;
        }
    }
}
