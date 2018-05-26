package com.picasa.bean;

public class ImageMetadata {
	protected Integer imageId;
	protected byte[] image;

	public ImageMetadata(Integer imageId, byte[] image) {
		this.imageId = imageId;
		this.image = image;
	}

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
