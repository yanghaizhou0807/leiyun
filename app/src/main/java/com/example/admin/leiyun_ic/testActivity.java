package com.example.admin.leiyun_ic;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.admin.leiyun_ic.Base.BaseUrl;
import com.example.admin.leiyun_ic.utils.AppGlobal;
import com.example.admin.leiyun_ic.utils.MessageEvent;
import com.heigo.http.okhttp.OkHttpUtils;
import com.heigo.http.okhttp.builder.PostFormBuilder;
import com.heigo.http.okhttp.callback.StringCallback;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import de.greenrobot.event.EventBus;
import okhttp3.Call;

public class testActivity extends Activity {
    private Button buttonTest;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_acty);
        initView();
    }

    private void initView() {
        /*buttonTest= (Button)findViewById(R.id.buttonTest);
        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MessageEvent("消息类容"));
                finish();
            }
        });*/
    }
    /**
     * 视频文字混传
     *//*
    private void  postVideo(){
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
    }
    *//**
     * 图片文字混传
     *//*
    private void postImage(){
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
    }
    *//**
     * 纯文本上传
     *//*
    private void postText(){
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
}
