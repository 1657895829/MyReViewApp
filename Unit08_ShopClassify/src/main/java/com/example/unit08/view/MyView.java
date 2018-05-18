package com.example.unit08.view;


import com.example.unit08.bean.ShopBean;

/**
 * view层接口类，请求成功与失败时的方法
 */

public interface MyView {
    public void onSuccess(ShopBean bean);
    public void onFailure(Exception e);
}
