package com.picasa.util;

import com.picasa.helper.CachedImageService;
import com.picasa.helper.DatabaseImageService;
import com.picasa.helper.ImageService;

public class ImageServiceFactory {
	public static ImageService getImageService(String type) {
		return new CachedImageService(new DatabaseImageService());
	}
}
