package com.example.wuzeng_app;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wuzeng_app.utils.AppManager;
import com.wuzeng.Classicfragment.ClassicFragment;
import com.wuzeng.Homefragment.HomeFragment;
import com.wuzeng.HouseKeeperfragment.HouseKeeperFragment;
import com.wuzeng.MyWuZengfragment.MyWuZengFragment;
import com.wuzeng.Shoppingfragment.ShoppingFragment;

public class MainActivity extends FragmentActivity {

	private HomeFragment mHomeFragment;
	private HouseKeeperFragment mHouseKeeperFragment;
	private MyWuZengFragment myWuZengFragment;
	private ShoppingFragment mShoppingFragment;
	private ClassicFragment mClassicFragment;

	private ImageView homeiv, houseiv, mwuzengiv, shoppiv, classiciv;
	private TextView hometv, housetv, mwuzengtv, shopptv, classictv;
	private View mHome, mHousekeeper, mWuZeng, mShopping, mClassic;

	private ViewPager mainPager;
	private FragmentManager mFragmentManager;
	private List<Fragment> fragments;
	private long secondetime;
	private long spacetime;

	public final static int Homeindex = 0, Classicindex = 1, Shoppindex = 2,
			Houseindex = 3, WuZengindex = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initview();

		initbottomview();
	}

	private void initview() {
		// TODO Auto-generated method stub
		AppManager.getAppManager().addActivity(this);
		
		mainPager = (ViewPager) findViewById(R.id.Mview);
		mFragmentManager = getSupportFragmentManager();
		mHomeFragment = new HomeFragment();
		mHouseKeeperFragment = new HouseKeeperFragment();
		myWuZengFragment = new MyWuZengFragment();
		mShoppingFragment = new ShoppingFragment();
		mClassicFragment = new ClassicFragment();

		fragments = new ArrayList<Fragment>();

		fragments.add(mHomeFragment);
		fragments.add(mClassicFragment);
		fragments.add(mShoppingFragment);
		fragments.add(mHouseKeeperFragment);
		fragments.add(myWuZengFragment);

		mainPager.setAdapter(new MymainAdapter(mFragmentManager));
		mainPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				updateBottomview(arg0);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
		mainPager.setCurrentItem(0);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(keyCode==KeyEvent.KEYCODE_BACK){
			
			if(mainPager.getCurrentItem()!=0){
				mainPager.setCurrentItem(0);
				return false;
			}else {
				long currentTimeMillis = System.currentTimeMillis();
				spacetime=currentTimeMillis-secondetime;
				if(spacetime>2000){
					secondetime=currentTimeMillis;
				Toast.makeText(MainActivity.this, "再按一次你就退出吴增控股了", 0).show();
				return false;
				}else{
					AppManager.getAppManager().AppExit(this);
				}
				
			}
		}
		
		return super.onKeyDown(keyCode, event);
	}
	
	class MymainAdapter extends FragmentStatePagerAdapter {

		public MymainAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			return fragments.get(arg0);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return fragments == null ? 0 : fragments.size();
		}

	}

	/**
	 * 
	 * @param index
	 */

	private void updateBottomview(int index) {
		switch (index) {
		case 0:
			selectHome(true);
			selectClassic(false);
			selectShopping(false);
			selectHouseKeeper(false);
			selectMyWuZeng(false);
			break;
		case 1:
			selectHome(false);
			selectClassic(true);
			selectShopping(false);
			selectHouseKeeper(false);
			selectMyWuZeng(false);

			break;
		case 2:
			selectHome(false);
			selectClassic(false);
			selectShopping(true);
			selectHouseKeeper(false);
			selectMyWuZeng(false);

			break;
		case 3:

			selectHome(false);
			selectClassic(false);
			selectShopping(false);
			selectHouseKeeper(true);
			selectMyWuZeng(false);
			break;
		case 4:
			selectHome(false);
			selectClassic(false);
			selectShopping(false);
			selectHouseKeeper(false);
			selectMyWuZeng(true);
			break;
		}
	}

	private void selectHome(boolean isselect) {
		mHome.setSelected(isselect);
	}

	private void selectClassic(boolean isselect) {
		mClassic.setSelected(isselect);
	}

	private void selectShopping(boolean isselect) {
		mShopping.setSelected(isselect);
	}

	private void selectHouseKeeper(boolean isselect) {
		mHousekeeper.setSelected(isselect);
	}

	private void selectMyWuZeng(boolean isselect) {
		mWuZeng.setSelected(isselect);
	}

	private void initbottomview() {
		// TODO Auto-generated method stub
		mHome = (View) findViewById(R.id.first_page_item);
		mClassic = (View) findViewById(R.id.second_page_item);
		mShopping = (View) findViewById(R.id.third_page_item);
		mHousekeeper = (View) findViewById(R.id.fourth_page_item);
		mWuZeng = (View) findViewById(R.id.fifth_page_item);

		BottomClickListener mBottomClickListener = new BottomClickListener();

		mHome.setOnClickListener(mBottomClickListener);
		mClassic.setOnClickListener(mBottomClickListener);
		mShopping.setOnClickListener(mBottomClickListener);
		mHousekeeper.setOnClickListener(mBottomClickListener);
		mWuZeng.setOnClickListener(mBottomClickListener);

	}

	private void removeview(View forView) {
	
		  ViewGroup p = (ViewGroup) forView.getParent(); 
		    if (p != null) { 
		        p.removeAllViewsInLayout(); 
		    }
	}

	class BottomClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			View forView;
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.first_page_item:
//				 forView = mHomeFragment.getForView();
//				removeview(forView); 
				mainPager.setCurrentItem(Homeindex);
				break;
			case R.id.second_page_item:
//				 forView = mClassicFragment.getForView();
//					removeview(forView); 
				mainPager.setCurrentItem(Classicindex);
				mClassicFragment.backToCategory();
				mClassicFragment.backToOrigin();
				
				break;
			case R.id.third_page_item:
//				 forView = mShoppingFragment.getForView();
//					removeview(forView); 
				mainPager.setCurrentItem(Shoppindex);
				break;
			case R.id.fourth_page_item:
//				 forView = mHouseKeeperFragment.getForView();
//				removeview(forView); 
				mainPager.setCurrentItem(Houseindex);
				break;
			case R.id.fifth_page_item:
//				 forView = myWuZengFragment.getForView();
//					removeview(forView); 
				mainPager.setCurrentItem(WuZengindex);
				break;

			}
		}

	}
}
