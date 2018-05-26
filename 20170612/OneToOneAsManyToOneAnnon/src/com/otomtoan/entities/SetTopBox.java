package com.otomtoan.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "SET_TOP_BOX")
public class SetTopBox implements Serializable {
	@Id
	@Column(name = "BOX_NO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int boxNo;
	protected String manufacturer;
	protected float price;

	@ManyToOne
	@JoinColumn(name = "DIGITAL_CARD_NO", unique = true)
	protected DigitalCard digitalCard;

	public int getBoxNo() {
		return boxNo;
	}

	public void setBoxNo(int boxNo) {
		this.boxNo = boxNo;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public DigitalCard getDigitalCard() {
		return digitalCard;
	}

	public void setDigitalCard(DigitalCard digitalCard) {
		this.digitalCard = digitalCard;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boxNo;
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + Float.floatToIntBits(price);
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
		SetTopBox other = (SetTopBox) obj;
		if (boxNo != other.boxNo)
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SetTopBox [boxNo=" + boxNo + ", manufacturer=" + manufacturer + ", price=" + price + "]";
	}

}
