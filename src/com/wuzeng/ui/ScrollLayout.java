package com.wuzeng.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Scroller;

public class ScrollLayout extends ViewGroup {

	private Scroller mScroller;
	private static String tag = "ScrollLayout";
	private VelocityTracker mTracker;
	private final static float MOVE_FOR_X = 200f;

	public ScrollLayout(Context context) {
		this(context, null);
		// super(context);
		// TODO Auto-generated constructor stub
		Log.i(tag, "ScrollLayout(Context context,-yi 个--- ");
	}

	@Override
	public void computeScroll() {
		// TODO Auto-generated method stub
		if (mScroller.computeScrollOffset()) {
			this.scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
			this.postInvalidate();
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if (mTracker == null) {
			mTracker = VelocityTracker.obtain();
			mTracker.addMovement(event);
		}
		float xVelocity = mTracker.getXVelocity();

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:

			break;

		case MotionEvent.ACTION_MOVE:

			break;
		case MotionEvent.ACTION_UP:
			mTracker.computeCurrentVelocity(1000);
			final VelocityTracker mtrTracker = mTracker;
			float xVelocity2 = mtrTracker.getXVelocity();
			if (xVelocity2 > MOVE_FOR_X) {
				//这里滚动  想做
				
				this.scrollBy(this.getWidth(), 0);
			} else if (xVelocity2 < -MOVE_FOR_X) {
				//这里滚动 向右
				this.scrollBy(-(this.getWidth()), 0);
			}

			break;
		default:
			break;
		}

		return super.onTouchEvent(event);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int childCount = getChildCount();
		for (int i = 0; i < childCount; i++) {
			getChildAt(i).measure(widthMeasureSpec, heightMeasureSpec);
		}

		Log.i(tag, "onMeasure-多次还是一次----");
	}

	public ScrollLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		Log.i(tag, "ScrollLayout(Context context,--三个-- ");
		mScroller = new Scroller(context);
//		setButton(context);
	}

	public ScrollLayout(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		// super(context, attrs);
		// TODO Auto-generated constructor stub
		Log.i(tag, "ScrollLayout(Context context,-两个--- ");

	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		// super.onDraw(canvas);

	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		int childCount = getChildCount();
		int top = t; // 每一个都叠起来 不知道可以不
		if (changed) {
			for (int i = 0; i < childCount; i++) {
				getChildAt(i).layout(l, top, r, b);
				top += (t + 2);
			}
		}
	}

	public void HuaDirection() {
		// scrollBy(50, 50);
		mScroller.startScroll(100, 0, 300, 0, 1000);

		invalidate();
	}

	public void setButton(Context context) {
		Button mButton = new Button(context);
		LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT);
		mButton.setLayoutParams(layoutParams);
		mButton.setHeight(40);
		mButton.setText("点击我滑动");
		mButton.setTextColor(Color.BLACK);
		mButton.setX(100);
		this.addView(mButton);

		mButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// 点击的时候我们就滑动
				HuaDirection();
			}
		});
	}

}
