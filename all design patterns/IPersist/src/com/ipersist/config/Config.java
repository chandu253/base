package com.ipersist.config;

public class Config {
	protected String driverClassname;
	protected String url;
	protected String username;
	protected String password;
	protected String sql;

	public Config() {
	}

	public Config(String driverClassname, String url, String username, String password, String sql) {
		this.driverClassname = driverClassname;
		this.url = url;
		this.username = username;
		this.password = password;
		this.sql = sql;
	}

	public String getDriverClassname() {
		return driverClassname;
	}

	public void setDriverClassname(String driverClassname) {
		this.driverClassname = driverClassname;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

}
