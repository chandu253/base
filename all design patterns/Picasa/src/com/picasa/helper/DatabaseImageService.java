package com.picasa.helper;

import com.picasa.delegate.GalleryDelegate;

public class DatabaseImageService implements ImageService {
	private GalleryDelegate galleryDelegate;

	public DatabaseImageService() {
		galleryDelegate = new GalleryDelegate();
	}

	@Override
	public byte[] getImage(Integer imageId) {
		return galleryDelegate.getImage(imageId);
	}

}
