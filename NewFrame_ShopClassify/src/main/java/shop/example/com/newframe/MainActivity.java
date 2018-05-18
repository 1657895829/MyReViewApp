package shop.example.com.newframe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import shop.example.com.newframe.bean.ShopBean;
import shop.example.com.newframe.component.DaggerHttpComponent;
import shop.example.com.newframe.module.HttpModule;
import shop.example.com.newframe.ui.adapter.MyAdapter;
import shop.example.com.newframe.ui.base.BaseActivity;
import shop.example.com.newframe.ui.contract.ShopContract;
import shop.example.com.newframe.ui.presenter.ShopPresenter;

public class MainActivity extends BaseActivity<ShopPresenter> implements ShopContract.View {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initView();

        //调用p层执行方法
        mPresenter.getData();
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
    public void showShop(ShopBean bean) {
        //请求成功时添加数据，多条目展示
        myAdapter.addData(bean);
    }

    private void initView() {
        //设置布局管理器以及数据适配器
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        myAdapter = new MyAdapter(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(myAdapter);
    }
}
