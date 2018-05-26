package com.pagination.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagination.bo.AppointmentBo;
import com.pagination.delegate.AppointmentDelegate;

public class AppointmentsServlet extends HttpServlet {
	private final int PAGE_SIZE = 5;
	private AppointmentDelegate delegate;

	@Override
	public void init() throws ServletException {
		delegate = new AppointmentDelegate();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int totalPages = 0;
		int currentPage = 0;
		int totalRecords = 0;
		String action = null;
		List<AppointmentBo> appointments = null;

		action = request.getParameter("action");
		// first request
		if (action == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			if (action.equals("prev")) {
				currentPage--;
			} else if (action.equals("next")) {
				currentPage++;
			}
		}

		appointments = delegate.getAppointments(currentPage, PAGE_SIZE);
		totalRecords = delegate.getNoOfAppointments();

		request.setAttribute("appointments", appointments);
		request.setAttribute("currentPage", currentPage);
		if (totalRecords % PAGE_SIZE == 0) {
			totalPages = (int) Math.ceil(totalRecords / PAGE_SIZE);
		} else {
			totalPages = (int) (Math.ceil(totalRecords / PAGE_SIZE) + 1);
		}
		request.setAttribute("totalPages", totalPages);

		request.getRequestDispatcher("/appointments.jsp").forward(request, response);

	}

}
