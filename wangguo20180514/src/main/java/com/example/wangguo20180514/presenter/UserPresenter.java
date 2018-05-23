package com.example.wangguo20180514.presenter;

import com.example.wangguo20180514.bean.User;
import com.example.wangguo20180514.model.UserCallback;
import com.example.wangguo20180514.model.UserModel;
import com.example.wangguo20180514.view.UserView;

/**
 * Created by lenovo on 2018/5/14.
 */

public class UserPresenter {
    private UserView view;
    private UserModel model;

    public UserPresenter(UserView view) {
        this.view = view;
        model=new UserModel();
    }
    public void attach(){
        model.success(new UserCallback() {
            @Override
            public void success(User user) {
                view.success(user);
            }
        });
    }
    public void detach(){
        view=null;
    }
}
