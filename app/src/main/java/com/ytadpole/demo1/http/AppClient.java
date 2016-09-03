package com.ytadpole.demo1.http;

import com.ytadpole.demo1.bean.HomeBean;
import com.ytadpole.demo1.bean.WeatherJson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by YS on 2016/9/3.
 */
public class AppClient {
    static Retrofit mRetrofit;
    public static Retrofit retrofit() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl("http://gank.io/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
    public interface ApiStores {
        @GET("data/{type}/{size}/{page}")
        Call<HomeBean> getHome(@Path("type") String type, @Path("size") String size, @Path("page") String page);
    }
}
