package com.example.admin.leiyun_ic.ClassIfication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.leiyun_ic.R;

import java.util.List;

/**
 * Created by Administrator on 2018-03-19.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private List<Integer> mDatas;

    /**
     * 构造器
     * @param context
     * @param datats
     */
    public MyRecyclerViewAdapter(Context context, List<Integer> datats)
    {
        mInflater = LayoutInflater.from(context);
        mDatas = datats;
    }

    /**
     * 自己的ViewHolder必须继承RecyclerView.ViewHolder
     */
    public static class ViewHolder extends RecyclerView.ViewHolder
    {   //构造器参数是待显示的item的布局的view
        public ViewHolder(View arg0)
        {
            super(arg0);
        }

        ImageView mImg;
        TextView mTxt;
    }

    /**
     * 获取总的条目数
     * @return
     */
    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }

    /**
     * 创建ViewHolder
     * viewHolder类似于ListView的convertView，同样类似于BaseAdapter的getView()方法
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View view = mInflater.inflate(R.layout.recyclerview_item,
                viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.mImg = (ImageView) view
                .findViewById(R.id.id_index_gallery_item_image);
        return viewHolder;
    }

    /**
     * 给各个item绑定数据
     */
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i)
    {
        viewHolder.mImg.setImageResource(mDatas.get(i));
        if(mOnItemClickLitener != null){
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickLitener.onItemClick(viewHolder.itemView,i);
                }
            });
        }
    }
    /**
     * ItemClick的回调接口
     * @author zhy
     *
     */
    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }
}
