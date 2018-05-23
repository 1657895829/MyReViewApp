package com.example.login13.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

//注册
public class RegActivity extends BaseActivity<UserPresenter> implements UserContract.View {
    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.regTel)
    EditText regTel;
    @BindView(R.id.regPwd)
    EditText regPwd;
    @BindView(R.id.regNow)
    Button regNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_reg;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    @Override
    public void regData(RegBean regBean) {
        Toast.makeText(this, "注册结果：      " + regBean.getMsg(), Toast.LENGTH_SHORT).show();

        if (regBean.getMsg().equals("注册成功")) {
            try {
                Thread.sleep(2000);
                Toast.makeText(this, "即将跳转到登录页面", Toast.LENGTH_SHORT).show();
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @OnClick({R.id.back, R.id.regNow})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                //点击返回按钮，返回到登录页面
                finish();
                break;

            case R.id.regNow: //注册按钮

                if (!TextUtils.isEmpty(regTel.getText().toString()) && !TextUtils.isEmpty(regPwd.getText().toString())) {

                    if (regTel.getText().toString().length() < 6) {
                        Toast.makeText(this, "密码长度不能小于 6 位", Toast.LENGTH_SHORT).show();
                    } else {
                        // mvp请求注册的接口
                        mPresenter.getRegData(regTel.getText().toString(), regPwd.getText().toString());
                    }

                } else {
                    Toast.makeText(this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                }
                break;

            default:
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
    public void loginData(LoginBean loginBean) {

    }

    @Override
    public void personData(PersonInfoBean personInfoBean) {

    }

}
