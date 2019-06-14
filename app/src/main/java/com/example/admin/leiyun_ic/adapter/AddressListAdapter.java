package com.example.admin.leiyun_ic.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.example.admin.leiyun_ic.Bean.UserAddressListBean;
import com.example.admin.leiyun_ic.Details.AddAddressActivity;
import com.example.admin.leiyun_ic.R;
import com.orhanobut.logger.Logger;

import java.util.List;

public class AddressListAdapter extends RecyclerView.Adapter<AddressListAdapter.MyHolder> {

    Context context;
    List<UserAddressListBean.DataBeanX.DataBean> list;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View v,int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        onItemClickListener= listener;
    }

    public AddressListAdapter(Context context, List<UserAddressListBean.DataBeanX.DataBean> list){
        this.context =context;
        this.list=list;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.address_list_item,parent,false);
        AddressListAdapter.MyHolder myHolder = new AddressListAdapter.MyHolder(view);
        /*view.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Logger.e("response-22-deviceid--->>:" + "11111");
                onItemClickListener.onItemClick();
            }
        });*/
        return myHolder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {

        ((TextView) holder.name).setText(list.get(position).getTrue_name());
        ((TextView) holder.phone).setText(list.get(position).getMob_phone());
        if("0".equals(list.get(position).getIs_default())){
            ((TextView) holder.moren).setVisibility(View.GONE);
        }else  if("1".equals(list.get(position).getIs_default())){
            ((TextView) holder.moren).setVisibility(View.VISIBLE);
        }
        ((TextView) holder.address).setText(list.get(position).getArea_info()+list.get(position).getAddress());
        //Glide.with(context).load(list.get(position).getGoods_image()).into(holder.item_iv_1);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "你想与"  + "聊天", Toast.LENGTH_SHORT).show();
                //onItemClickListener.onItemClick(holder.itemView, holder.getLayoutPosition());
                //Intent intent=new Intent();
                Intent intent=new Intent(context,AddAddressActivity.class);
                intent.putExtra("true_name",list.get(position).getTrue_name());
                intent.putExtra("mob_phone",list.get(position).getMob_phone());
                intent.putExtra("area_info",list.get(position).getArea_info());
                intent.putExtra("address",list.get(position).getAddress());
                intent.putExtra("is_default",list.get(position).getIs_default());
                intent.putExtra("address_id",list.get(position).getAddress_id()+"");
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView item_iv_1;
        TextView name,phone,moren,address;
        public MyHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone);
            moren = itemView.findViewById(R.id.moren);
            address = itemView.findViewById(R.id.address);

        }
    }
}
