package com.example.admin.leiyun_ic;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.admin.leiyun_ic.ClassIfication.ClassIficationActivity;
import com.example.admin.leiyun_ic.HomePage.HomePageActivity;
import com.example.admin.leiyun_ic.MyMall.MyMallActivity;
import com.example.admin.leiyun_ic.Search.SearchActivity;
import com.example.admin.leiyun_ic.ShoppingCart.ShoppingCartActivity;
import com.example.admin.leiyun_ic.utils.MessageEvent;

import de.greenrobot.event.EventBus;

public class MainActivity extends TabActivity implements View.OnClickListener {

    private Button button;
    private TextView textview;
    private TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_main);//
        EventBus.getDefault().register(this);
        initView();
    }

    private void initView() {

        tabHost = this.getTabHost();

        tabHost.addTab(tabHost.newTabSpec("app_communicate")
                .setIndicator("app_communicate")
                .setContent(new Intent(this, HomePageActivity.class)));
        Intent intent = new Intent(MainActivity.this, ClassIficationActivity.class);
        // intent.putExtra("type", GroupInfo.publicGroup);


        tabHost.addTab(tabHost.newTabSpec("app_coordination")
                .setIndicator("app_coordination")
                .setContent(intent));
        tabHost.addTab(tabHost.newTabSpec("app_center")
                .setIndicator("app_center")
                .setContent(new Intent(this, SearchActivity.class)));
        tabHost.addTab(tabHost.newTabSpec("app_mail_list")
                .setIndicator("app_mail_list")
                .setContent(new Intent(this, ShoppingCartActivity.class)));
        tabHost.addTab(tabHost.newTabSpec("app_personal")
                .setIndicator("app_personal")
                .setContent(new Intent(this, MyMallActivity.class)));
        tabHost.setCurrentTabByTag("app_center");
        tabHost.setCurrentTab(0);
        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.main_rg);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId) {
                    case R.id.rb_communication:
                        tabHost.setCurrentTab(0);
                        break;
                    case R.id.rb_groupchat:
                        tabHost.setCurrentTab(1);
                        break;
                    case R.id.rb_appcenter:
                        tabHost.setCurrentTab(2);
                        break;
                    case R.id.rb_maillist:
                        tabHost.setCurrentTab(3);
                        break;
                    case R.id.rb_more:
                        tabHost.setCurrentTab(4);
                        break;

                }
            }
        });

        /*textview = (TextView)findViewById(R.id.textview);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,testActivity.class);
                startActivity(intent);
            }
        });*/

    }

    //@Subscribe
    public void onEvent(MessageEvent messageEvent){
        textview.setText(messageEvent.getMessage());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {

    }
}
