package com.example.admin.leiyun_ic;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;

import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.Base.BaseApplication;
import com.example.admin.leiyun_ic.Base.BaseUrl;
import com.example.admin.leiyun_ic.Bean.NavigationBean;
import com.example.admin.leiyun_ic.Bean.NewHomeEntityBean;
import com.example.admin.leiyun_ic.utils.DeviceUtil;
import com.example.admin.leiyun_ic.utils.GsonQuick;
import com.heigo.http.okhttp.OkHttpUtils;
import com.heigo.http.okhttp.builder.GetBuilder;
import com.heigo.http.okhttp.builder.PostFormBuilder;
import com.heigo.http.okhttp.callback.StringCallback;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;

public class NavigationActivity extends BaseActivity {
    private static final int SPLASH_DISPLAY_LENGHT = 2000;
    private ProgressDialog pd;
    private Button btnClick;
    private String deviceId,user_token,device_id;
    private NavigationBean navigationBean;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.acty_navigation);
        /*btnClick=findViewById(R.id.btn_click);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="http://39.104.169.143/a/knowledge/mknowledge/mdocDownload?docUrl=/userfiles/1/files/knowledge/mknowledge/2018/04/%E6%96%87%E6%A1%A31.doc";
                downLoadFile(url, FileUtil.initPath("downloadFile"));//文件下载

            }
        });*/
        deviceId = DeviceUtil.getDeviceId(context);
        Logger.d("deviceId--->>:" + deviceId);

        startUpInterface();
        toHomePager();
    }

    private void startUpInterface() {
        GetBuilder builder = OkHttpUtils.get();
        builder.addParams("device_id", deviceId);
        builder.url(BaseUrl.startUp).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int i) {
                Logger.e("error--->>:" + e.getMessage());
            }

            @Override
            public void onResponse(String s, int i) {
                //   ProgressDialogManager.getInstance().dissmiss();
                Logger.d("response-22-->>:" + s);
                if (!"".equals(s)) {
                    navigationBean = GsonQuick.toObject(s, NavigationBean.class);
                    if("操作成功".equals(navigationBean.getMsg())){
                        BaseApplication.getInstance().setNavigationBean(navigationBean);
                        device_id = navigationBean.getData().getDevice_id();
                        user_token = navigationBean.getData().getUser_token();
                        Logger.d("response--->>:" + device_id);
                        Logger.d("response--->>:" + user_token);
                        toHomePager();
                    }
                }
            }
        });
    }
    /**
     * 视频文字混传
     */
    /*private void  postVideo(){
        PostFormBuilder posetRequset = OkHttpUtils.post();
        posetRequset.addParams("user_id","939e52ba911e4bc4bcff4259bc0961a6");
        posetRequset.addParams("content","asdfasdf");
        posetRequset.addParams("likeNum","0");
        posetRequset.addParams("position","afgg");
        File file=new File(Environment.getExternalStorageDirectory(),"11.mp4");
        if(!file.exists()){
            return;
        }
        Log.i("info", "=========="+file);
        postImage(posetRequset, BaseUrl.videoUrl, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int i) {
                Log.e("error",e.getMessage());
            }
            @Override
            public void onResponse(String s, int i) {
                Log.d("success",s);
            }
        },file, AppGlobal.VIDEO);
    }*/
    /**
     * 图片文字混传
     */
    /*private void postImage(){
        PostFormBuilder posetRequset = OkHttpUtils.post();
        posetRequset.addParams("birthday","1990-02-03");
        posetRequset.addParams("nickname","张三");
        posetRequset.addParams("password","123456");
        posetRequset.addParams("username","zhangsan");
        posetRequset.addParams("createDate","2017-12-12");
        posetRequset.addParams("email","1726664097@qq.com");
        posetRequset.addParams("home","甘肃省灵台ixan");
        posetRequset.addParams("id","100023");
        posetRequset.addParams("phone","13552265070");
        posetRequset.addParams("remarks","王麻子");
        posetRequset.addParams("sex","男");
        posetRequset.addParams("updateDate","2019-12-12");
        File file=new File(Environment.getExternalStorageDirectory(),"1.jpg");
        if(!file.exists()){
            return;
        }
        Log.i("info", "=========="+file);
        postImage(posetRequset, BaseUrl.videoUrl, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int i) {
                Log.e("error",e.getMessage());
            }
            @Override
            public void onResponse(String s, int i) {
                Log.d("success",s);
            }
        },file, AppGlobal.VIDEO);
    }*/
    /**
     * 纯文本上传
     */
    /*private void postText(){
        Map<String,String> map=new HashMap<>();
        map.put("username","1001");
        map.put("password","123456");
        post(map,BaseUrl.UserUrl.USERLOGIN, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int i) {
                Log.e("error",e.getMessage());
            }
            @Override
            public void onResponse(String s, int i) {
                Log.d("success",s);
            }
        });
    }*/


    protected void onResume() {
        super.onResume();
    }
    private void toHomePager() {
        /**
         * 使用handler来处理
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(pd!=null && pd.isShowing()){
                    pd.dismiss();
                }
                Intent mainIntent = new Intent(NavigationActivity.this, MainActivity.class);
                mainIntent.putExtra("homeflag", "homeflag");
                NavigationActivity.this.startActivity(mainIntent);
                overridePendingTransition(R.anim.enter_righttoleft, R.anim.out_righttoleft);
                //overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
                NavigationActivity.this.finish();
            }

        }, SPLASH_DISPLAY_LENGHT);

    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        if(pd!=null && pd.isShowing()){
            pd.dismiss();
        }
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        if(pd!=null && pd.isShowing()){
            pd.dismiss();
        }
    }
}
