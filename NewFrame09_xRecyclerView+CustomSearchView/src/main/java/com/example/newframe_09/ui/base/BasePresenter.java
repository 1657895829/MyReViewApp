package com.example.newframe_09.ui.base;

/**
 * 自定义 Presenter 层 ，实现view层的绑定与解绑
 */

public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {
    protected T mView;
    @Override
    public void attchView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        if (mView != null){
            mView = null;
        }
    }
}
