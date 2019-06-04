package com.example.admin.leiyun_ic.MyMall.adapter;

import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.leiyun_ic.Details.CommodityDetailsActivity;
import com.example.admin.leiyun_ic.MyMall.GoodsEntity;
import com.example.admin.leiyun_ic.R;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import static com.meizu.cloud.pushsdk.notification.model.NotifyType.TAG;

public class AllOrdersAdapter extends RecyclerView.Adapter<AllOrdersAdapter.myViewHodler> {
    private Context context;
    private BottomSheetDialog dialog;
    private ArrayList<GoodsEntity> goodsEntityList;
    //创建构造函数
    public AllOrdersAdapter(Context context, ArrayList<GoodsEntity> goodsEntityList) {
        //将传递过来的数据，赋值给本地变量
        this.context = context;//上下文
        this.goodsEntityList = goodsEntityList;//实体类数据ArrayList
    }
    @Override
    public myViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建自定义布局
        //View itemView = View.inflate(context, R.layout.item_all_orders, null);
        //return new myViewHodler(itemView);
        //return null;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_orders, parent, false);
        return new myViewHodler(v);
    }

    @Override
    public void onBindViewHolder(myViewHodler holder, final int position) {
        final GoodsEntity data = goodsEntityList.get(position);
//      holder.mItemGoodsImg;
        String s ="http://img11.360buyimg.com/n1/jfs/t4540/304/4173403733/275937/48e53c83/590ad156Nf68db088.jpg";
        holder.mItemGoodsName.setText(data.goodsName);//获取实体类中的name字段并设置
        holder.mItemGoodsPrice.setText(data.goodsPrice);//获取实体类中的price字段并设置
        holder.tv_state.setText("等待付款");//
        Glide.with(context).load(s).into(holder.mItemGoodsImg);
        holder.tv_merchandise_button.setText("去支付");//
        holder.tv_merchandise_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.d("position---position>>:" + position);
                chooseMediaType();

            }
        });

    }

    private void chooseMediaType() {
        dialog = new BottomSheetDialog(context);
        View bottomView = LayoutInflater.from(context).inflate(R.layout.payment_window, null);
       /* TextView tv_choose_img = bottomView.findViewById(R.id.tv_choose_img);//相册选择
        TextView tv_choose_video = bottomView.findViewById(R.id.tv_choose_video);//视频
        TextView tv_choose_cancel = bottomView.findViewById(R.id.tv_cancel);
        TextView tv_take_photo = bottomView.findViewById(R.id.tv_take_photo);//拍照*/

//        tv_choose_img.setOnClickListener(this);
//        tv_choose_video.setOnClickListener(this);
//        tv_choose_cancel.setOnClickListener(this);
//        tv_take_photo.setOnClickListener(this);


        dialog.setContentView(bottomView);
        dialog.show();

    }

    @Override
    public int getItemCount() {
        return goodsEntityList.size();
    }

    //自定义viewhodler
    class myViewHodler extends RecyclerView.ViewHolder {
        private ImageView mItemGoodsImg;
        private TextView mItemGoodsName;
        private TextView mItemGoodsPrice;
        private TextView tv_state,tv_merchandise_button;

        public myViewHodler(View itemView) {
            super(itemView);
            mItemGoodsImg = (ImageView) itemView.findViewById(R.id.item_goods_img);
            mItemGoodsName = (TextView) itemView.findViewById(R.id.item_goods_name);
            mItemGoodsPrice = (TextView) itemView.findViewById(R.id.item_goods_price);
            tv_state = (TextView)itemView.findViewById(R.id.tv_state);
            tv_merchandise_button = (TextView)itemView.findViewById(R.id.tv_merchandise_button);
            //点击事件放在adapter中使用，也可以写个接口在activity中调用
            //方法一：在adapter中设置点击事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //可以选择直接在本位置直接写业务处理
                    //Toast.makeText(context,"点击了xxx",Toast.LENGTH_SHORT).show();
                    //此处回传点击监听事件
                    if(onItemClickListener!=null){
                        onItemClickListener.OnItemClick(v, goodsEntityList.get(getLayoutPosition()));
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
        public void OnItemClick(View view, GoodsEntity data);
    }

    //需要外部访问，所以需要设置set方法，方便调用
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


}
