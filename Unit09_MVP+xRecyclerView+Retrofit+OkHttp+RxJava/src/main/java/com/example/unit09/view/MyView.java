package com.example.unit09.view;

import com.example.unit09.bean.NewsBean;

/**
 * view层
 */

public interface MyView {
    public void onSuccess(NewsBean bean);
    public void onFailure(Exception e);
}
