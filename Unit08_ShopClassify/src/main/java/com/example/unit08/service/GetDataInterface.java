package com.example.unit08.service;

import com.example.unit08.bean.ShopBean;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 //	商品分类接口
 //https://www.zhaoapi.cn/product/getProducts?pscid=1
 */
public interface GetDataInterface {
    /**
     * 简单使用Retrofit的get请求接口数据
     * @return
     */
    @GET("/product/getProducts?pscid=1")
    Call<ShopBean> get();
}
