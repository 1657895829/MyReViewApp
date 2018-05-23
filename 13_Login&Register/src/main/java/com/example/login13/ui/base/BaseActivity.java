package com.example.login13.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.login13.inter.IBase;

import javax.inject.Inject;

/**
 * Created   by    Dewey
 * 自定义 Activity抽象基类 实现注入方法，实现view层特性
 */
public abstract class BaseActivity<T extends BaseContract.BasePresenter> extends AppCompatActivity implements IBase,BaseContract.BaseView {
    @Inject
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());

        inject();

        //v层绑定p层
        if (mPresenter != null) {
            mPresenter.attchView(this);
        }
    }

    @Override
    public void initView(View view) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑P层
        if (mPresenter != null){
            mPresenter.detachView();
        }
    }
}
