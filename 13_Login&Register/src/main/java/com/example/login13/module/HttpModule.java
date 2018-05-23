package com.example.login13.module;

import com.example.login13.net.UserApi;
import com.example.login13.net.UserApiService;
import java.util.concurrent.TimeUnit;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created   by    Dewey
 */
@Module      //提供依赖对象的实例
public class HttpModule {
    @Provides
    OkHttpClient.Builder provideOkHttpClientBuilder() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS);
    }


    @Provides  // 关键字，标明该方法提供依赖对象
    UserApi provideUserApi(OkHttpClient.Builder builder) {
        UserApiService service = new Retrofit.Builder()
                .baseUrl("http://120.27.23.105/")
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(UserApiService.class);
        return UserApi.getDataApi(service);
    }
}
