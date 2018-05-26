package com.mba.helper;

import com.mba.beans.UserInfo;

public class AuthenticationHelper {
	private static AuthenticationHelper instance;
	private ThreadLocal<UserInfo> threadLocal;

	private AuthenticationHelper() {
		threadLocal = new ThreadLocal<UserInfo>();
	}

	public synchronized static AuthenticationHelper getInstance() {
		if (instance == null) {
			instance = new AuthenticationHelper();
		}
		return instance;
	}

	public void login(String username, String password) {
		threadLocal.set(new UserInfo(username, password));
	}

	public void logout() {
		threadLocal.set(null);
	}

	public boolean authenticate() {
		UserInfo ui = null;

		ui = threadLocal.get();
		if (ui != null) {
			if (ui.getUsername().equals("john") && ui.getPassword().equals("welcome1")) {
				return true;
			}
		}
		return false;
	}

	public String getLoggedInUser() {
		UserInfo ui = null;

		ui = threadLocal.get();
		if (ui != null) {
			return ui.getUsername();
		}
		return null;
	}
}
