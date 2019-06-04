package com.example.admin.leiyun_ic.ClassIfication.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.leiyun_ic.ClassIfication.MostSeriesBean;
import com.example.admin.leiyun_ic.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hedong on 16-11-9.
 */
public class MostRightAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<MostSeriesBean> mList = new ArrayList<>();
    private MyItemClickListener mItemClickListener;
    private RecyclerView mRecyclerView;
    private View VIEW_FOOTER;
    private View VIEW_HEADER;
    //Type
    private int TYPE_NORMAL = 1000;
    private int TYPE_HEADER = 1001;
    private int TYPE_FOOTER = 1002;

    public MostRightAdapter(Context context) {
        mContext = context;
    }

    public void setList(List<MostSeriesBean> list) {
        if (list != null) {
            mList = list;
        }

    }

    public void setOnItemClickListener(MyItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOTER) {
            return new FooterViewHodler(VIEW_FOOTER);
        } else if (viewType == TYPE_HEADER) {
            return new FooterViewHodler(VIEW_HEADER);
        } else {
            final View view = LayoutInflater.from(mContext).inflate(R.layout.series_list_item, parent, false);
            return new ItemViewHolder(view, mItemClickListener);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeaderView(position)) {
            return TYPE_HEADER;
        } else if (isFooterView(position)) {
            return TYPE_FOOTER;
        } else {
            return TYPE_NORMAL;
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        try {
            if (mRecyclerView == null && mRecyclerView != recyclerView) {
                mRecyclerView = recyclerView;
            }
            ifGridLayoutManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private View getLayout(int layoutId) {
        return LayoutInflater.from(mContext).inflate(layoutId, null);
    }

    public void addHeaderView(View headerView) {
        if (haveHeaderView()) {
            throw new IllegalStateException("hearview has already exists!");
        } else {
            //避免出现宽度自适应
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            headerView.setLayoutParams(params);
            VIEW_HEADER = headerView;
            ifGridLayoutManager();
            notifyItemInserted(0);
        }
    }

    public void addFooterView(View footerView) {
        if (haveFooterView()) {
            throw new IllegalStateException("footerView has already exists!");
        } else {
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            footerView.setLayoutParams(params);
            VIEW_FOOTER = footerView;
            ifGridLayoutManager();
            notifyItemInserted(getItemCount() - 1);
        }
    }


    private void ifGridLayoutManager() {
        if (mRecyclerView == null) return;
        final RecyclerView.LayoutManager layoutManager = mRecyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager.SpanSizeLookup originalSpanSizeLookup =
                    ((GridLayoutManager) layoutManager).getSpanSizeLookup();
            ((GridLayoutManager) layoutManager).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return (isHeaderView(position) || isFooterView(position)) ? ((GridLayoutManager) layoutManager).getSpanCount() : 1;

                }
            });
        }
    }
    private boolean haveHeaderView() {
        return VIEW_HEADER != null;
    }
    public boolean haveFooterView() {
        return VIEW_FOOTER != null;
    }
    private boolean isHeaderView(int position) {
        return haveHeaderView() && position == 0;
    }
    private boolean isFooterView(int position) {
        return haveFooterView() && position == getItemCount() - 1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (!isHeaderView(position) && !isFooterView(position)) {
            if (haveHeaderView()) position--;
            ItemViewHolder item = (ItemViewHolder) holder;
            final MostSeriesBean bean = mList.get(position);
            item.mostRightName.setText(bean.getName());
        }
    }

    @Override
    public int getItemCount() {
        int count = (mList == null ? 0 : mList.size());
        if (VIEW_FOOTER != null) {
            count++;
        }
        if (VIEW_HEADER != null) {
            count++;
        }
        return count;
    }

    public interface MyItemClickListener {
        void onItemClick(View view, int postion);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private MyItemClickListener mListener;
        @BindView(R.id.series_name)
        TextView mostRightName;


        public ItemViewHolder(View itemView, MyItemClickListener listener) {
            super(itemView);
            this.mListener = listener;
            itemView.setOnClickListener(this);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.onItemClick(v, getLayoutPosition());
            }
        }
    }

    public class FooterViewHodler extends RecyclerView.ViewHolder {
        public FooterViewHodler(View itemView) {
            super(itemView);
        }
    }
}
