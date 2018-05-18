package com.example.unit09.model;


import com.example.unit09.bean.NewsBean;

/**
 * model层接口类
 */
public interface ModelCallBack {
    public void onSuccess(NewsBean bean);
    public void onFailure(Exception e);
}
