package com.wuzeng.Utils;

import android.R.bool;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class WuzengSharedPre {

	private static WuzengSharedPre pre;

	public static WuzengSharedPre getIntence(Context context) {
		if (pre == null) {
			pre = new WuzengSharedPre(context);
		}
		return pre;
	}

	private SharedPreferences preferences;

	private WuzengSharedPre() {
	};

	public WuzengSharedPre(Context context) {
		preferences = context.getSharedPreferences("wuzeng_tmep",
				Context.MODE_PRIVATE);

	}

	public void SetFirstUserMyWz(boolean isfirst) {
		Editor edit = preferences.edit();
		edit.putBoolean("IsFirst", isfirst);
		edit.commit();
	}
	
	public boolean getFirstUserMyWz() {
		return preferences.getBoolean("IsFirst", false);
	}
}
