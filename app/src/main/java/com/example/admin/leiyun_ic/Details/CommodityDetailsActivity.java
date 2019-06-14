package com.example.admin.leiyun_ic.Details;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.Base.BaseUrl;
import com.example.admin.leiyun_ic.Bean.UserPersonalInfoBean;
import com.example.admin.leiyun_ic.Details.Bean.goodsDetailBean;
import com.example.admin.leiyun_ic.Details.adapter.ShoppingCartColorAdapter;
import com.example.admin.leiyun_ic.Details.adapter.ShoppingCartSizeAdapter;
import com.example.admin.leiyun_ic.HomePage.HomePageActivity;
import com.example.admin.leiyun_ic.R;
import com.example.admin.leiyun_ic.utils.Constant;
import com.example.admin.leiyun_ic.utils.GsonQuick;
import com.example.admin.leiyun_ic.views.CircleImageView;
import com.heigo.http.okhttp.OkHttpUtils;
import com.heigo.http.okhttp.builder.GetBuilder;
import com.heigo.http.okhttp.callback.StringCallback;
import com.orhanobut.logger.Logger;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import idea.analyzesystem.scrollview.IdeaScrollView;
import idea.analyzesystem.scrollview.IdeaViewPager;
import okhttp3.Call;
import qiu.niorgai.StatusBarCompat;

public class CommodityDetailsActivity extends BaseActivity implements View.OnClickListener {

    private IdeaViewPager viewPager;
    //private ImageView viewPager;
    private IdeaScrollView ideaScrollView;
    private TextView text;
    private LinearLayout header;
    private RadioGroup radioGroup;
    private LinearLayout headerParent;
    private ImageView icon,coupon_cartridge,yanse_fenlei;
    private View layer;
    private float currentPercentage = 0;
    private TextView view_details,overlay_cover_buy;
    private BottomSheetDialog dialog;

    private ShoppingCartColorAdapter attributeColorAdapter;
    private ShoppingCartSizeAdapter attributeSizeAdapter;
    private GridView gvAttributeOne,gvAttributeTwo,gvAttributeThree,gvAttributeFour,gvAttributeFive;



