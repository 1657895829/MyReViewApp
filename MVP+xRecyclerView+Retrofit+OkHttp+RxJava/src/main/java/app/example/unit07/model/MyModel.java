package app.example.unit07.model;

import app.example.unit07.app.MyApplication;
import app.example.unit07.bean.NewsBean;
import app.example.unit07.view.MyView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * model层请求数据类
 */

public class MyModel {
    public void getData(final MyView myView){
        //设置请求接口的key值
        Call<NewsBean> data = MyApplication.retrofit.getData();

        //发起异步请求
        data.enqueue(new Callback<NewsBean>() {
            @Override
            public void onResponse(Call<NewsBean> call, Response<NewsBean> response) {
                //获取响应的数据
                NewsBean body = response.body();
                //请求成功时返回数据
                myView.onSuccess(body);
            }

            @Override
            public void onFailure(Call<NewsBean> call, Throwable t) {
                //请求失败时返回数据
                myView.onFailure(new Exception(""));
            }
        });
    }
}
