package com.example.admin.leiyun_ic.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.leiyun_ic.Bean.HomeRecycleViewBean;
import com.example.admin.leiyun_ic.Bean.NewHomeRecycleViewBean;
import com.example.admin.leiyun_ic.R;
import com.orhanobut.logger.Logger;

import java.util.List;

public class HomervAdapter extends RecyclerView.Adapter<HomervAdapter.MyHolder> {

    Context context;
    List<NewHomeRecycleViewBean.DataBean.ListBean> list;

    public HomervAdapter(Context context,List<NewHomeRecycleViewBean.DataBean.ListBean> list){
        this.context =context;
        this.list=list;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.home_rycl_item,parent,false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        //String s = list.get(position);
        //holder.item_iv_1.setImageURI();
        ((TextView) holder.item_tv_1).setText(list.get(position).getGoods_name());
        ((TextView) holder.marketprice_tv).setText("￥"+list.get(position).getGoods_price());
        Glide.with(context).load(list.get(position).getGoods_image()).into(holder.item_iv_1);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView item_iv_1;
        TextView item_tv_1,marketprice_tv;
        public MyHolder(View itemView) {
            super(itemView);
            item_iv_1 = itemView.findViewById(R.id.item_iv_1);
            item_tv_1 = itemView.findViewById(R.id.recycle_tv);
            marketprice_tv = itemView.findViewById(R.id.marketprice_tv);
            Logger.d("list---list>>:" + 2);

        }
    }
}
