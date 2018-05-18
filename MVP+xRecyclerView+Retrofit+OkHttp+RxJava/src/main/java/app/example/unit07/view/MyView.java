package app.example.unit07.view;

import app.example.unit07.bean.NewsBean;

/**
 * view层接口类，请求成功与失败时的方法
 */

public interface MyView {
    public void onSuccess(NewsBean bean);
    public void onFailure(Exception e);
}
