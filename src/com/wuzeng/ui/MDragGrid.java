package com.wuzeng.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

public class MDragGrid extends GridView {

	private WindowManager manager;
	private WindowManager.LayoutParams layoutParams;
	private float pre_downx;
	private float pre_downy;

	public MDragGrid(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public MDragGrid(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public MDragGrid(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			pre_downx = ev.getX();
			pre_downy = ev.getY();

			break;

		default:
			break;
		}
		return super.onInterceptTouchEvent(ev);
	}

	public void setlistenerfor(final MotionEvent ev) {
		setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				float x2 = ev.getX();
				float y2 = ev.getY();

				if (view instanceof ImageView) {
					Bitmap drawingCache = view.getDrawingCache();
					getWindowManage(x2, y2, drawingCache);

				}
				return false;
			}
		});
	}

	public void getWindowManage(float x, float y, Bitmap bitmap) {
		manager = (WindowManager) getContext().getSystemService(
				Context.WINDOW_SERVICE);
		layoutParams = new WindowManager.LayoutParams();
		layoutParams.gravity = Gravity.TOP | Gravity.LEFT;
		layoutParams.width = bitmap.getWidth();
		layoutParams.height = bitmap.getHeight();
		layoutParams.x = (int) x;
		layoutParams.y = (int) y;
		ImageView iv = new ImageView(getContext());

		this.layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
				| WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
				| WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
				| WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
		this.layoutParams.format = PixelFormat.TRANSLUCENT;
		this.layoutParams.windowAnimations = 0;

		iv.setImageBitmap(bitmap);
		manager.addView(iv, layoutParams);
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			
			
			break;

		case MotionEvent.ACTION_MOVE:
			float cur_x = ev.getX();
			float cur_y = ev.getY();
			
			float distancex=cur_x-pre_downx;

			break;

		case MotionEvent.ACTION_UP:

			break;

		default:
			break;
		}
		return super.onTouchEvent(ev);
	}

}
