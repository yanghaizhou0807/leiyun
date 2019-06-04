package com.example.admin.leiyun_ic.MyMall;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.Base.BaseApplication;
import com.example.admin.leiyun_ic.Details.AddAddressActivity;
import com.example.admin.leiyun_ic.Details.ModifyAddressActivity;
import com.example.admin.leiyun_ic.R;
import com.example.admin.leiyun_ic.utils.ScreenUtils;

import qiu.niorgai.StatusBarCompat;

public class AccountSettingsActivity extends BaseActivity implements View.OnClickListener {

    private Button address_management_btn,account_security_btn,interest_management_btn,welfare_purchase_btn,feedback_btn;
    private Button logout_btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_setting_acty);
        StatusBarCompat.translucentStatusBar(this);
        initView();
    }

    private void initView() {
        logout_btn = (Button)findViewById(R.id.logout_btn);
        logout_btn.setOnClickListener(this);

        address_management_btn = (Button)findViewById(R.id.address_management_btn);
        address_management_btn.setOnClickListener(this);
        account_security_btn = (Button)findViewById(R.id.account_security_btn);
        account_security_btn.setOnClickListener(this);
        interest_management_btn = (Button)findViewById(R.id.interest_management_btn);
        interest_management_btn.setOnClickListener(this);
        welfare_purchase_btn = (Button)findViewById(R.id.welfare_purchase_btn);
        welfare_purchase_btn.setOnClickListener(this);
        feedback_btn = (Button)findViewById(R.id.feedback_btn);
        feedback_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.address_management_btn:
                Intent intent = new Intent(AccountSettingsActivity.this, ModifyAddressActivity.class);
                AccountSettingsActivity.this.startActivity(intent);
                break;
            case R.id.account_security_btn:
                Intent intents = new Intent(AccountSettingsActivity.this, AccountSecurityActivity.class);
                AccountSettingsActivity.this.startActivity(intents);
                break;
            case R.id.interest_management_btn:
                Intent intenti = new Intent(AccountSettingsActivity.this, InterestManagementActivity.class);
                AccountSettingsActivity.this.startActivity(intenti);
                break;
            case R.id.welfare_purchase_btn:
                Intent intentw = new Intent(AccountSettingsActivity.this, AboutWelfarePurchaseActivity.class);
                AccountSettingsActivity.this.startActivity(intentw);
                break;
            case R.id.feedback_btn:
                Intent intentf = new Intent(AccountSettingsActivity.this, FeedbackActivity.class);
                AccountSettingsActivity.this.startActivity(intentf);
                break;
            case R.id.logout_btn:
                showNoticeDialog();
                break;
        }
    }

    private void showNoticeDialog() {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_dowm_apk_switch, null);
        final Dialog updateDialog = new Dialog(this, R.style.LodingDialog);
        TextView title = view.findViewById(R.id.dailog_my_title);
        TextView content = view.findViewById(R.id.dailog_my_content);
        title.setText("退出程序");
        content.setText("是否要退出程序?\n");
        Button tvComnfirm = view.findViewById(R.id.dailog_my_cancel);//dailog_my_cancel
        tvComnfirm.setText("确定");
        Button tvCancel = view.findViewById(R.id.dailog_my_confirm);
        tvCancel.setText("取消");
        tvComnfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (updateDialog != null && updateDialog.isShowing()) {
                    updateDialog.dismiss();
                    AccountSettingsActivity.this.finish();
                }

            }
        });
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (updateDialog != null && updateDialog.isShowing()) {
                    updateDialog.dismiss();
                }
            }
        });
        updateDialog.setContentView(view);
        updateDialog.setCanceledOnTouchOutside(false);
        updateDialog.setCancelable(false);
        WindowManager m = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        Window window = updateDialog.getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = ScreenUtils.getScreenSize(BaseApplication.getInstance())[0] * 3 / 5;
//        params.height=d.getHeight()*3/10;
        window.setAttributes(params);
        updateDialog.show();
    }

}
