package com.example.admin.leiyun_ic.Details;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.R;

import qiu.niorgai.StatusBarCompat;

public class OrderDetailsActivity extends BaseActivity implements View.OnClickListener {

    private Button place_order;
    private LinearLayout modify_address_llyt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_details_acty);
        StatusBarCompat.translucentStatusBar(this);
        place_order = (Button)findViewById(R.id.place_order);
        place_order.setOnClickListener(this);
        modify_address_llyt =(LinearLayout)findViewById(R.id.modify_address_llyt);
        modify_address_llyt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.place_order:

                Intent intent = new Intent(OrderDetailsActivity.this, CashierActivity.class);
                OrderDetailsActivity.this.startActivity(intent);

                break;

            case R.id.modify_address_llyt:
                Intent intentmod = new Intent(OrderDetailsActivity.this, ModifyAddressActivity.class);
                OrderDetailsActivity.this.startActivity(intentmod);

                break;

        }
    }
}
