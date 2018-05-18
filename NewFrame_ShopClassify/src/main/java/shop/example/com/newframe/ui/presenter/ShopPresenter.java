package shop.example.com.newframe.ui.presenter;

import javax.inject.Inject;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import shop.example.com.newframe.bean.ShopBean;
import shop.example.com.newframe.net.ShopApi;
import shop.example.com.newframe.ui.base.BasePresenter;
import shop.example.com.newframe.ui.contract.ShopContract;

/**
 * p层 继承自定义内容
 */

public class ShopPresenter extends BasePresenter<ShopContract.View> implements ShopContract.Presenter {
    private ShopApi shopApi;

    @Inject
    public ShopPresenter(ShopApi shopApi){
        this.shopApi = shopApi;
    }

    //使用RxJava请求网络处理
    @Override
    public void getData() {
        shopApi.getShopApi()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ShopBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShopBean bean) {
                        mView.showShop(bean);
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
