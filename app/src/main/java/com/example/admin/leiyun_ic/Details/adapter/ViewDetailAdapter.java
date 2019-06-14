package com.example.admin.leiyun_ic.Details.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.leiyun_ic.Bean.NewHomeRecycleViewBean;
import com.example.admin.leiyun_ic.Details.Bean.ViewDetailBean;
import com.example.admin.leiyun_ic.R;
import com.example.admin.leiyun_ic.adapter.HomervAdapter;
import com.example.admin.leiyun_ic.utils.DateUtils;
import com.example.admin.leiyun_ic.views.CircleImageView;
import com.orhanobut.logger.Logger;

import java.util.List;

public class ViewDetailAdapter extends RecyclerView.Adapter<ViewDetailAdapter.MyHolder> {

    Context context;
    List<ViewDetailBean.DataBean.ListBean> list;

    public ViewDetailAdapter(Context context,List<ViewDetailBean.DataBean.ListBean> list){
        this.context =context;
        this.list=list;
    }
    @Override
    public ViewDetailAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.view_detail_item,parent,false);
        ViewDetailAdapter.MyHolder myHolder = new ViewDetailAdapter.MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(ViewDetailAdapter.MyHolder holder, int position) {
        //String s = list.get(position);
        //holder.item_iv_1.setImageURI();
        ((TextView) holder.tv_user_name).setText(list.get(position).getNickname());
        String sj = DateUtils.stampToDate(list.get(position).getGeval_addtime());
        ((TextView) holder.tv_upload_time).setText(sj);
        ((TextView) holder.tv_description).setText(list.get(position).getGeval_content());
        String url = "http://api.weboo.top";
        Glide.with(context).load(url+list.get(position).getMember_avatar()).into(holder.iv_user_icon);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView item_iv_1;
        TextView tv_user_name,tv_upload_time,tv_description;
        CircleImageView iv_user_icon;
        RecyclerView recyclerView ;
        public MyHolder(View itemView) {
            super(itemView);
            tv_user_name = itemView.findViewById(R.id.tv_user_name);
            tv_upload_time = itemView.findViewById(R.id.tv_upload_time);
            tv_description = itemView.findViewById(R.id.tv_description);
            iv_user_icon = itemView.findViewById(R.id.iv_user_icon);
            recyclerView = itemView.findViewById(R.id.recycler_pic_video);

        }
    }
}
