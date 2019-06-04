package com.example.admin.leiyun_ic.Base;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.leiyun_ic.R;
import com.example.admin.leiyun_ic.utils.AppGlobal;
import com.example.admin.leiyun_ic.utils.GsonQuick;
import com.example.admin.leiyun_ic.utils.NetworkUtils;
import com.heigo.http.okhttp.OkHttpUtils;
import com.heigo.http.okhttp.builder.PostFormBuilder;
import com.heigo.http.okhttp.callback.Callback;
import com.heigo.http.okhttp.callback.StringCallback;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.util.Map;

/**
 * BaseActivity
 * /**
 * ************************************************************************
 * **                              _oo0oo_                               **
 * **                             o8888888o                              **
 * **                             88" . "88                              **
 * **                             (| -_- |)                              **
 * **                             0\  =  /0                              **
 * **                           ___/'---'\___                            **
 * **                        .' \\\|     |// '.                          **
 * **                       / \\\|||  :  |||// \\                        **
 * **                      / _ ||||| -:- |||||- \\                       **
 * **                      | |  \\\\  -  /// |   |                       **
 * **                      | \_|  ''\---/''  |_/ |                       **
 * **                      \  .-\__  '-'  __/-.  /                       **
 * **                    ___'. .'  /--.--\  '. .'___                     **
 * **                 ."" '<  '.___\_<|>_/___.' >'  "".                  **
 * **                | | : '-  \'.;'\ _ /';.'/ - ' : | |                 **
 * **                \  \ '_.   \_ __\ /__ _/   .-' /  /                 **
 * **            ====='-.____'.___ \_____/___.-'____.-'=====             **
 * **                              '=---='                               **
 * ************************************************************************
 * **                        佛祖保佑      镇类之宝                        **
 * ************************************************************************
 * author yang
 */

public class BaseActivity extends AppCompatActivity {

    private static final int PERMISSIONS_REQUEST = 1;

    protected Context context = this;
    protected String TAG = this.getClass().getSimpleName();
    private static final String NOTIFICATION_ID = "open";
    private BaseApplication myApplication;
    private Toast toast = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public void sendOkhttpPost(String url, Map<String, String> params, Callback<String> back) {
        if (isNetWork()) {
            PostFormBuilder posetRequset = OkHttpUtils.post();
            posetRequset.url(url);
            if (params != null) {
                posetRequset.addParams("req", GsonQuick.paramsToJson(params));
                Logger.d("params:" + GsonQuick.paramsToJson(params));
            }
            posetRequset.tag(this).build().execute(back);
        } else {
            noNetWork();
        }
    }

    public boolean isNetWork() {
        if (!NetworkUtils.checkNetState(this)) {
            show(AppGlobal.CURRENT_NETWORK_IS_NOT_USEFUL);
            return false;
        }
        return true;
    }

    public void noNetWork() {

    }

