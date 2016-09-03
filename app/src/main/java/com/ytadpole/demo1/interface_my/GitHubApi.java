package com.ytadpole.demo1.interface_my;

import com.ytadpole.demo1.bean.Repo;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by YS on 2016/9/3.
 */
public interface GitHubApi {
        @GET("/users/{user}/repos")
        Call<List<Repo>> listRepos(@Path("user") String user);
}
