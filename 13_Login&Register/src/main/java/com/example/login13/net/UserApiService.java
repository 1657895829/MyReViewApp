package com.example.login13.net;

import com.example.login13.bean.LoginBean;
import com.example.login13.bean.PersonInfoBean;
import com.example.login13.bean.RegBean;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created   by    Dewey
 * 网络请求接口类的 拼接部分
 */

public interface UserApiService {
    //登录  http://120.27.23.105/user/login?mobile=18631090582&password=888888
    @FormUrlEncoded
    @POST("user/login")
    Observable<LoginBean> getLogin(@Field("mobile") String mobile,
                                   @Field("password") String password);

    //注册  http://120.27.23.105/user/reg?mobile=18631090582&password=888888
    @FormUrlEncoded
    @POST("user/reg")
    Observable<RegBean> getReg(@Field("mobile") String mobile,
                               @Field("password") String password);

    //个人中心接口：
    //http://120.27.23.105/user/getUserInfo?uid=100
    @GET("user/getUserInfo")
    Observable<PersonInfoBean> getPerson(@Field("uid") int uid);
}
