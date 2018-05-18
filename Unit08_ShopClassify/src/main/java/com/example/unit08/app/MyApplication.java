package com.example.unit08.app;

import android.app.Application;
import com.example.unit08.service.GetDataInterface;
import com.facebook.drawee.backends.pipeline.Fresco;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 用于全局配置初始化异步加载类
 */
public class MyApplication extends Application {
    //设置公共变量
    public static GetDataInterface request;

    @Override
    public void onCreate() {
        super.onCreate();
        //1.  用于全局配置初始化Fresco 图片加载
        Fresco.initialize(this);

        //2.  用于全局配置初始化Retrofit 网络请求
            //构建Retrofit类，初始化参数
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.zhaoapi.cn")
                    .addConverterFactory(GsonConverterFactory.create())

                    //将请求对象转化为被观察者模式    Observerable
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            //创建网络请求接口实例
            request = retrofit.create(GetDataInterface.class);

    }
}
