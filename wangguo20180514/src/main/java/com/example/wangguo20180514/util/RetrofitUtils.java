package com.example.wangguo20180514.util;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;



public class RetrofitUtils {


    private static APIService service  = null ;


    public static APIService getInstance(){
        if(service == null){
            synchronized (RetrofitUtils.class){

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://www.zhaoapi.cn")
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .client(OkHttpUtils.getInstance())
                        .build();
                service = retrofit.create(APIService.class);
            }
        }
        return service;
    }

}
