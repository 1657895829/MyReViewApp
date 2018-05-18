package shop.example.com.newframe.net;

import io.reactivex.Observable;
import retrofit2.http.GET;
import shop.example.com.newframe.bean.ShopBean;

/**
 * 网络请求接口类的 拼接部分
 */

public interface ShopApiService {
    @GET("product/getProducts?pscid=1")
    Observable<ShopBean>  getData();
}
