package com.wuzeng.MyWuZengfragment;

import com.example.wuzeng_app.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyWuZengFragment extends Fragment {
	private View view;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if(view==null){
			view=inflater.inflate(R.layout.wu_fragment_mywuzeng, container,false);
		}
		
		   ViewGroup p = (ViewGroup) view.getParent(); 
	        if (p != null) { 
	            p.removeAllViewsInLayout(); 
	        }
		
		return view;
	}
	
	public View getForView(){
		
		return view==null?null:view;
	}
}
