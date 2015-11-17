package com.wuzeng;

import java.util.ArrayList;
import java.util.List;

import com.example.wuzeng_app.R;
import com.example.wuzeng_app.base.BaseActivity;
import com.example.wuzeng_app.utils.UIHelper;
import com.wuzeng.Utils.WuzengSharedPre;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class WelcomeActivity extends BaseActivity {
	private ViewPager main_welcome_message;
	private List<View> list;
	private Button btn_gui3_bottom;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcomemain);
		init();
		
	}
	private void init() {
		// TODO Auto-generated method stub
		View inflate = View.inflate(this, R.layout.welcome_gui1, null);
		View inflate2 = View.inflate(this, R.layout.welcome_gui2, null);
		View inflate3 = View.inflate(this, R.layout.welcome_gui3, null);
		list=new ArrayList<>();
		list.add(inflate);
		list.add(inflate2);
		list.add(inflate3);
		main_welcome_message=(ViewPager)findViewById(R.id.main_welcome_message);
		btn_gui3_bottom=(Button)inflate3.findViewById(R.id.btn_gui3_bottom);
		btn_gui3_bottom.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				WuzengSharedPre.getIntence(mContext).SetFirstUserMyWz(true);
				UIHelper.showMainAc(mContext);
				finish();
			}
		});
		
		main_welcome_message.setAdapter(new MyViewPager());
	}
	
	class MyViewPager extends PagerAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0==arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			
			container.removeView(list.get(position));
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(list.get(position));// 添加页卡
			return list.get(position);
		}
		
	}
}
