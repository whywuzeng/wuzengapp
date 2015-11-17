package com.example.wuzeng_app.base;

import java.nio.MappedByteBuffer;

import com.wuzeng.db.DBHelper;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

public class AppContext extends Application {
	
	private  static AppContext mAppContext;
	private static DBHelper mDbHelper;
	private static SQLiteDatabase db;
	
	public AppContext(){
		
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mDbHelper=DBHelper.getInstance(this);
		db = mDbHelper.getWritableDatabase();
		
	}
	
	public static void OpenDb(){
		if(!db.isOpen()){
			mDbHelper.onOpen(db);
		}
	}
	
	public static SQLiteDatabase  getDB(){
		return db;
	}
	
	public static void closeDb(){
		
		db.close();
	}
	
	public static AppContext getInstance(){
		if(mAppContext==null){
			mAppContext=new AppContext();
		}
		return mAppContext;
	}
}
