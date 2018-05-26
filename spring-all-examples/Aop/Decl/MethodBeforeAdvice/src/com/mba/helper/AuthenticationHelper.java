package com.mba.helper;

public class AuthenticationHelper {
	private static AuthenticationHelper instance;
	private ThreadLocal<UserInfo> threadLocal;

	private AuthenticationHelper() {
		threadLocal = new ThreadLocal<>();
	}

	public synchronized static AuthenticationHelper getInstance() {
		if (instance == null) {
			instance = new AuthenticationHelper();
		}
		return instance;
	}

	public void login(String un, String pwd) {
		threadLocal.set(new UserInfo(un, pwd));
	}

	public void logout() {
		threadLocal.set(null);
	}

	public String getLoggedInUser() {
		return threadLocal.get() != null ? threadLocal.get().getUn() : null;
	}

	public boolean authentication() {
		return threadLocal.get() != null
				? (threadLocal.get().getUn().equals("john") && threadLocal.get().getPwd().equals("welcome1"))
				: false;
	}
}
