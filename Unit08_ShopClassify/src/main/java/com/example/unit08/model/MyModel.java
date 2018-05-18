package com.example.unit08.model;
import com.example.unit08.app.MyApplication;
import com.example.unit08.bean.ShopBean;
import com.example.unit08.view.MyView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * model层请求数据类
 */

public class MyModel {
    public void getData(final MyView myView){
        //设置请求接口的key值
        Call<ShopBean> call = MyApplication.request.get();

        //发起异步请求
        call.enqueue(new Callback<ShopBean>() {
            @Override
            public void onResponse(Call<ShopBean> call, Response<ShopBean> response) {
                //获取响应的数据
                ShopBean body = response.body();
                //请求成功时返回数据
                myView.onSuccess(body);
            }

            @Override
            public void onFailure(Call<ShopBean> call, Throwable t) {
                //请求失败时返回数据
                myView.onFailure(new Exception(""));
            }
        });
    }
}
