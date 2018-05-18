package com.example.newframe_09.ui.presenter;

import com.example.newframe_09.bean.NewsBean;
import com.example.newframe_09.net.NewsApi;
import com.example.newframe_09.ui.base.BasePresenter;
import com.example.newframe_09.ui.contract.NewsContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * p层 继承自定义内容
 */

public class NewsPresenter extends BasePresenter<NewsContract.View> implements NewsContract.Presenter {
    private NewsApi shopApi;

    @Inject
    public NewsPresenter(NewsApi shopApi){
        this.shopApi = shopApi;
    }

    //使用RxJava请求网络处理
    @Override
    public void getData() {
        shopApi.getNewsApi()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsBean bean) {
                        mView.NewsShop(bean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
