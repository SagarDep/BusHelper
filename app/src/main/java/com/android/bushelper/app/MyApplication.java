package com.android.bushelper.app;

import android.app.Application;

import com.android.bushelper.bean.UserBean;

import org.xutils.x;

public class MyApplication extends Application {

    public static String City = "南京";

    public static UserBean user;

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }

    public static void setCity(String city) {
        City = city;
    }

    public static void setUser(UserBean user) {
        MyApplication.user = user;
    }
}
