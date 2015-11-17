package com.wuzeng.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;

import com.wuzeng.bean.ChannelItem;
public class LinkToolsDao extends DBDao {
	
	public long addItem(ChannelItem bean){
		ContentValues values=new ContentValues();
		values.put("name", bean.getName());
		values.put("Id", bean.getId());
		values.put("imageURl", bean.getImageUrl());
		return mLiteDatabase.insert(DBHelper.LinkTools_table, null, values);
	}
	
//	public void addAll(List<ChannelItem> beans){
//		
//		return mLiteDatabase.
//	}
	
	/**
	 * 用 ACS   表示按正序排序(即：从小到大排序)
	 * @return
	 */
	public List<ChannelItem> fetcheAll(){
		
		List<ChannelItem> lists=new ArrayList<ChannelItem>();
		String [] columns={"rowId as _id","lnkId","name","imageurl","orderId"};
		
		Cursor query = mLiteDatabase.query(DBHelper.LinkTools_table, columns, null, null, null, null, "_id asc");
		ChannelItem bean=null;
		for(int i=0;i<query.getColumnCount();i++){
			if(query.moveToNext()){
				bean=new ChannelItem();
				bean.setId(query.getInt(0));
				bean.setImageUrl(query.getString(1));
				bean.setName(query.getString(2));
				query.getColumnIndex("name");
				lists.add(bean);
			}
		}
		return lists;
	}
	
}
