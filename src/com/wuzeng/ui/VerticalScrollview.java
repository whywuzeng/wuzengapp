package com.wuzeng.ui;


import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class VerticalScrollview extends ScrollView {
	private int xlast;
	private int ylast;
	private int xdistance;
	private int ydistance;

	public VerticalScrollview(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public VerticalScrollview(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public VerticalScrollview(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			xlast = (int) ev.getX();
			ylast = (int) ev.getY();

			break;
		case MotionEvent.ACTION_MOVE:
			int cur_x = (int) ev.getX();
			int cur_y = (int) ev.getY();
			xdistance = Math.abs(cur_x - xlast);
			ydistance = Math.abs(cur_y - ylast);
			if (xdistance > ydistance) {
				return false;
			}
			// distance
			break;
		case MotionEvent.ACTION_UP:

			break;
		default:
			break;
		}
		return super.onInterceptTouchEvent(ev);
	}

}
