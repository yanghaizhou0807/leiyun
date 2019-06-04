package com.example.admin.leiyun_ic.MyMall.adapter;

import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.leiyun_ic.MyMall.GoodsEntity;
import com.example.admin.leiyun_ic.MyMall.entity.RecordEntity;
import com.example.admin.leiyun_ic.R;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

public class RecordAdapter  extends RecyclerView.Adapter<RecordAdapter.myViewHodler> {

    private Context context;
    private BottomSheetDialog dialog;
    private ArrayList<RecordEntity> recordEntityList;

    //创建构造函数
    public RecordAdapter(Context context, ArrayList<RecordEntity> recordEntityList) {
        //将传递过来的数据，赋值给本地变量
        this.context = context;//上下文
        this.recordEntityList = recordEntityList;//实体类数据ArrayList
    }

    @Override
    public myViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建自定义布局
        //View itemView = View.inflate(context, R.layout.item_all_orders, null);
        //return new myViewHodler(itemView);
        //return null;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_balance_item, parent, false);
        return new RecordAdapter.myViewHodler(v);
    }

    @Override
    public void onBindViewHolder(RecordAdapter.myViewHodler holder, int position) {

        final RecordEntity data = recordEntityList.get(position);
//      holder.mItemGoodsImg;
        String s ="http://img11.360buyimg.com/n1/jfs/t4540/304/4173403733/275937/48e53c83/590ad156Nf68db088.jpg";
        holder.item_name.setText(data.name);//获取实体类中的name字段并设置
        //holder.item_time.setText(data.time);//获取实体类中的price字段并设置
        holder.intm_price.setText(data.price);//获取实体类中的price字段并设置

    }

    @Override
    public int getItemCount() {
        return recordEntityList.size();
    }


    //自定义viewhodler
    class myViewHodler extends RecyclerView.ViewHolder {
        private TextView item_time;
        private TextView item_name;
        private TextView intm_price;

        public myViewHodler(View itemView) {
            super(itemView);
            item_time = (TextView) itemView.findViewById(R.id.item_time);
            item_name = (TextView) itemView.findViewById(R.id.item_name);
            intm_price = (TextView) itemView.findViewById(R.id.intm_price);
            //点击事件放在adapter中使用，也可以写个接口在activity中调用
            //方法一：在adapter中设置点击事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //可以选择直接在本位置直接写业务处理
                    //Toast.makeText(context,"点击了xxx",Toast.LENGTH_SHORT).show();
                    //此处回传点击监听事件
                    if(onItemClickListener!=null){
                        onItemClickListener.OnItemClick(v, recordEntityList.get(getLayoutPosition()));
                    }
                }
            });

        }
    }

    /**
     * 设置item的监听事件的接口
     */
    public interface OnItemClickListener {
        /**
         * 接口中的点击每一项的实现方法，参数自己定义
         *
         * @param view 点击的item的视图
         * @param data 点击的item的数据
         */
        public void OnItemClick(View view, RecordEntity data);
    }

    //需要外部访问，所以需要设置set方法，方便调用
    private RecordAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(RecordAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


}
