package com.bpp.beans;

public class EBook {
	private int bookNo;
	private String title;
	private int size;

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "EBook [bookNo=" + bookNo + ", title=" + title + ", size=" + size + "]";
	}

}
