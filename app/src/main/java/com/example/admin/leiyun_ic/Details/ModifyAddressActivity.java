package com.example.admin.leiyun_ic.Details;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.R;

import qiu.niorgai.StatusBarCompat;

public class ModifyAddressActivity extends BaseActivity implements View.OnClickListener {

    private Button new_address_btn;
    private ImageView iv_address;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify_address_acty);
        StatusBarCompat.translucentStatusBar(this);
        new_address_btn = (Button)findViewById(R.id.new_address_btn);
        new_address_btn.setOnClickListener(this);
        iv_address = (ImageView) findViewById(R.id.iv_address);
        iv_address.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.new_address_btn:
            case R.id.iv_address:
                Intent intent = new Intent(ModifyAddressActivity.this, AddAddressActivity.class);
                ModifyAddressActivity.this.startActivity(intent);
                break;
        }

    }
}
