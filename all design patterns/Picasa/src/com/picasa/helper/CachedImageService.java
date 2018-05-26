package com.picasa.helper;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.picasa.bean.ImageMetadata;

public class CachedImageService implements ImageService {
	private ImageService imageService;
	private List<ImageMetadata> images;

	public CachedImageService(ImageService imageService) {
		this.imageService = imageService;
		images = new Vector<>();
	}

	@Override
	public byte[] getImage(Integer imageId) {
		ImageMetadata imageMetadata = null;

		if (images != null && images.size() > 0) {
			for (ImageMetadata im : images) {
				if (im.getImageId() == imageId) {
					imageMetadata = im;
					break;
				}
			}
		}
		if (imageMetadata == null) {
			byte[] image = imageService.getImage(imageId);
			imageMetadata = new ImageMetadata(imageId, image);
			images.add(imageMetadata);
			if (images.size() > 3) {
				images.remove(0);
			}
		}
		return imageMetadata.getImage();
	}

}
