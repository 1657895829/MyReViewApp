package com.example.twoshopcart.net;

import com.example.twoshopcart.bean.ShopBean;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 网络请求接口类的 拼接部分
 */

public interface ShopApiService {
    @GET("product/getCarts?uid=97")
    Observable<ShopBean> getData();
}
