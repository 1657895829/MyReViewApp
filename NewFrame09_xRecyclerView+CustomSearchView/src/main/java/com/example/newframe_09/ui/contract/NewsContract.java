package com.example.newframe_09.ui.contract;

import com.example.newframe_09.bean.NewsBean;
import com.example.newframe_09.ui.base.BaseContract;

/**
 * 定义协议接口
 */

public interface NewsContract {
    interface View extends BaseContract.BaseView{
        void NewsShop(NewsBean bean);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void getData();
    }
}
