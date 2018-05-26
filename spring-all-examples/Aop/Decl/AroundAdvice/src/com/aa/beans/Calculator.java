package com.aa.beans;

public class Calculator {
	public int add(int a, int b) {
		System.out.println("in add(int,int)");
		return a + b;
	}

	public int add(int a, int b, int c) {
		System.out.println("in add(int,int,int)");
		return a + b + c;
	}
}
