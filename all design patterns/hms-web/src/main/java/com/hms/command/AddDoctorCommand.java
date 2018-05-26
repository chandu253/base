package com.hms.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webfaces.command.Command;

public class AddDoctorCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String doctorName = null;

		doctorName = request.getParameter("doctorName");
		request.setAttribute("doctor", doctorName);

		return "doctor-details";
	}

}
