package com.example.wuzeng_app.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.example.wuzeng_app.R;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.utils.StorageUtils;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;

public class WuApplication extends Application {
	public static WuApplication application;

	public WuApplication getInstence() {
		if (application == null) {
			application = new WuApplication();
		}

		return application;
	}


	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		initImageload(this);

	}

	public void initImageload(Context context) {
		File file = StorageUtils.getOwnCacheDirectory(context,
				"wuzeng/cache/ImageCache");
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.showStubImage(R.drawable.image_default_rectangle)
				.showImageForEmptyUri(R.drawable.image_default_rectangle)
				.showImageOnFail(R.drawable.image_default_rectangle)
				.imageScaleType(ImageScaleType.IN_SAMPLE_INT)
				.cacheInMemory(true).cacheOnDisc(true)
				.bitmapConfig(Bitmap.Config.RGB_565).build();
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				context).threadPriority(Thread.NORM_PRIORITY)
				.denyCacheImageMultipleSizesInMemory()
				.defaultDisplayImageOptions(options)
				.discCache(new UnlimitedDiscCache(file))
				.discCacheFileNameGenerator(new Md5FileNameGenerator())
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				.discCache(new UnlimitedDiscCache(file)).build();
		ImageLoader.getInstance().init(config);
	}

	/**
	 * 保存序列化的对象
	 */

	public boolean saveObject(Serializable ser, String file) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = openFileOutput(file, MODE_PRIVATE);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(ser);
			oos.flush();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {

			try {
				oos.close();
			} catch (Exception e) {
			}

			try {
				fos.close();
			} catch (Exception e) {
			}

		}
	}

	private boolean isExitDataCache(String cachefile) {
		boolean exist = false;
		File path = getFileStreamPath(cachefile);
		if (path.exists()) {
			exist = true;
		}
		return exist;
	}

	public Serializable readObject(String file) {
		if (!isExitDataCache(file))
			return null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = openFileInput(file);
			ois = new ObjectInputStream(fis);
			Serializable readObject = (Serializable) ois.readObject();
			return readObject;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if (e instanceof InvalidClassException) {
				File data = getFileStreamPath(file);
				data.delete();
			}
		} finally {
			try {

				ois.close();
			} catch (Exception e2) {
				// TODO: handle exceptione
			}

			try {

				fis.close();
			} catch (Exception e2) {
				// TODO: handle exceptione
			}
		}
		
		return null;
	}
}
