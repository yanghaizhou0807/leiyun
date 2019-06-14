package com.example.admin.leiyun_ic.Details.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.RadioButton;

import com.example.admin.leiyun_ic.R;
import com.example.admin.leiyun_ic.utils.Constant;

import java.util.List;

public class ShoppingCartSizeAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<String> listSize;
    private Context context;
    private GridView gridView;
    private int dimensionSize;


    public ShoppingCartSizeAdapter(Context context, List<String> listSize, GridView gridView){
        this.context = context;
        this.listSize = listSize;
        this.gridView = gridView;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        dimensionSize = listSize.size();
        return listSize.size();
    }

    @Override
    public String getItem(int i) {
        return listSize.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        String size = getItem(i);
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_shoppingcart_attribute,null);
            holder.rbAttribute = (RadioButton) convertView.findViewById(R.id.rb_attribute);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.rbAttribute.setText(size);
        Log.d("hxl","color=="+size);
        holder.rbAttribute.setTag("rbAttribute"+i);

        holder.rbAttribute.setOnClickListener(new MyOnclickListerner(i));

        return convertView;
    }
    class ViewHolder{
        RadioButton rbAttribute;
    }

    class MyOnclickListerner implements View.OnClickListener {
        private int currentPositionSize;
        public MyOnclickListerner(int i) {
            currentPositionSize = i;
        }
        @Override
        public void onClick(View view) {
            RadioButton rbAttribute = (RadioButton) gridView.findViewWithTag("rbAttribute" + currentPositionSize);
            for(int i=0;i<dimensionSize;i++){
                RadioButton rbAttributeAll = (RadioButton) gridView.findViewWithTag("rbAttribute" + i);
                rbAttributeAll.setChecked(false);
            }
            rbAttribute.setChecked(true);
            sendBrodcastReceiver(rbAttribute.getText().toString());
            // Toast.makeText(context,rbAttribute.getText(),Toast.LENGTH_SHORT).show();
        }
    }
    //发送广播给详情页面记录选中的尺寸
    private void sendBrodcastReceiver(String str){
        Intent intent = new Intent(Constant.SHOPPINGCART_SIZEADAPTER_SEND_SHOPPINGCART_RECORD_SIZE);
        intent.putExtra("currentPositionSize",str);
        context.sendBroadcast(intent);
    }
}
