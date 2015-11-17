package com.wuzeng.bean;

public class ChannelItem {

	/**
	 * 栏目对应ID
	 * */
	private int id;
	/**
	 * 栏目对应NAME
	 * */
	private String name;
	
	/**
	 * 栏目是否选中
	 * */
	
	public String ImageUrl;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return ImageUrl;
	}

	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	private boolean isSelected;
}
