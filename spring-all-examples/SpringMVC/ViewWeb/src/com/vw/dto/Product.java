package com.vw.dto;

public class Product {
	protected int productNo;
	protected String productName;

	public Product(int productNo, String productName) {
		this.productNo = productNo;
		this.productName = productName;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
