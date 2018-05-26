package com.cc.beans;

import java.beans.ConstructorProperties;

public class Machine {
	private int id;
	private String name;
	private long serialNo;

	//@ConstructorProperties({ "id", "name", "serialNo" })
	public Machine(int id, String name, long serialNo) {
		this.id = id;
		this.name = name;
		this.serialNo = serialNo;
	}

	@Override
	public String toString() {
		return "Machine [id=" + id + ", name=" + name + ", serialNo=" + serialNo + "]";
	}

}
