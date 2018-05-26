package com.bfpp.beans;

public class ConnectionFactory {
	protected String driverClassname;
	protected String url;
	protected String username;
	protected String password;

	public void setDriverClassname(String driverClassname) {
		this.driverClassname = driverClassname;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ConnectionFactory [driverClassname=" + driverClassname + ", url=" + url + ", username=" + username
				+ ", password=" + password + "]";
	}

}
