package com.ytadpole.demo1.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ytadpole.demo1.R;
import com.ytadpole.demo1.adapter.FavorAdapter;
import com.ytadpole.demo1.bean.HomeBean;
import com.ytadpole.demo1.http.AppClient;
import com.ytadpole.demo1.bean.WeatherJson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavorFragment extends Fragment {


    String body;
    @BindView(R.id.list)
    RecyclerView list;
    private LinearLayoutManager mLManager;
    private FavorAdapter mAdapter;
    private List<HomeBean.ResultsBean> mList;

    public FavorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLManager = new LinearLayoutManager(getActivity());
        mList = new ArrayList<>();
        mAdapter = new FavorAdapter(mList);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favor, container, false);
        ButterKnife.bind(this, view);
        initRecylerView();
        getData();
        return view;
    }


    private void initRecylerView() {
        list.setLayoutManager(mLManager);
        list.setHasFixedSize(true);
        list.setAdapter(mAdapter);


//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.github.com/")
//                .build();
//        GitHubApi api = retrofit.create(GitHubApi.class);
//        Call<List<Repo>> repos = api.listRepos("octocat");




    }

    public void getData() {
//        RequestParams params = new RequestParams("https://www.baidu.com/");
//        x.http().get(params, new org.xutils.common.Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess(String result) {
//                Toast.makeText(getActivity(), "onSuccess",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//                Toast.makeText(getActivity(), "onError",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//                Toast.makeText(getActivity(), "onCancelled",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFinished() {
//                Toast.makeText(getActivity(), "onFinished",Toast.LENGTH_SHORT).show();
//            }
//        });

        AppClient.ApiStores apiStores = AppClient.retrofit().create(AppClient.ApiStores.class);
        Call<HomeBean> call = apiStores.getHome("Android","10","1");
        call.enqueue(new Callback<HomeBean>() {
            @Override
            public void onResponse(Call<HomeBean> call, Response<HomeBean> response) {
                Log.e("test", response.body().getResults().toString());
                mList.addAll(response.body().getResults());
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<HomeBean> call, Throwable t) {
                Toast.makeText(getActivity(), "err"+t.toString(), Toast.LENGTH_SHORT).show();
            }

        });
    }
}
