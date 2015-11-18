package com.wuzeng.adapter;

/*
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.example.wuzeng_app.LnkToolsActivity;
import com.example.wuzeng_app.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.wuzeng.StartActivity;
import com.wuzeng.bean.Galleryad;

public class ImageAdapterSmall extends BaseAdapter {

	private DisplayImageOptions options;
	private ImageLoader loader;
	private Context context;
	private List<Galleryad> gallery_list;

	private LayoutInflater mInflater;
	private static final int[] ids = { R.drawable.cupcake1, R.drawable.donut1,
			R.drawable.eclair1, R.drawable.froyo1, R.drawable.gingerbread1
			 };

	public ImageAdapterSmall(Context context,List<Galleryad> gallery_list) {
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		options = new DisplayImageOptions.Builder().cacheInMemory(true)
				.cacheOnDisc(true)
				.showStubImage(R.drawable.image_default_gallery)
				.showImageForEmptyUri(R.drawable.image_default_gallery)
				.showImageOnFail(R.drawable.image_default_gallery)
				.imageScaleType(ImageScaleType.IN_SAMPLE_INT)
				.bitmapConfig(Bitmap.Config.RGB_565)
				.displayer(new RoundedBitmapDisplayer(0)).build();
		loader=ImageLoader.getInstance();
		this.context=context;
		this.gallery_list=gallery_list;
//		for(){
//		Galleryad galleryad=new Galleryad(rowId, imgUrl, flag, houdongId);
//		}
//		gallery_list.add()
	}

	@Override
	public int getCount() {
		return ids.length;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder=null;
		
		if (convertView == null) {
//			viewHolder=new ViewHolder();
//			ImageView imageView=new ImageView(context);
//			imageView.setScaleType(ScaleType.FIT_XY);
//			imageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
//			convertView =imageView;
//			viewHolder.imageView=(ImageView)convertView;
//			convertView.setTag(viewHolder);
			
			convertView = mInflater.inflate(R.layout.imageadaptersmall, null);
		
			}
//			else{
//				viewHolder=(ViewHolder)convertView.getTag();
//			}
			
//		Galleryad galleryad = gallery_list.get(position%gallery_list.size());
//		loader.displayImage(galleryad.getImgUrl(), viewHolder.imageView, options);
//		viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//			Galleryad galleryad2 = gallery_list.get(position%gallery_list.size());
//			if(galleryad2.getFlag()==2){
//				Log.i("tag", "转到商品详情页");
//			}else if(galleryad2.getFlag()==3){
//				Log.i("tag", "转到专区");
//			}else if(galleryad2.getFlag()==4){
//				Log.i("tag", "转到快捷服务");
//				//根据需求来跳转
//				switch (galleryad2.getRowId()) {
//				case 1:
//					
//					break;
//					
//				case 2:
//					break;
//				case 3:
//					break;
//				case 4:
//					break;
//				case 5:
//					break;
//				case 6:
//					break;
//				case 7:
//					break;
//
//				default:
//					break;
//				}
//			}
//				
//			}
//		});
		ImageView mImageView=(ImageView)convertView.findViewById(R.id.imageview);
		
		((ImageView) convertView.findViewById(R.id.imageview))
				.setImageResource(ids[position]);
//		LnkToolsActivity
//		mImageView.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Intent i=new Intent();
//				i.setClass(context,LnkToolsActivity.class );
//				context.startActivity(i);
//			}
//		});
		return convertView;
	}
	
	private class ViewHolder{
		ImageView imageView;
	}

}
