package com.example.twoshopcart.module;

import com.example.twoshopcart.net.Api;
import com.example.twoshopcart.net.ShopApi;
import com.example.twoshopcart.net.ShopApiService;
import java.util.concurrent.TimeUnit;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dewey
 * 自定义Module，里面的方法用于提供依赖
 */
@Module //提供依赖对象的实例
public class HttpModule {
    @Provides  // 关键字，标明该方法提供依赖对象
    ShopApi providerShopApi(){

        //1. 使用OkHttp请求网络，设置时间值
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();

        //2. 使用Retrofit传入okhttp请求参数体
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BaseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        //3. 最后调用请求接口，使用retrofit处理，返回处理结果
        ShopApiService service = retrofit.create(ShopApiService.class);
        return ShopApi.getShopApi(service);
    }
}