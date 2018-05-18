package com.example.newframe_09.net;

import com.example.newframe_09.bean.NewsBean;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 网络请求接口类的 拼接部分
 */

public interface NewsApiService {
    @GET("apple/?key=71e58b5b2f930eaf1f937407acde08fe&num=10")
    Observable<NewsBean>  getData();
}
