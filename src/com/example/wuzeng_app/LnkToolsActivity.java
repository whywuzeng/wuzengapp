package com.example.wuzeng_app;

import java.util.ArrayList;
import java.util.List;

import com.wuzeng.adapter.ImageAdapter;
import com.wuzeng.adapter.ImageAdapterSmall;
import com.wuzeng.bean.Galleryad;
import com.wuzeng.ui.MDragGrid;

import android.app.Activity;
import android.os.Bundle;

public class LnkToolsActivity extends Activity {
	private MDragGrid mdrag;
	
	private List<Galleryad> galleryads=null;
	private List<String> mList=new ArrayList<String>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lnktools_activity);
		initview();
	}

	private void initview() {
		// TODO Auto-generated method stub
		mdrag=(MDragGrid)findViewById(R.id.draggrid_body);
	
		mdrag.setAdapter(new ImageAdapterSmall(this, galleryads));
//		ImageAdapter imageAdapter = new ImageAdapter(this, galleryads);
//		imageAdapter.notifyDataSetChanged();
	}
}
