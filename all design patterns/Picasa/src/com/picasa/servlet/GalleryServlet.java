package com.picasa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.picasa.delegate.GalleryDelegate;

public class GalleryServlet extends HttpServlet {
	private GalleryDelegate galleryDelegate;

	@Override
	public void init() throws ServletException {
		galleryDelegate = new GalleryDelegate();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = null;
		Integer cImageId = null;
		Integer imageId = null;

		action = request.getParameter("action");
		// fetch the first image
		if (action == null) {
			imageId = galleryDelegate.getFirstImage();
		} else {
			cImageId = Integer.parseInt(request.getParameter("c_img_id"));
			if (action.equals("next")) {
				imageId = galleryDelegate.getNextImage(cImageId);

			} else if (action.equals("prev")) {
				imageId = galleryDelegate.getPrevImage(cImageId);
			}
			if (imageId == 0) {
				imageId = cImageId;
			}
		}
		request.setAttribute("img_id", imageId);
		request.getRequestDispatcher("/WEB-INF/gallery.jsp").forward(request, response);
	}

}
