package com.example.admin.leiyun_ic.MyMall;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.R;
import com.example.admin.leiyun_ic.utils.CallPhoneUtils;

import qiu.niorgai.StatusBarCompat;

public class CustomerServiceCenterActivity extends BaseActivity implements View.OnClickListener {

    private ImageView phone_1;
    private String StrTel = "400-123-4567";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.service_center_acty);
        StatusBarCompat.translucentStatusBar(this);
        phone_1= (ImageView)findViewById(R.id.phone_1);
        phone_1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.phone_1:
                CallTelPhone(StrTel);
                break;
        }

    }

    private void CallTelPhone(String phone) {
        //首先判断否获取了权限
        if (ActivityCompat.shouldShowRequestPermissionRationale( CustomerServiceCenterActivity.this,Manifest.permission.CALL_PHONE)) {
            //让用户手动授权
            Toast.makeText(context, "请授权！", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            Uri uri = Uri.fromParts("package", "\"com.example.admin.leiyun_ic\"", null);
            intent.setData(uri);
            context.startActivity(intent);
        }else{
            ActivityCompat.requestPermissions( CustomerServiceCenterActivity.this,new String[]{ Manifest.permission.CALL_PHONE },1);
        }

        CallPhoneUtils.ShowTelPhone(this, phone);
    }

}
