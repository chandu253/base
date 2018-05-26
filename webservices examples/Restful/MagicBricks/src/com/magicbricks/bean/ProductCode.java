package com.magicbricks.bean;

public class ProductCode {
	protected int category;
	protected int productNo;

	/*public ProductCode(String productCode) {
		String c = null;
		String no = null;

		if (productCode != null && productCode.length() == 5) {
			c = productCode.substring(0, 1);
			no = productCode.substring(2, productCode.length());

			category = Integer.parseInt(c);
			productNo = Integer.parseInt(no);
		}
	}*/
	
	public static ProductCode valueOf(String productCode) {
		String c = null;
		String no = null;
		ProductCode pc = null;

		if (productCode != null && productCode.length() == 5) {
			pc = new ProductCode();
			c = productCode.substring(0, 2);
			no = productCode.substring(2, productCode.length());

			pc.setCategory(Integer.parseInt(c));
			pc.setProductNo(Integer.parseInt(no));
		}
		return pc;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

}
