package com.example.login13.inter;

import android.view.View;

/**
 * Created   by    Dewey
 *
 * 注入对象的调用方法
 */
public interface IBase {

    int getContentLayout();  //返回布局内容

    void inject();           //注入的方法

    void initView(View view);//初始化视图
}
