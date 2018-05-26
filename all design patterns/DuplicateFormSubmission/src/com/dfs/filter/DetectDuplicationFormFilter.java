package com.dfs.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DetectDuplicationFormFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		String serverToken = null;
		String clientToken = null;
		HttpSession httpSession = null;
		HttpServletRequest httpRequest = null;

		httpRequest = (HttpServletRequest) request;
		httpSession = httpRequest.getSession(false);

		// new user
		if (httpSession == null) {
			httpSession = httpRequest.getSession();
			serverToken = UUID.randomUUID().toString();
			httpSession.setAttribute("sToken", serverToken);
			httpRequest.setAttribute("cToken", serverToken);
		} else {
			// detect the duplicate request
			if (httpRequest.getMethod().equalsIgnoreCase("post")) {
				clientToken = httpRequest.getParameter("cToken");
				serverToken = (String) httpSession.getAttribute("sToken");
				if (clientToken.equals(serverToken) == false) {
					httpSession.invalidate();
					((HttpServletResponse) response).sendRedirect("dup-form-error.jsp");
					return;
				}
			}

			// here
			serverToken = UUID.randomUUID().toString();
			httpSession.setAttribute("sToken", serverToken);
			request.setAttribute("cToken", serverToken);
		}
		filterChain.doFilter(request, response);

	}

	@Override
	public void destroy() {

	}

}
