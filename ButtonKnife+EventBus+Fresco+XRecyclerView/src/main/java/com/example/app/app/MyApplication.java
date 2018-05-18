package com.example.app.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 初始化 Fresco 并做配置
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
