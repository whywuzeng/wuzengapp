package com.wuzeng.bean;

public class Galleryad {

	public int getRowId() {
		return rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	public String getImgUrl() {
		return ImgUrl;
	}

	public void setImgUrl(String imgUrl) {
		ImgUrl = imgUrl;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getHoudongId() {
		return houdongId;
	}

	public void setHoudongId(int houdongId) {
		this.houdongId = houdongId;
	}

	public Galleryad(int rowId, String imgUrl, int flag, int houdongId) {
		super();
		this.rowId = rowId;
		ImgUrl = imgUrl;
		this.flag = flag;
		this.houdongId = houdongId;
	}

	@Override
	public String toString() {
		return "Galleryad [rowId=" + rowId + ", ImgUrl=" + ImgUrl + ", flag="
				+ flag + ", houdongId=" + houdongId + ", getRowId()="
				+ getRowId() + ", getImgUrl()=" + getImgUrl() + ", getFlag()="
				+ getFlag() + ", getHoudongId()=" + getHoudongId()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	private int rowId;
	
	private String ImgUrl;
	
	private int flag;
	
	private int houdongId;
	
}
