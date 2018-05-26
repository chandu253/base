package com.bpp.beans;

public class Video {
	private int videoId;
	private String title;
	private int length;

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", title=" + title + ", length=" + length + "]";
	}

}
