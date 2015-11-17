package com.wuzeng.ui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MViewPager extends ViewPager {

	private static boolean IsScorell = false;

	public MViewPager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public MViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean canScroll(View arg0, boolean arg1, int arg2, int arg3,
			int arg4) {
		// TODO Auto-generated method stub
		return IsScorell;
	}

	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		// TODO Auto-generated method stub
		if (IsScorell) {
			return super.onTouchEvent(arg0);
		} else {
			return false;
		}

	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		// TODO Auto-generated method stub
		if(IsScorell){
		return super.onInterceptTouchEvent(arg0);
		}else{
			return false;
		}
	}
	
	

}
