package com.hi.interceptors;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MaintainanceCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		int hour = 0;
		Calendar calendar = null;

		calendar = Calendar.getInstance();
		hour = calendar.get(Calendar.HOUR);
		if (hour >= 8 && hour <= 10) {
			response.sendRedirect("maintainance.jsp");
			return false;
		}

		return true;
	}

}
