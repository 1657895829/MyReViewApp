package com.example.login13.ui.contract;

import com.example.login13.bean.LoginBean;
import com.example.login13.bean.PersonInfoBean;
import com.example.login13.bean.RegBean;
import com.example.login13.ui.base.BaseContract;

/**
 * 定义协议接口
 */

public interface UserContract {
    interface View extends BaseContract.BaseView{
        void loginData(LoginBean loginBean);
        void regData(RegBean regBean);
        void personData(PersonInfoBean personInfoBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void getLoginData(String mobile, String password);
        void getRegData(String mobile, String password);
        void getRersonData(int uid);
    }
}
