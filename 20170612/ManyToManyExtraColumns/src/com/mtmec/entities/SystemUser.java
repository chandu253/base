package com.mtmec.entities;

import java.io.Serializable;
import java.util.Set;

public class SystemUser implements Serializable {
	protected int systemUserId;
	protected String displayName;
	protected Set<Blog> userBlogs;
	protected Set<BlogUserRatings> ratings;

	public int getSystemUserId() {
		return systemUserId;
	}

	public void setSystemUserId(int systemUserId) {
		this.systemUserId = systemUserId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Set<Blog> getUserBlogs() {
		return userBlogs;
	}

	public void setUserBlogs(Set<Blog> userBlogs) {
		this.userBlogs = userBlogs;
	}

	public Set<BlogUserRatings> getRatings() {
		return ratings;
	}

	public void setRatings(Set<BlogUserRatings> ratings) {
		this.ratings = ratings;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
		result = prime * result + systemUserId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SystemUser other = (SystemUser) obj;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		if (systemUserId != other.systemUserId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SystemUser [systemUserId=" + systemUserId + ", displayName=" + displayName + "]";
	}

}
