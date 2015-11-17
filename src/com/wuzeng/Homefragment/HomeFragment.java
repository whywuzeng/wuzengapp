package com.wuzeng.Homefragment;


import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.List;

import com.example.wuzeng_app.MainActivity;
import com.example.wuzeng_app.R;
import com.example.wuzeng_app.SiteSearchActivity;
import com.wuzeng.Utils.WuzengSharedPre;
import com.wuzeng.adapter.CategoryLeftViewAdapter;
import com.wuzeng.adapter.ImageAdapter;
import com.wuzeng.bean.ChannelItem;
import com.wuzeng.bean.HomeAllBean;
import com.wuzeng.wight.pulltorefresh.PullToRefreshBase;
import com.wuzeng.wight.pulltorefresh.PullToRefreshBase.Mode;
import com.wuzeng.wight.pulltorefresh.PullToRefreshBase.OnRefreshListener2;
import com.wuzeng.wight.pulltorefresh.PullToRefreshScrollView;
import com.wuzeng.wight.viewflow.CircleFlowIndicator;
import com.wuzeng.wight.viewflow.ViewFlow;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.wuzeng.bean.Galleryad;

@SuppressWarnings("rawtypes")
public class HomeFragment extends Fragment implements OnRefreshListener2{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}
	private ViewFlow viewFlow;
	private View view;
	private ListView leftlistview;
	private CategoryLeftViewAdapter mAdapter;
	private PullToRefreshScrollView scrollView;
	private List<ChannelItem> list;
	private HomeAllBean bean;
	private List<Galleryad> galleryads;
	private LinearLayout top_search;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if(view==null){
			view=inflater.inflate(R.layout.wu_fragment_home, container,false);
		}
		
		   ViewGroup p = (ViewGroup) view.getParent(); 
	        if (p != null) { 
	            p.removeAllViewsInLayout(); 
	        }
	        
	        viewFlow = (ViewFlow)view .findViewById(R.id.viewflow);
			viewFlow.setAdapter(new ImageAdapter(this.getActivity(),galleryads), 5);
			CircleFlowIndicator indic = (CircleFlowIndicator)view. findViewById(R.id.viewflowindic);
			viewFlow.setFlowIndicator(indic);
			viewFlow.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					
				}
			});
			
			initview(view);
		
		return view;
	}
	

	private void initview(View view2) {
		
		
			// TODO Auto-generated method stub
			scrollView=(PullToRefreshScrollView) view.findViewById(R.id.home_body_scrollview);
			scrollView.setMode(Mode.PULL_FROM_START);
			scrollView.getLoadingLayoutProxy().setLastUpdatedLabel(System.currentTimeMillis()+"");
			scrollView.setOnRefreshListener(this);
			top_search=(LinearLayout)view.findViewById(R.id.top_search);
			
			top_search.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
				
					Intent i=new Intent();
					i.setClass(getActivity(), SiteSearchActivity.class);
					i.putExtra("content", "");
					startActivity(i);
				}
			});
	}


	public View getForView(){
		
		return view==null?null:view;
	}

	@Override
	public void onPullDownToRefresh(PullToRefreshBase refreshView) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPullUpToRefresh(PullToRefreshBase refreshView) {
		// TODO Auto-generated method stub
		
	}
	
	public void updateLinkTools(){
		List<ChannelItem> lists=new ArrayList<ChannelItem>();
		if(bean!=null&&bean.getChannelitem()!=null){
			lists=bean.getChannelitem();
		}
		list.clear();
		
		
		if(WuzengSharedPre.getIntence(getActivity()).getFirstUserMyWz()){
			for(int i=0;i<lists.size();i++){
			list.add(lists.get(i));
			}
		}else if(true){
			//按照数据库保持的顺序加入
			 
		}
		
	}
	
//	List<ChannelItem> list
}
