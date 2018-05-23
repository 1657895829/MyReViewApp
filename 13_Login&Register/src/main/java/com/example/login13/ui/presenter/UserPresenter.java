package com.example.login13.ui.presenter;

import com.example.login13.bean.LoginBean;
import com.example.login13.bean.PersonInfoBean;
import com.example.login13.bean.RegBean;
import com.example.login13.net.UserApi;
import com.example.login13.ui.base.BasePresenter;
import com.example.login13.ui.contract.UserContract;
import javax.inject.Inject;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * p层 继承自定义内容
 */

public class UserPresenter extends BasePresenter<UserContract.View> implements UserContract.Presenter {
    private UserApi userApi;

    @Inject
    public UserPresenter(UserApi userApi) {
        this.userApi = userApi;
    }

    //使用RxJava请求网络处理
    @Override
    public void getLoginData(String mobile, String password) {
        userApi.getLogin(mobile, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        mView.loginData(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getRegData(String mobile, String password) {
        userApi.getReg(mobile, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegBean regBean) {
                        mView.regData(regBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getRersonData(int uid) {
        userApi.getPerson(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PersonInfoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PersonInfoBean personInfoBean) {
                        mView.personData(personInfoBean);
                        System.out.println("HttpComponent 个人信息返回：" + personInfoBean.toString());
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
