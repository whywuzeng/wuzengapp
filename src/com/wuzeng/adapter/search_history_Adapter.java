package com.wuzeng.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import com.custom.vg.list.CustomAdapter;
import com.example.wuzeng_app.R;

import android.content.Context;
import android.support.v4.widget.SearchViewCompat.OnCloseListenerCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class search_history_Adapter extends CustomAdapter {

	private Context context;
	List<String> mList=new ArrayList<String>();
	
	public search_history_Adapter(Context context){
		this.context=context;
		mList.add("1111111");
		mList.add("1111111");
		mList.add("22222222");
		mList.add("22222222");
		mList.add("333333333");
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
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
		ViewHolder holder=null;
		View inflate=null;
		if(convertView==null){
			holder=new ViewHolder();
			 inflate = View.inflate(context, R.layout.search_history_textitem, null);
			holder.mTextView=(TextView) inflate.findViewById(R.id.tv_history);
			convertView=inflate;
			convertView.setTag(inflate);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		holder.mTextView.setText(mList.get(position));
		holder.mTextView.setOnClickListener(new Mylistener(position));
		return convertView;
	}
	
	class ViewHolder{
		TextView mTextView;
	}

	
	class Mylistener implements OnClickListener{

		private int position;
		
		public Mylistener(int position){
			this.position=position;
		}
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			name.setListener(position);
		}
		
	}
	private gocallback name;
	public void setgocallback(gocallback name){
		this.name=name;
		
	}
	
	public interface gocallback{
		public void setListener(int position);
	}
}



