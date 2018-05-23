package com.example.login13.net;

import com.example.login13.bean.LoginBean;
import com.example.login13.bean.PersonInfoBean;
import com.example.login13.bean.RegBean;
import io.reactivex.Observable;

/**
 * Created   by    Dewey
 * 网络请求，使用Observable封装实现
 */

public class UserApi {
    private UserApiService service;
    private static UserApi newsApi;

    public UserApi(UserApiService service) {
        this.service = service;
    }

    public static UserApi getDataApi(UserApiService service){
        if (newsApi == null){
            newsApi = new UserApi(service);
        }
        return newsApi;
    }

    public Observable<LoginBean> getLogin(String mobile, String password){
        return service.getLogin(mobile, password);
    }

    public Observable<RegBean> getReg(String mobile, String password){
        return service.getReg(mobile, password);
    }

    public Observable<PersonInfoBean> getPerson(int uid){
        return service.getPerson(uid);
    }
}
