package com.example.admin.leiyun_ic.MyMall.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.admin.leiyun_ic.MyMall.GoodsEntity;
import com.example.admin.leiyun_ic.MyMall.adapter.AllOrdersAdapter;
import com.example.admin.leiyun_ic.R;

import java.util.ArrayList;

public class AllOrdersFragment extends Fragment {

    public RecyclerView allOrdersRv;
    private View view;//
    private AllOrdersAdapter mCollectRecyclerAdapter;
    //定义以goodsentity实体类为对象的数据集合
    private ArrayList<GoodsEntity> goodsEntityList = new ArrayList<GoodsEntity>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.all_orders_fragment, container,false);
        initView();
        initData();
        return view;

    }

    /**
     * TODO 模拟数据
     */
    private void initData() {
        for (int i=0;i<10;i++){
            GoodsEntity goodsEntity=new GoodsEntity();
            goodsEntity.setGoodsName("模拟数据"+i);
            goodsEntity.setGoodsPrice("100"+i);
            goodsEntityList.add(goodsEntity);
        }
    }

    private void initView() {
        allOrdersRv = (RecyclerView) view.findViewById(R.id.all_recyclerView);
        //创建adapter
        mCollectRecyclerAdapter = new AllOrdersAdapter(getActivity(), goodsEntityList);
        //给RecyclerView设置adapter
        allOrdersRv.setAdapter(mCollectRecyclerAdapter);
        //设置layoutManager,可以设置显示效果，是线性布局、grid布局，还是瀑布流布局
        //参数是：上下文、列表方向（横向还是纵向）、是否倒叙
        allOrdersRv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        //设置item的分割线
        allOrdersRv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        //RecyclerView中没有item的监听事件，需要自己在适配器中写一个监听事件的接口。参数根据自定义
        mCollectRecyclerAdapter.setOnItemClickListener(new AllOrdersAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, GoodsEntity data) {
                //此处进行监听事件的业务处理
                Toast.makeText(getActivity(),"我是item",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
