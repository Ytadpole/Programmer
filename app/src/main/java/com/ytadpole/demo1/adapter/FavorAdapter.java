package com.ytadpole.demo1.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.ytadpole.demo1.R;
import com.ytadpole.demo1.bean.HomeBean;

import java.util.List;


/**
 * Created by YS on 2016/9/2.
 */
public class FavorAdapter extends RecyclerView.Adapter<FavorAdapter.Holder> {
    public List<HomeBean.ResultsBean> data;
    public FavorAdapter(List<HomeBean.ResultsBean> data){
        this.data = data;
    }
    @Override
    public FavorAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favor, parent, false);
        Holder holder = new Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(FavorAdapter.Holder holder, int position) {
        holder.tv.setText(data.get(position).getDesc());
        holder.timeTv.setText(data.get(position).getPublishedAt());
        if(data.get(position).getWho()!=null){
            holder.authorTv.setText(data.get(position).getWho().toString());
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{
        public TextView tv;
        public TextView authorTv;
        public TextView timeTv;
        public Holder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.item_txt2);
            authorTv = (TextView) itemView.findViewById(R.id.item_author);
            timeTv = (TextView)itemView.findViewById(R.id.item_time);
        }
    };
}
