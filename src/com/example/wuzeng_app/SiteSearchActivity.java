package com.example.wuzeng_app;

import com.custom.vg.list.CustomAdapter;
import com.custom.vg.list.CustomListView;
import com.wuzeng.adapter.search_history_Adapter;
import com.wuzeng.adapter.search_history_Adapter.gocallback;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SiteSearchActivity extends Activity implements gocallback{
	
	private CustomListView mCustomListView;
	private search_history_Adapter adapter;
//	private gocallback mgocallback;
	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.site_search);
			initview();
		}

		private void initview() {
			// TODO Auto-generated method stub
			mCustomListView=(CustomListView)findViewById(R.id.clv_search_story);
			mCustomListView.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
				Toast.makeText(SiteSearchActivity.this, "1", 0).show();
				}
			});
			adapter=new search_history_Adapter(getApplicationContext());
			mCustomListView.setAdapter(adapter);
			adapter.setgocallback(this);
		}

		@Override
		public void setListener(int position) {
			// TODO Auto-generated method stub
			Toast.makeText(SiteSearchActivity.this, position+"", 0).show();
		}	
		
}
