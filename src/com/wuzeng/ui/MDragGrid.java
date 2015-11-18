package com.wuzeng.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MDragGrid extends GridView {

	private WindowManager manager;
	private WindowManager.LayoutParams layoutParams;
	private float pre_downx;
	private float pre_downy;
	private Bitmap drawingCache;
	private Drawable mDrawable;
	private boolean isDran;
	private ImageView iv;
	
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
			setlistenerfor(ev);
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
				Log.i("tag", "111111111111111111");
				
				if (view instanceof LinearLayout) {
					ImageView childAt = (ImageView)((LinearLayout) view).getChildAt(0);
					 mDrawable = childAt.getDrawable();
					Bitmap drawingCache2 = childAt.getDrawingCache();
					
//					drawingCache = ((LinearLayout) view).getChildAt(position).getDrawingCache();
					 
					getWindowManage(x2, y2, mDrawable);

				}
				return false;
			}
		});
	}

	public void getWindowManage(float x, float y, Drawable bitmap) {
		manager = (WindowManager) getContext().getSystemService(
				Context.WINDOW_SERVICE);
		layoutParams = new WindowManager.LayoutParams();
		layoutParams.gravity = Gravity.TOP | Gravity.LEFT;
		Rect bounds = bitmap.getBounds();
		
		layoutParams.width = Math.abs(bounds.width());
		layoutParams.height = Math.abs(bounds.height());
		layoutParams.x = (int) x;
		layoutParams.y = (int) y;
		 iv = new ImageView(getContext());

		this.layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
				| WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
				| WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
				| WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
		this.layoutParams.format = PixelFormat.TRANSLUCENT;
		this.layoutParams.windowAnimations = 0;

		iv.setImageDrawable(bitmap);
		isDran=true;
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
			if(isDran){
			onDrag( cur_x, cur_y);
			}
			break;

		case MotionEvent.ACTION_UP:
			isDran=false;
			break;

		default:
			break;
		}
		return super.onTouchEvent(ev);
	}
	
	/** 在拖动的情况 */
	private void onDrag( float rawx , float rawy) {
		if(mDrawable!=null&&iv!=null){
		layoutParams.alpha = 0.6f;
//			windowParams.x = x - win_view_x + viewX;
//			windowParams.y = y +  win_view_y + viewY;
//			windowParams.x = rawx - itemWidth / 2;
//			windowParams.y = rawy - itemHeight / 2;
		layoutParams.x = (int) rawx ;
		layoutParams.y = (int) rawy ;
//		ImageView i=new ImageView(getContext());
//		i.setImageDrawable(mDrawable);
		manager.updateViewLayout(iv, layoutParams);
		}
	}

}
