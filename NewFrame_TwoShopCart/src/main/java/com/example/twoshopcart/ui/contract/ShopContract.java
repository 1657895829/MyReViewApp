package com.example.twoshopcart.ui.contract;

import com.example.twoshopcart.bean.ShopBean;
import com.example.twoshopcart.ui.base.BaseContract;
/**
 * 定义协议接口
 */

public interface ShopContract {
    interface View extends BaseContract.BaseView{
        void shopData(ShopBean bean);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void getData();
    }
}
