package com.example.admin.leiyun_ic.Details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.R;

import qiu.niorgai.StatusBarCompat;

public class CashierActivity extends BaseActivity implements View.OnClickListener {

    private Button confirm_payment_btn;
    private BottomSheetDialog dialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cashier_acty);
        StatusBarCompat.translucentStatusBar(this);
        confirm_payment_btn=(Button)findViewById(R.id.confirm_payment_btn);
        confirm_payment_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.confirm_payment_btn:
                mima();
                break;
            case R.id.about_back_btn:

                break;
        }
    }

    private void mima() {
        dialog = new BottomSheetDialog(CashierActivity.this);
        View bottomView = LayoutInflater.from(CashierActivity.this).inflate(R.layout.payment_window_details, null);
        TextView close_login_btn = bottomView.findViewById(R.id.about_back_btn);//
        /*TextView tv_choose_video = bottomView.findViewById(R.id.tv_choose_video);//
        TextView tv_choose_cancel = bottomView.findViewById(R.id.tv_cancel);
        TextView tv_take_photo = bottomView.findViewById(R.id.tv_take_photo);//*/

        close_login_btn.setOnClickListener(this);
//        tv_choose_video.setOnClickListener(this);
//        tv_choose_cancel.setOnClickListener(this);
//        tv_take_photo.setOnClickListener(this);


        dialog.setContentView(bottomView);
        dialog.show();

    }

}
