package com.example.admin.leiyun_ic.Details;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.admin.leiyun_ic.Base.BaseActivity;
import com.example.admin.leiyun_ic.HomePage.HomePageActivity;
import com.example.admin.leiyun_ic.R;

import java.util.ArrayList;

import idea.analyzesystem.scrollview.IdeaScrollView;
import idea.analyzesystem.scrollview.IdeaViewPager;
import qiu.niorgai.StatusBarCompat;

public class CommodityDetailsActivity extends BaseActivity implements View.OnClickListener {

    private IdeaViewPager viewPager;
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


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_acty);
        StatusBarCompat.translucentStatusBar(this);
        header = (LinearLayout)findViewById(R.id.header);
        headerParent = (LinearLayout)findViewById(R.id.headerParent);
       // icon = (ImageView)findViewById(R.id.icon);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        ideaScrollView = (IdeaScrollView)findViewById(R.id.ideaScrollView);
        viewPager = (IdeaViewPager)findViewById(R.id.viewPager);
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
        TextView close_login_btn = bottomView.findViewById(R.id.close_login_btn);//
        /*TextView tv_choose_video = bottomView.findViewById(R.id.tv_choose_video);//
        TextView tv_choose_cancel = bottomView.findViewById(R.id.tv_cancel);
        TextView tv_take_photo = bottomView.findViewById(R.id.tv_take_photo);//*/

        close_login_btn.setOnClickListener(this);
//        tv_choose_video.setOnClickListener(this);
//        tv_choose_cancel.setOnClickListener(this);
//        tv_take_photo.setOnClickListener(this);


        dialog.setContentView(bottomView);
        dialog.show();

    }


}
