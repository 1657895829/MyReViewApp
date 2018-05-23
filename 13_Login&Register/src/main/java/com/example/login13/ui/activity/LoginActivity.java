package com.example.login13.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.login13.R;
import com.example.login13.bean.LoginBean;
import com.example.login13.bean.PersonInfoBean;
import com.example.login13.bean.RegBean;
import com.example.login13.component.DaggerHttpComponent;
import com.example.login13.module.HttpModule;
import com.example.login13.ui.base.BaseActivity;
import com.example.login13.ui.contract.UserContract;
import com.example.login13.ui.presenter.UserPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//登录
public class LoginActivity extends BaseActivity<UserPresenter> implements UserContract.View {
    @BindView(R.id.tel)
    EditText tel;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.reg)
    Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    @Override
    public void loginData(LoginBean loginBean) {
        Toast.makeText(this, "登录结果：  " + loginBean.getMsg(), Toast.LENGTH_SHORT).show();

        if(loginBean.getMsg().equals("登录成功")){
            try {
                Thread.sleep(1000);
                Intent intent = new Intent(LoginActivity.this, PersonInfoActivity.class);
                startActivity(intent);
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @OnClick({R.id.btn, R.id.reg})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;

            case R.id.btn:
                if (!TextUtils.isEmpty(tel.getText().toString()) && !TextUtils.isEmpty(pwd.getText().toString())) {
                    //如果都不为空,请求接口
                    mPresenter.getLoginData(tel.getText().toString(), pwd.getText().toString());
                } else {
                    Toast.makeText(this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.reg:      //注册页
                Intent intent = new Intent(LoginActivity.this, RegActivity.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void regData(RegBean regBean) {

    }

    @Override
    public void personData(PersonInfoBean personInfoBean) {

    }
}
