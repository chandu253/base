package com.picasa.delegate;

import com.picasa.dao.GalleryDao;

public class GalleryDelegate {
	private GalleryDao galleryDao;

	public GalleryDelegate() {
		galleryDao = new GalleryDao();
	}

	public Integer getFirstImage() {
		return galleryDao.getFirstImage();
	}

	public Integer getNextImage(Integer cImageId) {
		return galleryDao.getNextImage(cImageId);
	}

	public Integer getPrevImage(Integer cImageId) {
		return galleryDao.getPrevImage(cImageId);
	}

	public byte[] getImage(Integer imageId) {
		return galleryDao.getImage(imageId);
	}
}
