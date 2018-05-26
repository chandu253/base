package com.lmi.beans;

public class RequestHandler {
	protected String data;

	public void handle() {
		System.out.println("processing data : " + data + " with agent : " + this.hashCode());
	}

	public void setData(String data) {
		this.data = data;
	}

}
