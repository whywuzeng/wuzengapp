package com.wuzeng.db;

import com.example.wuzeng_app.base.AppContext;

import android.database.sqlite.SQLiteDatabase;

public class DBDao {
	
	protected final SQLiteDatabase mLiteDatabase;
	
	public DBDao(){
		mLiteDatabase = AppContext.getInstance().getDB();
	}
}
