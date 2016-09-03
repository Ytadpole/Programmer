package com.ytadpole.demo1.application;

import android.app.Application;

import org.xutils.x;

/**
 * Created by YS on 2016/9/3.
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
