package com.example.unit09.presenter;

import com.example.unit09.base.BasePresenter;
import com.example.unit09.bean.NewsBean;
import com.example.unit09.model.ModelCallBack;
import com.example.unit09.model.MyModel;
import com.example.unit09.view.MyView;

/**
 * Presenter层,继承自定义的泛型Presenter层（持有view层接口），进行view层与model数据的交互
 */
public class MyPresenter extends BasePresenter<MyView> {
    //声明model层
    private MyModel myModel;

    public MyPresenter() {
        this.myModel = new MyModel();
    }

    //获取数据的方法
    public void get(){
        myModel.getData(new ModelCallBack() {
            @Override
            public void onSuccess(NewsBean bean) {
                view.onSuccess(bean);
            }

            @Override
            public void onFailure(Exception e) {
                view.onFailure(e);
            }
        });
    }

    //取消绑定，防止内存泄露
    public void detach(){
        view = null;
    }
}
