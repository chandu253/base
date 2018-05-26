package com.pe.beans;

import java.io.File;
import java.net.URL;
import java.util.Date;

public class Book {
	private int isbn;
	private String title;
	private Date publishedDate;
	private URL site;
	private File toc;
	private String[] authors;

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public void setSite(URL site) {
		this.site = site;
	}

	public void setToc(File toc) {
		this.toc = toc;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public int getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public URL getSite() {
		return site;
	}

	public File getToc() {
		return toc;
	}

	public String[] getAuthors() {
		return authors;
	}

}
