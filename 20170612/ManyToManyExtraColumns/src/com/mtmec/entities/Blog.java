package com.mtmec.entities;

import java.io.Serializable;
import java.util.Set;

public class Blog implements Serializable {
	protected int blogId;
	protected String title;
	protected String blogContent;
	protected SystemUser blogOwner;
	protected Set<BlogUserRatings> ratings;

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public SystemUser getBlogOwner() {
		return blogOwner;
	}

	public void setBlogOwner(SystemUser blogOwner) {
		this.blogOwner = blogOwner;
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
		result = prime * result + ((blogContent == null) ? 0 : blogContent.hashCode());
		result = prime * result + blogId;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Blog other = (Blog) obj;
		if (blogContent == null) {
			if (other.blogContent != null)
				return false;
		} else if (!blogContent.equals(other.blogContent))
			return false;
		if (blogId != other.blogId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", title=" + title + ", blogContent=" + blogContent + "]";
	}

}
