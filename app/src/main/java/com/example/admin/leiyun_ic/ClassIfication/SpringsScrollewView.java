package com.example.admin.leiyun_ic.ClassIfication;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;

public class SpringsScrollewView extends ScrollView {

	// �϶��ľ��� size = 4 ����˼ ֻ�����϶���Ļ��1/4
	private static final int size = 4;
	private View inner;
	private float y;
	private Rect normal = new Rect();
	private OnSlideListenerInterface onSlideListener;

	public void setOnSlideListener(OnSlideListenerInterface onSlideListener){
		this.onSlideListener = onSlideListener;
	}

	public SpringsScrollewView(Context context) {
		super(context);
	}

	public SpringsScrollewView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onFinishInflate() {
		if (getChildCount() > 0) {
			inner = getChildAt(0);
		}
		super.onFinishInflate();

	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		if (inner == null) {
			return super.onTouchEvent(ev);
		} else {
			commOnTouchEvent(ev);
		}
		return super.onTouchEvent(ev);
	}

	public void commOnTouchEvent(MotionEvent ev) {
		int action = ev.getAction();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			y = ev.getY();
			break;
		case MotionEvent.ACTION_UP:
			if (isNeedAnimation()) {
				 Log.i("mlguitar", y+"");
				animation();
				if(onSlideListener != null){
					onSlideListener.OnSlideListener(y);
				}
			}
			break;
		case MotionEvent.ACTION_MOVE:
			final float preY = y;
			Log.i("yyyyyyy=",y+"");
			float nowY = ev.getY();
			Log.i("nowY=",nowY+"");
			/**
			 * size=4 ��ʾ �϶��ľ���Ϊ��Ļ�ĸ߶ȵ�1/4
			 */
			int deltaY = (int) (preY - nowY) / size;
			Log.i("deltaY=",deltaY+"");
			// scrollBy(0, deltaY);

			y = nowY;

			Log.i("1111",y+"");
			// �����������ϻ�������ʱ�Ͳ����ٹ�������ʱ�ƶ�����
			if (isNeedMove()) {
				if (normal.isEmpty()) {
					// ������Ĳ���λ��
					normal.set(inner.getLeft(), inner.getTop(),
							inner.getRight(), inner.getBottom());
					return;
				}
				int yy = inner.getTop() - deltaY;

				// �ƶ�����
				inner.layout(inner.getLeft(), yy, inner.getRight(),
						inner.getBottom() - deltaY);
			}
			break;
		default:
			break;
		}
	}

	// ���������ƶ�

	public void animation() {
		// �����ƶ�����
		TranslateAnimation ta = new TranslateAnimation(0, 0, inner.getTop(),
				normal.top);
		ta.setDuration(200);
		inner.startAnimation(ta);
		// ���ûص���Ĳ���λ��
		inner.layout(normal.left, normal.top, normal.right, normal.bottom);
		normal.setEmpty();
	}

	// �Ƿ���Ҫ��������
	public boolean isNeedAnimation() {
		return !normal.isEmpty();
	}

	// �Ƿ���Ҫ�ƶ�����
	public boolean isNeedMove() {
		int offset = inner.getMeasuredHeight() - getHeight();
		int scrollY = getScrollY();
		return scrollY == 0 || scrollY == offset;
	}

	public interface OnSlideListenerInterface{
		void OnSlideListener(float coordinate);
	}
}