    /**
     * 显示消息
     *
     * @param msg
     */
    public void show(String msg) {
        if (toast == null) {
            toast = Toast.makeText(BaseApplication.getInstance(), msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }


    public void post(Map<String, String> params, String url, StringCallback callback) {
        PostFormBuilder posetRequset = OkHttpUtils.post();
        posetRequset.url(url);
        if (params != null) {
            posetRequset.params(params);
            Logger.d("params:" + GsonQuick.paramsToJson(params));
        }
        posetRequset.tag(this).build().execute(callback);
    }

    public void postImage(PostFormBuilder posetRequset, String url, StringCallback callback, File file, String type) {
        String fileName = file.getAbsolutePath().
                substring(file.getAbsolutePath().lastIndexOf("/") + 1,
                        file.getAbsolutePath().length());
        // System.out.println(fileName);
        if (AppGlobal.IMAGE.equals(type)) {
            posetRequset.addFile("profile_img", fileName, file);
        } else if (AppGlobal.VIDEO.equals(type)) {
            posetRequset.addFile("myVideo", fileName, file);
        } else {

        }
        posetRequset.url(url);
        posetRequset.build().execute(callback);
    }

    /**
     * 文件下载
     *
     * @param url
     * @param dir
     */
/*    public void downLoadFile(String url, String dir) {

        //TODO:跳转到下载列表 显示下载进度

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    Toast.makeText(this, "下载需要文件存储的权限!", Toast.LENGTH_SHORT).show();
                } else {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            PERMISSIONS_REQUEST);
                }
            } else {
                Intent intent = new Intent();
                intent.setClass(this, DownloadManageActivity.class);
                intent.putExtra("url", url);
                this.startActivity(intent);
            }
        } else {
            Intent intent = new Intent();
            intent.setClass(this, DownloadManageActivity.class);
            intent.putExtra("url", url);
            this.startActivity(intent);
        }




//        Log.e("URL>>>>", url);
//        ProgressDialogManager.getInstance().showWait(this, "正在加载...");
//        String encodeFileName = url.substring(url.lastIndexOf("/") + 1, url.length());
//        String fileName = URLDecoder.decode(encodeFileName);
//        Log.i("info", fileName + "homeFlag------------->");


//        OkHttpUtils.get().url(url).build().execute(new FileCallBack(dir,fileName) {
//            @Override
//            public void onError(Call call, Exception e, int i) {
//                ProgressDialogManager.getInstance().dissmiss();
//                Toast.makeText(BaseActivity.this,"文件下载失败，请重新尝试",Toast.LENGTH_LONG).show();
//                Log.e("error", e.getMessage());
//            }
//            @Override
//            public void onResponse(File file, int i) {
//                ProgressDialogManager.getInstance().dissmiss();
//                Log.e("success",file.getAbsolutePath());
//                DialogUtils.showToast(BaseActivity.this, "文件已下载至手机ganxi目录");
//
//                //TODO:下载完成后弹出通知栏
////                showNotification(file);
//
//            }
//            @Override
//            public void inProgress(float progress, long total, int id) {
//
//            }
//        });
    }*/

   /* private void showNotification(File file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String type = getMIMEType(file);
        Uri uri = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            uri = FileProvider.getUriForFile(BaseActivity.this, getPackageName() + ".fileprovider", file);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(uri, "application/vnd.android.package-archive");
        } else {
            uri = Uri.fromFile(file);
        }

        intent.setDataAndType(uri, type);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        NotificationManager manager = ((NotificationManager) getSystemService(NOTIFICATION_SERVICE));
        Notification notification = new NotificationCompat.
                Builder(this, NOTIFICATION_ID)
                .setContentTitle("文件下载通知手机ganxi目录")
                .setContentText("文件" + file.getName() + "已经下载完成")
                .setSmallIcon(R.mipmap.tongzhi)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();
        manager.notify(1, notification);


    }*/



    /*public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            DialogUtils.showDialog(this,myApplication);

        }
        return super.onKeyDown(keyCode, event);
    }*/

    public void showToast(String msg) {
        View dialogView = LayoutInflater.from(BaseActivity.this).inflate(R.layout.dialog_swipe, null);
        TextView swipePromotTv = (TextView) dialogView.findViewById(R.id.swipe_promot_tv);
        swipePromotTv.setText(msg);
        Toast toast = new Toast(BaseActivity.this);
        toast.setView(dialogView);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }


    public static boolean checkNetStates(Context context) {
        boolean flag = false;
        ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo.State mobile = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
                .getState();
        NetworkInfo.State wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .getState();
        // 如果3G、wifi、2G等网络状态是连接的，则退出，否则显示提示信息进入网络设置界面
        if (mobile == NetworkInfo.State.CONNECTED || mobile == NetworkInfo.State.CONNECTING) {
            return flag = true;
        }

        if (wifi == NetworkInfo.State.CONNECTED || wifi == NetworkInfo.State.CONNECTING) {
            return flag = true;
        }
        return flag;

    }
    //如果没有网络，引领用户进入设置界面去设置网络

    public static void setNetStates(final Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle("网络状态");
        builder.setMessage("当前网络不可用，是否设置网络？");
        builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 如果没有网络连接，则进入网络设置界面
                context.startActivity(new Intent(
                        Settings.ACTION_WIRELESS_SETTINGS));
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.create();
        builder.show();
    }
}
