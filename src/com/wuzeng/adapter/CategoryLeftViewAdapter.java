package com.wuzeng.adapter;

import com.example.wuzeng_app.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CategoryLeftViewAdapter extends BaseAdapter {

	private String[] mStrings={"item0","item1","item2","item3","item4","item5"};
	private Context context;
	
	
	public CategoryLeftViewAdapter(Context context){
		this.context=context;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mStrings.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		 View inflate=null;
		ViewHolder viewHolder=null;
		if(convertView==null){
			viewHolder=new ViewHolder();
			 inflate = View.inflate(context, R.layout.testlayout_kesan, null);
			viewHolder.description=(TextView)inflate.findViewById(R.id.test_textview);
			convertView=inflate;
			convertView.setTag(viewHolder);
		}else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.description.setText(mStrings[position]);
		
		return convertView;
	}

	public boolean isHideFlag() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setHideFlag(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	public class ViewHolder{
		 public TextView description;
	}

}
