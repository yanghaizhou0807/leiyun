package com.example.admin.leiyun_ic.MyMall;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.Base.BaseUrl;
import com.example.admin.leiyun_ic.Bean.HomeRecycleViewBean;
import com.example.admin.leiyun_ic.Bean.NewHomeRecycleViewBean;
import com.example.admin.leiyun_ic.Details.ModifyAddressActivity;
import com.example.admin.leiyun_ic.HomePage.HomePageActivity;
import com.example.admin.leiyun_ic.HomePage.IntegralSuperiorityActivity;
import com.example.admin.leiyun_ic.LoginActivity;
import com.example.admin.leiyun_ic.R;
import com.example.admin.leiyun_ic.adapter.HomervAdapter;
import com.example.admin.leiyun_ic.utils.GsonQuick;
import com.heigo.http.okhttp.OkHttpUtils;
import com.heigo.http.okhttp.builder.GetBuilder;
import com.heigo.http.okhttp.callback.StringCallback;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class MyMallActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView rv;
    private ScrollView scrollview;
    private List<NewHomeRecycleViewBean.DataBean.ListBean> list;
    private ArrayList<NewHomeRecycleViewBean.DataBean.ListBean> allList;
    private NewHomeRecycleViewBean homeRecycleViewBean;
    private HomervAdapter adapter;
    private TextView allOrders;
    private ImageView set_up_iv,msg_iv;
    private LinearLayout pending_payment_iv,to_be_shipped_iv,goods_to_be_received_iv,to_be_evaluated,after_sale_refund;
    private LinearLayout address,integral,footprint,arrival_notice,my_invoice,my_family_number,feedback,serve_for_help;
    private LinearLayout balance,available_integral,coupon_llyt;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mymall_acty);
        initView();
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setNestedScrollingEnabled(false);
        LinearLayoutManager linerLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linerLayoutManager);
        rv.setLayoutManager(new GridLayoutManager(this, 2));

    }

    private void initView() {

        balance = (LinearLayout)findViewById(R.id.balance);
        balance.setOnClickListener(this);
        available_integral = (LinearLayout)findViewById(R.id.available_integral);
        available_integral.setOnClickListener(this);
        coupon_llyt = (LinearLayout)findViewById(R.id.coupon_llyt);
        coupon_llyt.setOnClickListener(this);

        address = (LinearLayout) findViewById(R.id.address);
        address.setOnClickListener(this);
        integral = (LinearLayout) findViewById(R.id.integral);
        integral.setOnClickListener(this);
        footprint = (LinearLayout) findViewById(R.id.footprint);
        footprint.setOnClickListener(this);
        arrival_notice = (LinearLayout) findViewById(R.id.arrival_notice);
        arrival_notice.setOnClickListener(this);
        my_invoice = (LinearLayout) findViewById(R.id.my_invoice);
        my_invoice.setOnClickListener(this);
        my_family_number = (LinearLayout) findViewById(R.id.my_family_number);
        my_family_number.setOnClickListener(this);
        feedback = (LinearLayout) findViewById(R.id.feedback);
        feedback.setOnClickListener(this);
        serve_for_help = (LinearLayout) findViewById(R.id.serve_for_help);
        serve_for_help.setOnClickListener(this);

        set_up_iv = (ImageView)findViewById(R.id.set_up_btn);
        set_up_iv.setOnClickListener(this);
        msg_iv = (ImageView)findViewById(R.id.msg_iv);
        msg_iv.setOnClickListener(this);

        allOrders = (TextView)findViewById(R.id.all_orders);
        allOrders.setOnClickListener(this);
        goods_to_be_received_iv= (LinearLayout) findViewById(R.id.goods_to_be_received_iv);
        goods_to_be_received_iv.setOnClickListener(this);
        to_be_shipped_iv= (LinearLayout)findViewById(R.id.to_be_shipped_iv);
        to_be_shipped_iv.setOnClickListener(this);
        to_be_evaluated= (LinearLayout)findViewById(R.id.to_be_evaluated);
        to_be_evaluated.setOnClickListener(this);
        pending_payment_iv= (LinearLayout)findViewById(R.id.pending_payment_iv);
        pending_payment_iv.setOnClickListener(this);
        after_sale_refund= (LinearLayout)findViewById(R.id.after_sale_refund);
        after_sale_refund.setOnClickListener(this);

        allList = new ArrayList<NewHomeRecycleViewBean.DataBean.ListBean>();
        scrollview = (ScrollView)findViewById(R.id.scrollview);
        scrollview.setOnTouchListener(new TouchListenerImpl());

        //HomeRecyclerViewInterface();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.all_orders:
                Intent intent = new Intent(MyMallActivity.this, AllOrdersActivity.class);
                intent.putExtra("itemIdNum","0");
                //intent.putExtra("categoryIds",categoryIds);
                MyMallActivity.this.startActivity(intent);
                break;
            case R.id.pending_payment_iv://付款
                Intent paymentintent = new Intent(MyMallActivity.this, AllOrdersActivity.class);
                paymentintent.putExtra("itemIdNum","1");
                //intent.putExtra("categoryIds",categoryIds);
                MyMallActivity.this.startActivity(paymentintent);
                break;
            case R.id.to_be_shipped_iv://发货
                Intent shippedintent = new Intent(MyMallActivity.this, AllOrdersActivity.class);
                shippedintent.putExtra("itemIdNum","2");
                //intent.putExtra("categoryIds",categoryIds);
                MyMallActivity.this.startActivity(shippedintent);
                break;
            case R.id.goods_to_be_received_iv://收货
                Intent goodsintent = new Intent(MyMallActivity.this, AllOrdersActivity.class);
                goodsintent.putExtra("itemIdNum","3");
                //intent.putExtra("categoryIds",categoryIds);
                MyMallActivity.this.startActivity(goodsintent);
                break;
            case R.id.to_be_evaluated://评价
                Intent evaluated = new Intent(MyMallActivity.this, AllOrdersActivity.class);
                evaluated.putExtra("itemIdNum","4");
                //intent.putExtra("categoryIds",categoryIds);
                MyMallActivity.this.startActivity(evaluated);
                break;
            case R.id.after_sale_refund://售后
                Intent refund = new Intent(MyMallActivity.this, AfterSaleRefundActivity.class);
                MyMallActivity.this.startActivity(refund);
                break;
            case R.id.msg_iv://消息
                Intent msgiv = new Intent(MyMallActivity.this, MessageCenterActivity.class);
                MyMallActivity.this.startActivity(msgiv);
                break;
            case R.id.set_up_btn://设置
                Intent setupiv = new Intent(MyMallActivity.this, AccountSettingsActivity.class);
                MyMallActivity.this.startActivity(setupiv);
                break;
            case R.id.address://收货地址
                Intent address = new Intent(MyMallActivity.this, ModifyAddressActivity.class);
                MyMallActivity.this.startActivity(address);
                break;
            case R.id.integral://积分中心
                Intent integral = new Intent(MyMallActivity.this, IntegralSuperiorityActivity.class);
                MyMallActivity.this.startActivity(integral);
                break;
            case R.id.footprint://足迹
                Intent footprint = new Intent(MyMallActivity.this, MyTracksActivity.class);
                MyMallActivity.this.startActivity(footprint);
                break;
            case R.id.arrival_notice://到货通知
                Intent notice = new Intent(MyMallActivity.this, ArrivalNoticeActivity.class);
                MyMallActivity.this.startActivity(notice);
                break;
            case R.id.feedback://反馈
                Intent feedback = new Intent(MyMallActivity.this, FeedbackActivity.class);
                MyMallActivity.this.startActivity(feedback);
                break;
            case R.id.serve_for_help://服务帮助
                Intent serve = new Intent(MyMallActivity.this, CustomerServiceCenterActivity.class);
                MyMallActivity.this.startActivity(serve);
                break;

            case R.id.balance://余额
                Intent balance = new Intent(MyMallActivity.this, BalanceActivity.class);
                MyMallActivity.this.startActivity(balance);
                break;
            case R.id.available_integral://可用积分
                Intent avin = new Intent(MyMallActivity.this, AvailableIntegralActivity.class);
                MyMallActivity.this.startActivity(avin);
                break;
            case R.id.coupon_llyt://优惠券
                Intent coupon = new Intent(MyMallActivity.this, CouponActivity.class);
                MyMallActivity.this.startActivity(coupon);
                break;
        }

    }

    private class TouchListenerImpl implements View.OnTouchListener {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:

                    break;
                case MotionEvent.ACTION_MOVE:
                    int scrollY=view.getScrollY();
                    int height=view.getHeight();
                    int scrollViewMeasuredHeight=scrollview.getChildAt(0).getMeasuredHeight();
                    if(scrollY==0){
                        //System.out.println("滑动到了顶端 view.getScrollY()="+scrollY);
                        Logger.d("response---滑动到了顶端>>:" + scrollY);

                    }
                    if((scrollY+height)==scrollViewMeasuredHeight){
                        //System.out.println("滑动到了底部 scrollY="+scrollY);
                        Logger.d("response---滑动到了底部>>:" + scrollY);
                        //HomeRecyclerViewInterface();
                        //new Thread(new CustomThread()).start();
                        //System.out.println("滑动到了底部 height="+height);
                        //System.out.println("滑动到了底部 scrollViewMeasuredHeight="+scrollViewMeasuredHeight);
                    }
                    break;

                default:
                    break;
            }
            return false;
        }

    }

    private void HomeRecyclerViewInterface() {
        //ProgressDialogManager.getInstance().showWait(this, "正在加载...");
        GetBuilder builder = OkHttpUtils.get();
        builder.addParams("method", "wap_home.product_list");
        builder.url(BaseUrl.recyclerViewUrl).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int i) {
                //ProgressDialogManager.getInstance().dissmiss();
            }

            @Override
            public void onResponse(String s, int i) {

                // ProgressDialogManager.getInstance().dissmiss();
                Logger.d("response---rv>>:" + s);
                if (!"".equals(s)) {
                    homeRecycleViewBean = GsonQuick.toObject(s, NewHomeRecycleViewBean.class);
                    if(homeRecycleViewBean.getData().getList().size()>=1){
                        list = homeRecycleViewBean.getData().getList();
                        allList.addAll(list);
                        adapter = new HomervAdapter(context, allList);
                        rv.setAdapter(adapter);
                    }

                }
            }
        });
    }
}
