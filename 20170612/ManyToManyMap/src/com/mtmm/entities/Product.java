package com.mtmm.entities;

import java.io.Serializable;
import java.util.Map;

public class Product implements Serializable {
	protected int productNo;
	protected String description;
	protected String ownerName;
	protected float basePrice;

	protected Map<Float, User> bidders;

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}

	public Map<Float, User> getBidders() {
		return bidders;
	}

	public void setBidders(Map<Float, User> bidders) {
		this.bidders = bidders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(basePrice);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((ownerName == null) ? 0 : ownerName.hashCode());
		result = prime * result + productNo;
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
		Product other = (Product) obj;
		if (Float.floatToIntBits(basePrice) != Float.floatToIntBits(other.basePrice))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (ownerName == null) {
			if (other.ownerName != null)
				return false;
		} else if (!ownerName.equals(other.ownerName))
			return false;
		if (productNo != other.productNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", description=" + description + ", ownerName=" + ownerName
				+ ", basePrice=" + basePrice + ", bidders=" + bidders + "]";
	}

}
