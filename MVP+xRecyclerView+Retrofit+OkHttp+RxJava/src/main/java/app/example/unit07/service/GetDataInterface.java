package app.example.unit07.service;

import app.example.unit07.bean.NewsBean;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 网络接口请求的实体类
 * 接口：APIKEY=‘71e58b5b2f930eaf1f937407acde08fe’
        http://api.tianapi.com/nba/?key=APIKEY&num=10
 */
public interface GetDataInterface {
    /**
     * 简单使用Retrofit的get请求接口数据
     * @return
     */
    @GET("/nba/?key=71e58b5b2f930eaf1f937407acde08fe&num=10")
    Call<NewsBean>  getData();
}
