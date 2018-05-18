package app.example.unit07;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Adapter;
import android.widget.Toast;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import app.example.unit07.adapter.MyAdapter;
import app.example.unit07.bean.NewsBean;
import app.example.unit07.presenter.MyPresenter;
import app.example.unit07.view.MyView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MyView {
    @BindView(R.id.xRecyclerView)
    XRecyclerView xRecyclerView;
    private MyPresenter presenter;
    private MyAdapter myAdapter;
    private Handler handler = new Handler();

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
        xRecyclerView.setLayoutManager(manager);
        xRecyclerView.setAdapter(myAdapter);

        //XRecyclerview的上拉下拉方法
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        /**
                         * 在子线程内完成上拉刷新数据
                         * 对于本接口来说，只要你把p层请求数据的方法再写一遍重新请求数据，数据就会刷新
                         */
                        presenter.getData();
                        myAdapter.notifyDataSetChanged();
                        xRecyclerView.refreshComplete();
                    }
                },500);
            }

            @Override
            public void onLoadMore() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        /**
                         *    在子线程内完成下拉加载数据
                         *    对于本接口来说，只要你把p层请求数据的方法再写一遍重新请求数据，数据就会加载
                         */
                        presenter.getData();
                        myAdapter.notifyDataSetChanged();
                        xRecyclerView.loadMoreComplete();
                    }
                },500);
            }
        });
    }

    @Override
    public void onSuccess(NewsBean bean) {
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
