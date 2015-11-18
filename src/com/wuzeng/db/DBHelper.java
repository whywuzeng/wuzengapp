package com.wuzeng.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	private final static String DBNAME="wuzeng.db";
	private final static int VERSION =1;
	public final static String LinkTools_table="linktools";
	private final static String LINKTOOLS_SQL="CREATE TABLE IF NO exists" +LinkTools_table+"name text,imageUrl text,order integer,lnkId integer";
	
	
	
	public static DBHelper mDbHelper;
	
	public static DBHelper getInstance(Context context){
		if(mDbHelper==null){
			mDbHelper=new DBHelper(context);
		}
		return mDbHelper;
	}
	
	public DBHelper(Context context
			) {
		super(context, DBNAME, null, VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("LINKTOOLS_SQL");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
