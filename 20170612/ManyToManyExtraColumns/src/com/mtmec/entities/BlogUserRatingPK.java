package com.mtmec.entities;

import java.io.Serializable;

public class BlogUserRatingPK implements Serializable {
	protected Blog blog;
	protected SystemUser systemUser;

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public SystemUser getSystemUser() {
		return systemUser;
	}

	public void setSystemUser(SystemUser systemUser) {
		this.systemUser = systemUser;
	}

}
