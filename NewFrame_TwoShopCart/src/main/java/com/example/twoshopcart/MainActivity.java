package com.example.twoshopcart;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.example.twoshopcart.bean.ShopBean;
import com.example.twoshopcart.component.DaggerHttpComponent;
import com.example.twoshopcart.module.HttpModule;
import com.example.twoshopcart.ui.adapter.ShopAdapter;
import com.example.twoshopcart.ui.base.BaseActivity;
import com.example.twoshopcart.ui.contract.ShopContract;
import com.example.twoshopcart.ui.presenter.ShopPresenter;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//新框架Dagger 结合MVP 展示网络二级列表购物车数据
public class MainActivity extends BaseActivity<ShopPresenter> implements ShopContract.View {
    @BindView(R.id.third_recyclerview)
    RecyclerView thirdRecyclerview;
    @BindView(R.id.third_allselect)
    CheckBox checkBoxAll;
    @BindView(R.id.third_totalprice)
    TextView thirdTotalprice;
    private ShopAdapter adapter;
    private List<ShopBean.DataBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        //调用p层执行方法
        mPresenter.getData();

        initView();     //设置RecyclerView布局内容
    }

    private void initView() {
        adapter = new ShopAdapter(MainActivity.this);
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);

        thirdRecyclerview.setLayoutManager(manager);
        thirdRecyclerview.setAdapter(adapter);

        adapter.setListener(new ShopAdapter.UpdateUiListener() {
            @Override
            public void setTotal(String total, String num, boolean allCheck) {
                checkBoxAll.setChecked(allCheck);
                thirdTotalprice.setText("￥ " + total);
            }
        });
        adapter.setListener(new ShopAdapter.DeleteUiListener() {
            @Override
            public void delete(int position, View view, String num, boolean allCheck) {
                data.get(position).getList().remove(position);
            }
        });
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
    public void shopData(ShopBean bean) {
        data = bean.getData();
        adapter.add(bean);
    }

    @OnClick({R.id.third_submit, R.id.third_allselect})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.third_submit:
                Toast.makeText(MainActivity.this, "您需支付金额：" + thirdTotalprice.getText().toString() + " 元", Toast.LENGTH_SHORT).show();
                break;
            case R.id.third_allselect:
                adapter.selectAll(checkBoxAll.isChecked());
                break;
        }
    }
}
