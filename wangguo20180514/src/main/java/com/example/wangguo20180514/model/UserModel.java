package com.example.wangguo20180514.model;

import com.example.wangguo20180514.bean.User;
import com.example.wangguo20180514.util.APIFactory;
import com.example.wangguo20180514.util.AbstractObserver;

/**
 * Created by lenovo on 2018/5/14.
 */

public class UserModel {
    public void success(final UserCallback callback){
        APIFactory.getInstance().get("quarter/getJokes?source=android&appVersion=100&page=1", new AbstractObserver<User>() {
            @Override
            public void onSuccess(User user) {
                callback.success(user);
            }

            @Override
            public void onFailure(int code) {

            }
        });
    }
}
