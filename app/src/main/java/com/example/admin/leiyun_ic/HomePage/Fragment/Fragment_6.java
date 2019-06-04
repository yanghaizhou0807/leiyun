package com.example.admin.leiyun_ic.HomePage.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.leiyun_ic.R;

public class Fragment_6 extends Fragment {
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_episode_sixth, container,false);
        /*textView = (TextView) view.findViewById(R.id.text);
        textView.setText("这是第5个Fragment");*/
        return view;

    }
}
