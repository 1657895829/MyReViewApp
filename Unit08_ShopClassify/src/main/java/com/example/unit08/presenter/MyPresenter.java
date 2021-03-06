package com.example.unit08.presenter;
import com.example.unit08.bean.ShopBean;
import com.example.unit08.model.MyModel;
import com.example.unit08.view.MyView;

/**
 * presenter层，进行view与model层数据的交互
 */
public class MyPresenter {
    private MyView myView;
    private MyModel myModel;

    public MyPresenter(MyView myView) {
        this.myView = myView;
        myModel = new MyModel();
    }

    /**
     * 简单使用retrofit的get请求，不传递参数
     */
    public void getData() {
        myModel.getData(new MyView() {
            @Override
            public void onSuccess(ShopBean bean) {
                //数据交互时，为防止内存泄漏，设置view层数据为空
                if (myView != null){
                    myView.onSuccess(bean);
                }
            }

            @Override
            public void onFailure(Exception e) {
                //数据交互时，为防止内存泄露，设置view层数据为空
                if (myView != null){
                    myView.onFailure(new Exception(""));
                }
            }
        });
    }

    //解绑p层，防止内存泄露
    public void detach(){
        this.myView = null;
    }
}
