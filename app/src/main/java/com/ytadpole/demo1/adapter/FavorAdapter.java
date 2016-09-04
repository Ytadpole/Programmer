package com.ytadpole.demo1.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.facebook.drawee.view.SimpleDraweeView;
import com.ytadpole.demo1.R;
import com.ytadpole.demo1.bean.HomeBean;

import java.util.List;


/**
 * Created by YS on 2016/9/2.
 */
public class FavorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<HomeBean.ResultsBean> data;
    public FavorAdapter(List<HomeBean.ResultsBean> data){
        this.data = data;
    }
    public static enum ItemType{
        ITEM_TYPE_NORMAL,
        ITEM_TYPE_IMG
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if (viewType == ItemType.ITEM_TYPE_NORMAL.ordinal()) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favor, parent, false);
            return new Holder(v);
        }else{
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favor_pic, parent, false);
            return new ImagHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof Holder) {
            ((Holder)holder).tv.setText(data.get(position).getDesc());
            ((Holder)holder).timeTv.setText(data.get(position).getPublishedAt());
            if (data.get(position).getWho() != null) {
                ((Holder)holder).authorTv.setText(data.get(position).getWho().toString());
            }
        }else if(holder instanceof ImagHolder){
            ((ImagHolder)holder).iv.setImageURI(Uri.parse(data.get(position).getUrl()));
            ((ImagHolder)holder).timeTv.setText(data.get(position).getPublishedAt());
            if (data.get(position).getWho() != null) {
                ((ImagHolder)holder).authorTv.setText(data.get(position).getWho().toString());
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(data.get(position).getType().equals("福利")){
            return ItemType.ITEM_TYPE_IMG.ordinal();
        }else{
            return ItemType.ITEM_TYPE_NORMAL.ordinal();
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

    public static class ImagHolder extends RecyclerView.ViewHolder{
        public SimpleDraweeView iv;
        public TextView authorTv;
        public TextView timeTv;
        public ImagHolder(View itemView) {
            super(itemView);
            iv = (SimpleDraweeView) itemView.findViewById(R.id.item_img);
            authorTv = (TextView) itemView.findViewById(R.id.item_author);
            timeTv = (TextView)itemView.findViewById(R.id.item_time);
        }
    }
}
