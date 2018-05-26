package com.picasa.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.picasa.helper.DatabaseImageService;
import com.picasa.helper.ImageService;
import com.picasa.util.ImageServiceFactory;

public class DownloadImageServlet extends HttpServlet {
	private ImageService imageService;

	@Override
	public void init() throws ServletException {
		imageService = ImageServiceFactory.getImageService("db");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OutputStream os = null;
		Integer imageId = null;
		byte[] image = null;

		imageId = Integer.parseInt(request.getParameter("image_id"));
		image = imageService.getImage(imageId);
		response.setContentType("image/jpeg;Content-Disposition:inline");
		os = response.getOutputStream();
		os.write(image);
		os.close();
	}

}
