package com.example.login13.ui.base;

/**
 * Created   by    Dewey
 * 抽取P层基类
 */

public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {

    protected T mView;  //受保护的view层

    @Override
    public void attchView(T view) {
        if (view != null){
            this.mView = view;
        }
    }

    @Override
    public void detachView() {
        if (mView != null){
            mView = null;
        }
    }
}
