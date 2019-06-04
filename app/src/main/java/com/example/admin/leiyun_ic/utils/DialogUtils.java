package com.example.admin.leiyun_ic.utils;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.leiyun_ic.Base.BaseApplication;
import com.example.admin.leiyun_ic.R;


public class DialogUtils {
	public static boolean isPromot=false;
	public static void showToast(Context context, String msg) {
		View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_swipe, null);
		TextView swipePromotTv = (TextView) dialogView.findViewById(R.id.swipe_promot_tv);
		swipePromotTv.setText(msg);
		Toast toast=new Toast(context);
		toast.setView(dialogView);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.show();
	}

	/*public static void showDialog(final Context context,final BaseApplication myApplication) {
		AlertDialog dialog;
		final String simpleName = context.getClass().getSimpleName();
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle(null);
		builder.setMessage(context.getResources().getString(R.string.logout_strg));
		builder.setPositiveButton(context.getResources().getString(R.string.sure_strg),
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.dismiss();
						if ("AppCenterActy".equals(simpleName)) {
							AppCenterActivity appActy = (AppCenterActivity) context;
							dialog.dismiss();
							appActy.finish();
						} else if ("CommunicationActivity".equals(simpleName))  {
                                   //单聊
							CommunicationActivity accountActy = (CommunicationActivity) context;
							dialog.dismiss();
							accountActy.finish();
						}else if ("GroupChatActivity".equals(simpleName)) {
							GroupChatActivity accountActy = (GroupChatActivity) context;
							dialog.dismiss();
							accountActy.finish();
						}else if("MailListActivity".equals(simpleName)){
							MailListActivity accountActy = (MailListActivity) context;
							dialog.dismiss();
							accountActy.finish();

						}else if("app_personal".equals(simpleName)){
							MoreInfoActivity accountActy = (MoreInfoActivity) context;
							dialog.dismiss();
							accountActy.finish();

						}else {
							PeanutsHomeActivity acitivty = (PeanutsHomeActivity) DataStore.getMap().get("homeActivity");
							acitivty.finish();
						}
					}
				});
		builder.setNegativeButton(
				context.getResources().getString(R.string.cancle_strg),
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}
				});
		dialog = builder.create();
		dialog.setCanceledOnTouchOutside(false);
		dialog.show();
	}*/


	    //显示进度条
		public static ProgressDialog showProDialog(Context context) {
			ProgressDialog proDialog = new ProgressDialog(context);
			proDialog.setMessage(context.getResources().getString(R.string.load_data_str));
			proDialog.setCanceledOnTouchOutside(false);
			proDialog.setCancelable(false);
			return proDialog;
		}
		//显示进度条
		public static ProgressDialog showVersionProDialog(Context context) {
				ProgressDialog proDialog = new ProgressDialog(context);
				proDialog.setMessage("版本检测中，请稍候...");
				proDialog.setCanceledOnTouchOutside(false);
				proDialog.setCancelable(false);
				return proDialog;
			}
		
		public static void showMsgDialog(Context context,String msgInfo){
				AlertDialog.Builder builder = new AlertDialog.Builder(
						context);
				builder.setIcon(android.R.drawable.ic_dialog_alert);
				builder.setTitle("友情提示");
				builder.setMessage(msgInfo);
				builder.setPositiveButton(
						"确定",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(
									DialogInterface dialog,
									int which) {
								dialog.cancel();
							}
						});
				builder.create();
			
				builder.setCancelable(false);
				builder.show();
				
			}


			
	/*		//设置系统提现类型
		public static void showSetType(final Context context){
				AlertDialog.Builder builder = new AlertDialog.Builder(
						context);
				builder.setIcon(android.R.drawable.ic_dialog_alert);
				builder.setTitle("友情提示");
				builder.setMessage(context.getResources().getString(R.string.type_promot));
				builder.setPositiveButton(
						"是",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(
									DialogInterface dialog,
									int which) {
								dialog.cancel();
								Intent intentMethod=new Intent(context,MethodOfPayActy.class);
								context.startActivity(intentMethod);
							}
						});
				
				builder.setNegativeButton("否",new DialogInterface.OnClickListener() {
							@Override
							public void onClick(
									DialogInterface dialog,
									int which) {
								isPromot = true;
								dialog.cancel();
							}
						});
				builder.create();
				builder.setCancelable(false);
				builder.show();
			}	*/
		
		
		

}
