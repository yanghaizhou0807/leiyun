package com.example.admin.leiyun_ic.utils;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.leiyun_ic.R;

public class CallPhoneUtils {
    public static void ShowTelPhone(final Context context, final String strTel) {
        final Dialog mDialog;
        mDialog = new Dialog(context, R.style.Teldialog);
        mDialog.setContentView(R.layout.layout_tel_phone);
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();
        TextView mTextTelPhone = (TextView) mDialog.findViewById(R.id.text_tel_phone);
        mTextTelPhone.setText(strTel);
        TextView mTextTelCancel = (TextView) mDialog.findViewById(R.id.text_tel_cancel);
        mTextTelCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });
        TextView mTextCallPhone = (TextView) mDialog.findViewById(R.id.text_tel_call);
        mTextCallPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
                if (ContextCompat.checkSelfPermission(context,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

                }else {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + strTel));
                    context.startActivity(intent);
                }

                /*Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+strTel));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                context.startActivity(intent);*/
            }
        });
    }

}
