package com.example.app;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;
import com.example.app.adapter.MyAdapter;
import com.example.app.bean.WeiXinBean;
import com.example.app.service.GetDataInterface;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.xRecyclerView)
    XRecyclerView xRecyclerView;
    private MyAdapter adapter;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getNetData();

        //XRecyclerview的上拉下拉方法
        /**
         * 在子线程内完成上拉刷新数据
         * 对于本接口来说，只要你把p层请求数据的方法再写一遍重新请求数据，数据就会刷新
         */
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getNetData();
                        adapter.notifyDataSetChanged();
                        xRecyclerView.refreshComplete();
                    }
                },500);
            }

            @Override
            public void onLoadMore() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getNetData();
                        adapter.notifyDataSetChanged();
                        xRecyclerView.loadMoreComplete();
                    }
                },500);
            }
        });
    }

    //使用Retrofit封装请求数据的方法
    private void getNetData() {
        //创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.tianapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //创建 网络请求接口类的 实例
        GetDataInterface request = retrofit.create(GetDataInterface.class);

        //对 发送的请求 进行封装
        Call<WeiXinBean> call = request.getCall();

        //发送异步网络请求
        call.enqueue(new Callback<WeiXinBean>() {

            @Override
            public void onResponse(Call<WeiXinBean> call, Response<WeiXinBean> response) {
                //处理返回的数据结果
                WeiXinBean bean = response.body();
                List<WeiXinBean.NewslistBean> list = bean.getNewslist();

                //设置布局管理器以及数据适配器
                xRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));

                //更新UI，适配器添加数据
                if(adapter == null){
                    adapter = new MyAdapter(MainActivity.this, list);
                    xRecyclerView.setAdapter(adapter);
                }else {
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<WeiXinBean> call, Throwable t) {
                Toast.makeText(MainActivity.this, "数据出错：" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
