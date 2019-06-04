package com.example.admin.leiyun_ic.Base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.example.admin.leiyun_ic.Bean.NavigationBean;
import com.example.admin.leiyun_ic.Bean.UserLoginBean;
import com.heigo.http.okhttp.log.LoggerInterceptor;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;

public class BaseApplication extends Application {
    private static BaseApplication mContext;
    private UserLoginBean userVO;
    private NavigationBean navigationBean;

    public NavigationBean getNavigationBean() {
        return navigationBean;
    }

    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }

    /** 屏幕宽度 */
    public int mScreenWidth;
    /** 屏幕密度 */
    public float mDensity;
    /** 屏幕高度 */
    public int mScreenHeight;
    /** 状态栏高度 */
    public int statusBarHeight;
   // private PathManager pathManager=null;
    /**
     * 全局使用的SharedPreferences
     */
    private static SharedPreferences mSpInfo;

    public UserLoginBean getUserVO() {
        return userVO;
    }

    public void setUserVO(UserLoginBean userVO) {
        this.userVO = userVO;
    }

    public static BaseApplication getInstance() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //setTypeface();
        mContext=this;

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .addInterceptor(new LoggerInterceptor("LeiYun"))
                .hostnameVerifier(new HostnameVerifier()
                {
                    @Override
                    public boolean verify(String hostname, SSLSession session)
                    {
                        return true;
                    }
                }).build();
        Logger.addLogAdapter(new AndroidLogAdapter());

    }



    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
      //  MultiDex.install(this);
    }
    /**
     * 通过反射方法设置app全局字体
     */
    public void setTypeface(){
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/fangzhengzhunyuan.ttf");
        try
        {
            Field field = Typeface.class.getDeclaredField("SERIF");
            field.setAccessible(true);
            field.set(null, typeFace);
        }
        catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 得到保存的值
     *
     * @param key
     * @return
     */
    public static String getSpInfo(String key) {
        return mSpInfo.getString(key, "");
    }

    // 初始化屏幕尺寸
    public void initScreenSize() {
        WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        mDensity = outMetrics.density;
        mScreenWidth = outMetrics.widthPixels < outMetrics.heightPixels ? outMetrics.widthPixels : outMetrics
                .heightPixels;
        mScreenHeight = outMetrics.widthPixels < outMetrics.heightPixels ? outMetrics.heightPixels : outMetrics
                .widthPixels;

        //获取status_bar_height资源的ID
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight = getResources().getDimensionPixelSize(resourceId);
        }
    }
}