    private RadioGroup.OnCheckedChangeListener radioGroupListener =new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            for(int i=0;i<radioGroup.getChildCount();i++){
                RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
                radioButton.setTextColor(radioButton.isChecked()?getRadioCheckedAlphaColor(currentPercentage):getRadioAlphaColor(currentPercentage));
                if(radioButton.isChecked()&&isNeedScrollTo){      //#444444                                   // #ffffff
                    ideaScrollView.setPosition(i);
                }
            }
        }
    };
    private boolean isNeedScrollTo = true;



    private goodsDetailBean goodsDetailBean;
    private TextView trade_name_tv,market_value_tv,discount_rate_tv,primary_price_tv,sale_num_tv,color_tv,size_tv;
    private TextView all_evaluations_tv,new_evaluations_tv,good_evaluations_tv,middle_evaluations_tv,pic_evaluations_tv,add_evaluations_tv;
    private CircleImageView iv_user_icon_one,iv_user_icon_two;
    private TextView tv_user_name_one,tv_user_name_two;
    private String url = "http://api.weboo.top";
    private TextView comments_tv_one,comments_tv_two;
    private WebView webView;

    private List<String> list;
    InnerBroadcastReceiver receiver;
    private String seledtedColor,commodityNum;
    private String seledtedSize;
    private Button rbAttributeSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_acty);
        StatusBarCompat.translucentStatusBar(this);

        initView();
        header = (LinearLayout)findViewById(R.id.header);
        headerParent = (LinearLayout)findViewById(R.id.headerParent);
       // icon = (ImageView)findViewById(R.id.icon);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        ideaScrollView = (IdeaScrollView)findViewById(R.id.ideaScrollView);
        viewPager = (IdeaViewPager) findViewById(R.id.viewPager);

        list = new ArrayList<>();
        list.add("http://www.mangowed.com/uploads/allimg/130425/572-130425105311304.jpg");
        list.add("http://www.mangowed.com/uploads/allimg/130425/572-130425105311304.jpg");
        list.add("http://www.mangowed.com/uploads/allimg/130425/572-130425105311304.jpg");
        list.add("http://www.mangowed.com/uploads/allimg/130425/572-130425105311304.jpg");
        ViewpagerAdapter adapter=new ViewpagerAdapter(CommodityDetailsActivity.this,list);
        viewPager.setAdapter(adapter);


        layer = findViewById(R.id.layer);
        coupon_cartridge=(ImageView)findViewById(R.id.coupon_cartridge);
        coupon_cartridge.setOnClickListener(this);
        yanse_fenlei=(ImageView)findViewById(R.id.yanse_fenlei);
        yanse_fenlei.setOnClickListener(this);
        view_details = (TextView)findViewById(R.id.view_details);
        view_details.setOnClickListener(this);

        overlay_cover_buy = (TextView)findViewById(R.id.overlay_cover_buy);
        overlay_cover_buy.setOnClickListener(this);

        Rect rectangle= new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rectangle);
        ideaScrollView.setViewPager(viewPager,getMeasureHeight(headerParent)-rectangle.top);
        //icon.setImageAlpha(0);
        radioGroup.setAlpha(0);
        radioGroup.check(radioGroup.getChildAt(0).getId());

        View one = findViewById(R.id.one);
        View two = findViewById(R.id.two);
        View four = findViewById(R.id.four);
        View three = findViewById(R.id.three);
        ArrayList<Integer> araryDistance = new ArrayList<>();

        araryDistance.add(0);
        araryDistance.add(getMeasureHeight(one)-getMeasureHeight(headerParent));
        araryDistance.add(getMeasureHeight(one)+getMeasureHeight(two)-getMeasureHeight(headerParent));
        //araryDistance.add(getMeasureHeight(one)+getMeasureHeight(two)+getMeasureHeight(three)-getMeasureHeight(headerParent));

        ideaScrollView.setArrayDistance(araryDistance);

        ideaScrollView.setOnScrollChangedColorListener(new IdeaScrollView.OnScrollChangedColorListener() {
            @Override
            public void onChanged(float percentage) {

                int color = getAlphaColor(percentage>0.9f?1.0f:percentage);
                header.setBackgroundDrawable(new ColorDrawable(color));
                radioGroup.setBackgroundDrawable(new ColorDrawable(color));
                //icon.setImageAlpha((int) ((percentage>0.9f?1.0f:percentage)*255));
                radioGroup.setAlpha((percentage>0.9f?1.0f:percentage)*255);

                setRadioButtonTextColor(percentage);

            }

            @Override
            public void onChangedFirstColor(float percentage) {

            }

            @Override
            public void onChangedSecondColor(float percentage) {

            }
        });

        ideaScrollView.setOnSelectedIndicateChangedListener(new IdeaScrollView.OnSelectedIndicateChangedListener() {
            @Override
            public void onSelectedChanged(int position) {
                isNeedScrollTo = false;
                radioGroup.check(radioGroup.getChildAt(position).getId());
                isNeedScrollTo = true;
            }
        });

        radioGroup.setOnCheckedChangeListener(radioGroupListener);

        //初始化数据接口
        CommodityDetailsInfo();
        //详情html
        //CommodityDetailsHtmlInfo();
        registerReceiver();


    }

    private void initView() {
        //,
        trade_name_tv = (TextView)findViewById(R.id.trade_name_tv);
        market_value_tv = (TextView)findViewById(R.id.market_value_tv);
        discount_rate_tv = (TextView)findViewById(R.id.discount_rate_tv);
        primary_price_tv = (TextView)findViewById(R.id.primary_price_tv);
        sale_num_tv = (TextView)findViewById(R.id.sale_num_tv);
        color_tv = (TextView)findViewById(R.id.color_tv);
        size_tv = (TextView)findViewById(R.id.size_tv);

        /*color_two_tv = (TextView)findViewById(R.id.color_two_tv);
        color_one_tv = (TextView)findViewById(R.id.color_one_tv);*/
        add_evaluations_tv = (TextView)findViewById(R.id.add_evaluations_tv);
        pic_evaluations_tv = (TextView)findViewById(R.id.pic_evaluations_tv);
        good_evaluations_tv = (TextView)findViewById(R.id.good_evaluations_tv);
        new_evaluations_tv = (TextView)findViewById(R.id.new_evaluations_tv);
        all_evaluations_tv = (TextView)findViewById(R.id.all_evaluations_tv);
        middle_evaluations_tv = (TextView)findViewById(R.id.middle_evaluations_tv);


        iv_user_icon_one = (CircleImageView)findViewById(R.id.iv_user_icon_one);
        iv_user_icon_two = (CircleImageView)findViewById(R.id.iv_user_icon_two);
        tv_user_name_one = (TextView)findViewById(R.id.tv_user_name_one);
        tv_user_name_two = (TextView)findViewById(R.id.tv_user_name_two);
        comments_tv_one = (TextView)findViewById(R.id.comments_tv_one);
        comments_tv_two = (TextView)findViewById(R.id.comments_tv_two);


        webView = findViewById(R.id.webview);
        String htmlurl="http://api.weboo.top/goods/goodsDetail?user_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJKV1QiLCJpYXQiOjE1NTkyMDUzOTYsImV4cCI6MzExODQxMDc5MiwiYXVkIjoiYXBpQmFzZSIsInN1YiI6IjExMTFhcGlCYXNlIiwiZGF0YSI6eyJkZXZpY2VfaWQiOiIxMjM0NTYifX0.Oi0XpCWmfZ3uzpNhx4T0LY5e7UsXWUfFcW_iw00fixM&goods_id=121136&device_id=123456&type=html";

        WebSettings webSettings = webView.getSettings();
        //设置WebView属性，能够执行Javascript脚本
        webSettings.setJavaScriptEnabled(true);
        //设置可以访问文件
        webSettings.setAllowFileAccess(true);
        //设置支持缩放
        webSettings.setBuiltInZoomControls(true);
        //加载需要显示的网页
        webView.loadUrl(htmlurl);
        //设置Web视图
        webView.setWebViewClient(new webViewClient ());

        //监听属性确定按钮
        /*rbAttributeSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(seledtedColor !=null){
                    if(seledtedSize !=null){
                        Toast.makeText(CommodityDetailsActivity.this,"选中尺寸:"+seledtedColor+"    选中尺寸"+seledtedSize,Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(CommodityDetailsActivity.this,"请选择尺寸",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(CommodityDetailsActivity.this,"请选择颜色",Toast.LENGTH_SHORT).show();
                }
            }
        });*/

    }


    //Web视图
    private class webViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    private void CommodityDetailsInfo() {
        GetBuilder builders = OkHttpUtils.get();
        builders.addParams("device_id","123456");
        builders.addParams("goods_id","121474");
        builders.addParams("user_token","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJKV1QiLCJpYXQiOjE1NTkyMDUzOTYsImV4cCI6MzExODQxMDc5MiwiYXVkIjoiYXBpQmFzZSIsInN1YiI6IjExMTFhcGlCYXNlIiwiZGF0YSI6eyJkZXZpY2VfaWQiOiIxMjM0NTYifX0.Oi0XpCWmfZ3uzpNhx4T0LY5e7UsXWUfFcW_iw00fixM");
        builders.url(BaseUrl.goodsDetailUrl).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int i) {

            }

            @Override
            public void onResponse(String s, int i) {
                Logger.d("response-22-产品详情>>:" + s);
/*
                String ss = "{" +
                        "\"com.pm.zse\": {" +
                        "\"check\": false," +
                        "\"own\": true," +
                        "\"complete\": true" +
                        "}," +
                        "\"com.om.cme\": {" +
                        "\"loaded\": false," +
                        "\"complete\": false," +
                        "\"com\": \"whoami\"" +
                        "}" +
                        "}";*/
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    Iterator<String> objs =  jsonObject.keys();
                    String key;
                    while (objs.hasNext()){
                        key = objs.next();
                        System.err.println("key: "+key);
                        JSONObject jo = jsonObject.getJSONObject(key);
                        Iterator<String> ks =  jo.keys();
                        String k;
                        while (ks.hasNext()){
                            k = ks.next();
                            System.err.println("keys: "+k);
                            String v = jo.getString(k);
                            System.err.println("values: "+v);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                goodsDetailBean = GsonQuick.toObject(s, goodsDetailBean.class);
                if(!"".equals(s)){
                    if("请求成功".equals(goodsDetailBean.getMsg())){
                       // Glide.with(context).load(goodsDetailBean.getData().getGoods_image()).into(viewPager);
                        trade_name_tv.setText(goodsDetailBean.getData().getGoods_name());//商品名
                        market_value_tv.setText("￥"+goodsDetailBean.getData().getGoods_marketprice());//市场价
                        discount_rate_tv.setText("折扣"+goodsDetailBean.getData().getGoods_discount()+"%");//折扣
                        primary_price_tv.setText("￥"+goodsDetailBean.getData().getGoods_price());//灰色价格
                        sale_num_tv.setText("销量  "+goodsDetailBean.getData().getGoods_salenum());//销量
                        color_tv.setText(goodsDetailBean.getData().getSpec_name().get(0));//选择颜色
                        size_tv.setText(goodsDetailBean.getData().getSpec_name().get(1));//选择尺寸

                        all_evaluations_tv.setText("全部("+goodsDetailBean.getData().getComment().getListCount().getAll()+")");
                        new_evaluations_tv.setText("最新("+goodsDetailBean.getData().getComment().getListCount().getAll()+")");
                        good_evaluations_tv.setText("好评("+goodsDetailBean.getData().getComment().getListCount().getGood()+")");
                        middle_evaluations_tv.setText("中评("+goodsDetailBean.getData().getComment().getListCount().getNormal()+")");
                        pic_evaluations_tv.setText("有图("+goodsDetailBean.getData().getComment().getListCount().getImage()+")");
                        add_evaluations_tv.setText("追加("+goodsDetailBean.getData().getComment().getListCount().getEval_again()+")");

                        Glide.with(context).load(url+goodsDetailBean.getData().getComment().getList().get(0).getMember_avatar()).into(iv_user_icon_one);
                        Glide.with(context).load(url+goodsDetailBean.getData().getComment().getList().get(1).getMember_avatar()).into(iv_user_icon_two);

                        tv_user_name_one.setText(goodsDetailBean.getData().getComment().getList().get(0).getNickname());
                        tv_user_name_two.setText(goodsDetailBean.getData().getComment().getList().get(1).getNickname());
                        comments_tv_one.setText(goodsDetailBean.getData().getComment().getList().get(0).getGeval_content());
                        comments_tv_two.setText(goodsDetailBean.getData().getComment().getList().get(1).getGeval_content());


                    }
                }

            }
        });

    }

    //字体颜色
    public void setRadioButtonTextColor(float percentage){
        if(Math.abs(percentage-currentPercentage)>=0.1f){
            for(int i=0;i<radioGroup.getChildCount();i++){
                RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
                radioButton.setTextColor(radioButton.isChecked()?getRadioCheckedAlphaColor(percentage):getRadioAlphaColor(percentage));
            }                                                       //#444444   灰色                            // #ffffff白色
            this.currentPercentage = percentage;
        }
    }

    public int getMeasureHeight(View view){
        int width = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int height = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        view.measure(width, height);
        return view.getMeasuredHeight();
    }

    /*头部背景颜色*/
    public int getAlphaColor(float f){
        return Color.argb((int) (f*255),0xfe,0x99,0x01);
    }

    public int getLayerAlphaColor(float f){
        return Color.argb((int) (f*255),0x09,0xc1,0xf4);
    }

    //#444444   灰色
    public int getRadioCheckedAlphaColor(float f){
        return Color.argb((int) (f*255),0x44,0x44,0x44);
    }
    // #ffffff白色
    public int getRadioAlphaColor(float f){
        return Color.argb((int) (f*255),0xFF,0xFF,0xFF);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.coupon_cartridge:
                chooseMediaType();
                break;
            case R.id.yanse_fenlei:
                yanseFenLei();
                break;
            case R.id.close_login_btn:
                dialog.dismiss();
                break;
            case R.id.btn_shopping_cart_rbAttribute_submit:
                if(seledtedColor !=null){
                    if(seledtedSize !=null){
                        Toast.makeText(CommodityDetailsActivity.this,"选中尺寸:"+seledtedColor+"    选中尺寸"+seledtedSize,Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(CommodityDetailsActivity.this,"请选择尺寸",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(CommodityDetailsActivity.this,"请选择颜色",Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.view_details:
                Intent viewdetail = new Intent(CommodityDetailsActivity.this, ViewDetailActivity.class);
                CommodityDetailsActivity.this.startActivity(viewdetail);
                break;
            case R.id.overlay_cover_buy://立即购买
                Intent paymentIntent = new Intent(CommodityDetailsActivity.this, OrderDetailsActivity.class);
                CommodityDetailsActivity.this.startActivity(paymentIntent);

                break;
        }
    }

    private void chooseMediaType() {
        dialog = new BottomSheetDialog(CommodityDetailsActivity.this);
        View bottomView = LayoutInflater.from(CommodityDetailsActivity.this).inflate(R.layout.coupon_cartridge, null);
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

    private void yanseFenLei() {
        dialog = new BottomSheetDialog(CommodityDetailsActivity.this);
        View bottomView = LayoutInflater.from(CommodityDetailsActivity.this).inflate(R.layout.selection_parametar, null);
        TextView close_login_btn = bottomView.findViewById(R.id.close_login_btn);

        AmountView mAmountView = bottomView.findViewById(R.id.amount_view);
        mAmountView.setGoods_storage(50);
        mAmountView.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(View view, int amount) {
                commodityNum = amount+"";
            }
        });
        //属性提交按钮
        Button rbAttributeSubmit = bottomView.findViewById(R.id.btn_shopping_cart_rbAttribute_submit);
        TextView attribute_tv_1 = bottomView.findViewById(R.id.attribute_tv_1);
        TextView attribute_tv_2 = bottomView.findViewById(R.id.attribute_tv_2);
        TextView attribute_tv_3 = bottomView.findViewById(R.id.attribute_tv_3);
        TextView attribute_tv_4 = bottomView.findViewById(R.id.attribute_tv_4);
        TextView attribute_tv_5 = bottomView.findViewById(R.id.attribute_tv_5);
        Logger.d("response-22-Spec_name属性目录>>:" + goodsDetailBean.getData().getSpec_name().size());
        if(goodsDetailBean.getData().getSpec_name().size()==2){
            attribute_tv_1.setText(goodsDetailBean.getData().getSpec_name().get(0));
            attribute_tv_2.setText(goodsDetailBean.getData().getSpec_name().get(1));
        }


        //数据
        GridView gvAttributeOne = bottomView.findViewById(R.id.attribute_gv_1);
        GridView gvAttributeTwo = bottomView.findViewById(R.id.attribute_gv_2);
        GridView gvAttributeThree = bottomView.findViewById(R.id.attribute_gv_3);
        GridView gvAttributeFour = bottomView.findViewById(R.id.attribute_gv_4);
        GridView gvAttributeFive = bottomView.findViewById(R.id.attribute_gv_5);


        //准备加载产品属性数据
        List<String> listOne = new ArrayList<>();
        List<String> listTwo = new ArrayList<>();
        List<String> listThree = new ArrayList<>();
        List<String> listFour = new ArrayList<>();
        List<String> listFive = new ArrayList<>();
        //List<Object> listSpecValue = new ArrayList<>();
        int j;
        Logger.d("response-22-Spec_value_ar数组长度>>:" + goodsDetailBean.getData().getSpec_value_ar().size());
        for( j = 0; j<goodsDetailBean.getData().getSpec_value_ar().size(); j++){
            //listSpecValue.add(goodsDetailBean.getData().getSpec_value_ar().get(j));
            int i=0;
            if(j-i==0){
                for( i = 0; i<goodsDetailBean.getData().getSpec_value_ar().get(j).size(); i++){
                    listOne.add(goodsDetailBean.getData().getSpec_value_ar().get(j).get(i).getVal());
                }

            }else if(j-i==1){
                for( i = 0; i<goodsDetailBean.getData().getSpec_value_ar().get(j).size(); i++){
                    listTwo.add(goodsDetailBean.getData().getSpec_value_ar().get(j).get(i).getVal());
                }
            }else if(j-i==2){
                for( i = 0; i<goodsDetailBean.getData().getSpec_value_ar().get(j).size(); i++){
                    listThree.add(goodsDetailBean.getData().getSpec_value_ar().get(j).get(i).getVal());
                }
            }else if(j-i==3){
                for( i = 0; i<goodsDetailBean.getData().getSpec_value_ar().get(j).size(); i++){
                    listFour.add(goodsDetailBean.getData().getSpec_value_ar().get(j).get(i).getVal());
                }
            }else if(j-i==4){
                for( i = 0; i<goodsDetailBean.getData().getSpec_value_ar().get(j).size(); i++){
                    listFive.add(goodsDetailBean.getData().getSpec_value_ar().get(j).get(i).getVal());
                }
            }
        }

        if(listOne.size()>0){
            attributeSizeAdapter = new ShoppingCartSizeAdapter(CommodityDetailsActivity.this,listOne,gvAttributeOne);
            gvAttributeOne.setAdapter(attributeSizeAdapter);
        }
        if(listTwo.size()>0){
            attributeColorAdapter = new ShoppingCartColorAdapter(CommodityDetailsActivity.this,listTwo,gvAttributeTwo);
            gvAttributeTwo.setAdapter(attributeColorAdapter);
        }
        if(listThree.size()>0){
            attributeColorAdapter = new ShoppingCartColorAdapter(CommodityDetailsActivity.this,listThree,gvAttributeThree);
            gvAttributeThree.setAdapter(attributeColorAdapter);
        }
        if(listFour.size()>0){
            attributeColorAdapter = new ShoppingCartColorAdapter(CommodityDetailsActivity.this,listFour,gvAttributeFour);
            gvAttributeFour.setAdapter(attributeColorAdapter);
        }
        if(listFive.size()>0){
            attributeColorAdapter = new ShoppingCartColorAdapter(CommodityDetailsActivity.this,listFive,gvAttributeFive);
            gvAttributeFive.setAdapter(attributeColorAdapter);
        }


        //TextView tv_take_photo = bottomView.findViewById(R.id.tv_take_photo);

        close_login_btn.setOnClickListener(this);
        rbAttributeSubmit.setOnClickListener(this);
//        tv_choose_video.setOnClickListener(this);
//        tv_choose_cancel.setOnClickListener(this);
//        tv_take_photo.setOnClickListener(this);


        dialog.setContentView(bottomView);
        dialog.show();

    }

    //注册广播接收者
    private void registerReceiver(){
        IntentFilter filter = new IntentFilter();
        filter.addAction(Constant.SHOPPINGCART_SIZEADAPTER_SEND_SHOPPINGCART_RECORD_SIZE);
        filter.addAction(Constant.SHOPPINGCART_COLORADAPTER_SEND_SHOPPINGCART_RECORD_COLOR);
        receiver = new InnerBroadcastReceiver();
        registerReceiver(receiver,filter);
    }

    class InnerBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(Constant.SHOPPINGCART_SIZEADAPTER_SEND_SHOPPINGCART_RECORD_SIZE.equals(action)){
                //当前选中的尺寸
                seledtedSize = intent.getStringExtra("currentPositionSize");
            }else if(Constant.SHOPPINGCART_COLORADAPTER_SEND_SHOPPINGCART_RECORD_COLOR.equals(action)){
                //当前选中的颜色
                seledtedColor = intent.getStringExtra("currentPositionColor");
            }
        }
    }



}
