package com.example.twoshopcart.net;

import com.example.twoshopcart.bean.ShopBean;
import io.reactivex.Observable;

/**
 * 网络请求，使用Observable封装实现
 */
public class ShopApi {
    private ShopApiService service;
    private static ShopApi shopApi;

    public ShopApi(ShopApiService service) {
        this.service = service;
    }

    public static ShopApi getShopApi(ShopApiService service){
        if (shopApi == null){
            shopApi = new ShopApi(service);
        }
        return shopApi;
    }

    public Observable<ShopBean>  getShopApi(){
        return service.getData();
    }

}
