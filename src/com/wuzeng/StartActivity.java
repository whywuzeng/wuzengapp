package com.wuzeng;

import java.io.File;

import com.example.wuzeng_app.R;
import com.example.wuzeng_app.base.BaseActivity;
import com.example.wuzeng_app.utils.UIHelper;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.wuzeng.Utils.WuzengSharedPre;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class StartActivity extends BaseActivity {
	private ImageView welcome;
	private TextView version;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);
		welcome=(ImageView)findViewById(R.id.welcome);
		File file = StorageUtils.getOwnCacheDirectory(mContext, "/wuzeng/cache/welcome");
		if(file.listFiles().length>0){
//			Bitmap bitmap = BitmapFactory.decodeFile(file.listFiles()[0].getPath());
//			welcome.setImageBitmap(bitmap);
			Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.welcome);
			welcome.setImageBitmap(bitmap);
		}else{
			Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.welcome);
			welcome.setImageBitmap(bitmap);
		}
		version=(TextView)findViewById(R.id.version);
		
		version.setText("V"+getVersionname());
		
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(WuzengSharedPre.getIntence(mContext).getFirstUserMyWz()){
					UIHelper.showMainAc(mContext);
					Log.i("tag", "----------------------------");
					Toast.makeText(mContext, "---------------------", 0).show();
					finish();
				}else {
					Log.i("tag", "----------------------------");
					Toast.makeText(mContext, "---------------------", 0).show();
					UIHelper.ShowWelcomeActivity(mContext);
					finish();
				}
			}
		}, 3000);
	}
	
	private String getVersionname() {
		// TODO Auto-generated method stub
		PackageManager packageManager = getPackageManager();
		PackageInfo packageInfo;
		try {
			packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
			return packageInfo.versionName;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
