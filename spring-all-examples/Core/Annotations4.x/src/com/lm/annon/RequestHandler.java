package com.lm.annon;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class RequestHandler {
	protected String data;

	public void handle() {
		System.out.println("processing request : " + this.hashCode() + " - with data : " + data);
	}

	public void setData(String data) {
		this.data = data;
	}

}
