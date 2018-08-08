package com.huatec.edu.mobileshop.common;

import android.app.Application;
import android.content.Context;

import com.huatec.edu.mobileshop.server.HttpMethods;

/**
 * Created by NTVU on 2018/8/7.
 */

public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        //全局配置Retrofit
        HttpMethods.getInstance();
    }
    public static Context getContext() {
        return mContext;
    }
}
