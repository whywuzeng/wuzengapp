package com.example.wuzeng_app.utils;


import java.util.Stack;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;


public class AppManager {

	private static Stack<Activity> activityStack;
	private static AppManager instance;

	private AppManager() {
	}

	/**
	 * 鍗曚竴瀹炰緥
	 */
	public static AppManager getAppManager() {
		if (instance == null) {
			instance = new AppManager();
		}
		return instance;
	}

	/**
	 * 娣诲姞Activity鍒板爢鏍�
	 */
	public void addActivity(Activity activity) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		activityStack.add(activity);
	}

	/**
	 * 鑾峰彇褰撳墠Activity锛堝爢鏍堜腑鏈�悗涓�釜鍘嬪叆鐨勶級
	 */
	public Activity currentActivity() {
		Activity activity = activityStack.lastElement();
		return activity;
	}

	public Activity getActivity(Class<?> cls) {
		for (Activity activity : activityStack) {
			if (activity.getClass().equals(cls)) {
				return activity;
			}
		}
		return null;
	}

	/**
	 * 缁撴潫褰撳墠Activity锛堝爢鏍堜腑鏈�悗涓�釜鍘嬪叆鐨勶級
	 */
	public void finishActivity() {
		Activity activity = activityStack.lastElement();
		finishActivity(activity);
	}

	/**
	 * 缁撴潫鎸囧畾鐨凙ctivity
	 */
	public void finishActivity(Activity activity) {
		if (activity != null) {
			activityStack.remove(activity);
			activity.finish();
			activity = null;
		}
	}

	/**
	 * 缁撴潫鎸囧畾绫诲悕鐨凙ctivity
	 */
	public void finishActivity(Class<?> cls) {
		for (Activity activity : activityStack) {
			if (activity.getClass().equals(cls)) {
				finishActivity(activity);
			}
		}
	}

	/**
	 * 缁撴潫鎵�湁Activity
	 */
	public void finishAllActivity() {
		for (int i = 0, size = activityStack.size(); i < size; i++) {
			if (null != activityStack.get(i)) {
				activityStack.get(i).finish();
			}
		}
		activityStack.clear();
	}

	/**
	 * 閫�嚭鎵�湁Activity
	 * 
	 * @return 鏄惁瀹屽叏閫�嚭
	 */
	public boolean exitAllActivity() {
		LogUtil.e("AppManager", "搴旂敤绋嬪簭閫�嚭exitAllActivity()");
		boolean isFinished = true;
		for (Activity act : activityStack) {
			if (act != null) {
				act.finish();
			}
		}
		for (Activity act : activityStack) {
			if (!act.isFinishing()) {
				isFinished = false;
			}
		}
		return isFinished;
	}

	/**
	 * 閫�嚭搴旂敤绋嬪簭
	 */
	public void AppExit(Context context) {
		try {
			finishAllActivity();
			ActivityManager activityMgr = (ActivityManager) context
					.getSystemService(Context.ACTIVITY_SERVICE);
			if (exitAllActivity()) {
				activityMgr.killBackgroundProcesses(context.getPackageName());
				System.exit(0);
			}
		} catch (Exception e) {
			LogUtil.e("AppManager", "閫�嚭搴旂敤绋嬪簭寮傚父!");
			StackTraceElement[] stacks = e.getStackTrace();
			StringBuffer sb = new StringBuffer();
			for (StackTraceElement stack : stacks) {
				sb.append(stack.toString() + "\n");
			}
			LogUtil.e("AppManager", sb.toString());
			System.exit(0);
		}
	}
}