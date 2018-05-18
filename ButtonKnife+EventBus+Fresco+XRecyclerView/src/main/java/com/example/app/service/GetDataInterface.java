package com.example.app.service;

import com.example.app.bean.WeiXinBean;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 创建 用于描述网络请求的接口
 * 采用 注解 描述网络请求参数
 */

public interface GetDataInterface {
    /**
     * 注解里传入 网络请求 的部分URL地址
     * Retrofit把网络请求的URL分成了两部分：一部分放在Retrofit对象里，另一部分放在网络请求接口里
     * 如果接口里的url是一个完整的网址，那么放在Retrofit对象里的URL可以忽略
     * getCall()是接受网络请求数据的方法
     */
    @GET("wxnew/?key=18e883dd6b316eb1d97fd86338abbf06&num=10")
    Call<WeiXinBean>  getCall();
}
