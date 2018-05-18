package com.example.unit08;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.example.unit08.adapter.MyAdapter;
import com.example.unit08.bean.ShopBean;
import com.example.unit08.presenter.MyPresenter;
import com.example.unit08.view.MyView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MyView {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private MyPresenter presenter;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //创建Presenter层实例,与view层交互
        presenter = new MyPresenter(this);
        presenter.getData();

        //设置布局管理器以及数据适配器
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        myAdapter = new MyAdapter(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onSuccess(ShopBean bean) {
        //请求成功时添加数据，多条目展示
        myAdapter.addData(bean);
    }

    @Override
    public void onFailure(Exception e) {
        Toast.makeText(MainActivity.this,"数据出错",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //调用p层解绑方法
        presenter.detach();
    }
}
