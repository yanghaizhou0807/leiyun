package com.example.admin.leiyun_ic.MyMall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.R;

import qiu.niorgai.StatusBarCompat;

public class SuccessfulPaymentActivity extends BaseActivity implements View.OnClickListener {

    private TextView titleView,voucherCenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.successful_payment_acty);
        StatusBarCompat.translucentStatusBar(this);
        titleView = (TextView) findViewById(R.id.head_title);
        titleView.setText("支付成功");
    }

    @Override
    public void onClick(View v) {

    }
}
