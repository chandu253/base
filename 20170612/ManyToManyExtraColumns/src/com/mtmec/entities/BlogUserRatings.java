package com.mtmec.entities;

import java.io.Serializable;

public class BlogUserRatings implements Serializable {
	protected BlogUserRatingPK blogUserRatingPK;
	protected int rating;
	protected String comments;

	public BlogUserRatingPK getBlogUserRatingPK() {
		return blogUserRatingPK;
	}

	public void setBlogUserRatingPK(BlogUserRatingPK blogUserRatingPK) {
		this.blogUserRatingPK = blogUserRatingPK;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + rating;
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
		BlogUserRatings other = (BlogUserRatings) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (rating != other.rating)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BlogUserRatings [blogUserRatingPK=" + blogUserRatingPK + ", rating=" + rating + ", comments=" + comments
				+ "]";
	}

}
