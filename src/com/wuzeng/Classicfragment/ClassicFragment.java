package com.wuzeng.Classicfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.wuzeng_app.R;
import com.wuzeng.adapter.CategoryLeftViewAdapter;
import com.wuzeng.ui.AnimationSildingLayout;

public class ClassicFragment extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}
	private View view;
	private ListView leftlistview;
	private CategoryLeftViewAdapter mAdapter;
	private AnimationSildingLayout mAnimationSildingLayout;
	private ListView rightlistview;
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
	
	private void initview(View view2) {
		// TODO Auto-generated method stub
		leftlistview=(ListView)view.findViewById(R.id.left_listview);
		rightlistview=(ListView)view.findViewById(R.id.rightCategoryList);
		mAnimationSildingLayout=(AnimationSildingLayout)view.findViewById(R.id.m_animationsild);
		mAdapter=new CategoryLeftViewAdapter(getActivity());
		leftlistview.setAdapter(mAdapter);
		rightlistview.setDivider(null);
		rightlistview.setAdapter(mAdapter);
		rightlistview.invalidate();
		leftlistview.invalidate();
		mAnimationSildingLayout.initLayout(leftlistview, rightlistview);
		
		//刚开始的 左边listview点击事件监听
		leftlistview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent,
					View view, int position, long id) {
//				foodpoition = position;
//				mAdapter.setSelectedPosition(position);
				mAdapter.notifyDataSetInvalidated();
//				categories1 = categories.get(position)
//						.getCategorys();
//				rightAdapter = new CategoryRightListAdapter(
//						getActivity(), categories1, foodpoition);
				rightlistview.setDivider(null);
				rightlistview.setAdapter(mAdapter);
//				rightlistview.setOnItemClickListener(listener);
				mAnimationSildingLayout.startSildingInAnimation(position);
			}
		});
	}

	public View getForView(){
		
		return view==null?null:view;
	}
	
	public void backToCategory() {
//		if (cf != null && cf.isShow()) {
//			getFragmentManager().popBackStack();
//		}
	}
	
	/***
	 * 类别初始化到起始第一类类别
	 * 
	 * */
	public void backToOrigin() {
		if (mAnimationSildingLayout != null) {
//			mAnimationSildingLayout.scrollInit();
		}
	}
}
