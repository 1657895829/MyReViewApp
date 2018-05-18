package shop.example.com.newframe.net;

import io.reactivex.Observable;
import shop.example.com.newframe.bean.ShopBean;

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
