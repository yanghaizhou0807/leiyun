package com.example.admin.leiyun_ic.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkUtils {

    public static boolean checkNetState(Context context) {
        boolean netstate = false;
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                int length= info.length;
                for (int i = 0; i <length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        netstate = true;
                        break;
                    }
                }
            }
        }
        return netstate;
    }

    public static  boolean isNetWork(Context context) {
        if (!NetworkUtils.checkNetState(context)) {
            Toast.makeText(context, AppGlobal.CURRENT_NETWORK_IS_NOT_USEFUL, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
