package com.example.wuzeng_app.base;

import com.example.wuzeng_app.utils.AppManager;
import com.example.wuzeng_app.utils.LogUtil;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

public class BaseActivity extends Activity {
	private final static String TAG = "BaseActivity";
	public Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		AppManager.getAppManager().addActivity(this);
		mContext = this;

	}

	@Override
	public void setContentView(int layoutResID) {
		// TODO Auto-generated method stub
		super.setContentView(layoutResID);
		onFindViews();
		onSetListener();
		onLoadData();

	}

	private void onLoadData() {
		// TODO Auto-generated method stub
		LogUtil.i(TAG, "onLoadData	---->>>");

	}

	private void onSetListener() {
		// TODO Auto-generated method stub
		LogUtil.i(TAG, "onSetListener	---->>>");
	}

	private void onFindViews() {
		// TODO Auto-generated method stub
		LogUtil.i(TAG, "onFindViews	---->>>");
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if(event.getAction()==MotionEvent.ACTION_DOWN){
			if(getCurrentFocus()!=null&&getCurrentFocus().getWindowToken()!=null){
				InputMethodManager manager=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				manager.hideSoftInputFromInputMethod(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
			}
		}
		
		return super.onTouchEvent(event);
		
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
	}
}
