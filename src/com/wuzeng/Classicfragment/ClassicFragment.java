package com.wuzeng.Classicfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.wuzeng_app.R;
import com.wuzeng.adapter.CategoryLeftViewAdapter;
import com.wuzeng.ui.AnimationSildingLayout;
import com.wuzeng.wight.pulltorefresh.PullToRefreshScrollView;
import com.wuzeng.wight.pulltorefresh.PullToRefreshBase.Mode;

public class ClassicFragment extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}
	private View view;
	private ListView leftlistview;
	private CategoryLeftViewAdapter mAdapter;
	private PullToRefreshScrollView scrollView;
	private ListView rightlistview;
	private AnimationSildingLayout mAnimationSildingLayout;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		if(view==null){
			view=inflater.inflate(R.layout.wu_fragment_classic, container,false);
		}
		
	    ViewGroup p = (ViewGroup) view.getParent(); 
        if (p != null) { 
            p.removeAllViewsInLayout(); 
        }
        initview(view);
        
		return view;
	}
	
	private void initview(View view) {
		// TODO Auto-generated method stub
		mAnimationSildingLayout=(AnimationSildingLayout)view.findViewById(R.id.mAnimationSildingLayout);
		leftlistview=(ListView)view.findViewById(R.id.left_listview);
		mAdapter=new CategoryLeftViewAdapter(getActivity());
		leftlistview.setAdapter(mAdapter);
		leftlistview.invalidate();
//		rightCategoryList
		rightlistview=(ListView)view.findViewById(R.id.rightCategoryList);
		rightlistview.setAdapter(mAdapter);
		mAnimationSildingLayout.initLayout(leftlistview, rightlistview);
		leftlistview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
				mAnimationSildingLayout.startSildingInAnimation(position);
			}
			
		});
	}

	
	public View getForView(){
		
		return view==null?null:view;
	}
}
