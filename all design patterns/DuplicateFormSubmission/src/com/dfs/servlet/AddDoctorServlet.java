package com.dfs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddDoctorServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String doctorName = null;

		doctorName = request.getParameter("doctorName");
		request.setAttribute("doctorName", doctorName);
		request.getRequestDispatcher("/doctor-details.jsp").forward(request, response);
	}

}
