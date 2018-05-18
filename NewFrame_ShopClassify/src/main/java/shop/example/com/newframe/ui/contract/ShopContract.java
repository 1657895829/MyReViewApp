package shop.example.com.newframe.ui.contract;

import shop.example.com.newframe.bean.ShopBean;
import shop.example.com.newframe.ui.base.BaseContract;

/**
 * 定义协议接口
 */

public interface ShopContract {
    interface View extends BaseContract.BaseView{
        void showShop(ShopBean bean);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void getData();
    }
}
