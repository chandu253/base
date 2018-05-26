package com.otomtoan.entities;

import java.io.Serializable;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "DIGITAL_CARD")
public class DigitalCard implements Serializable {
	@Id
	@Column(name = "DIGITAL_CARD_NO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int digitalCardNo;
	protected String type;

	public int getDigitalCardNo() {
		return digitalCardNo;
	}

	public void setDigitalCardNo(int digitalCardNo) {
		this.digitalCardNo = digitalCardNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + digitalCardNo;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		DigitalCard other = (DigitalCard) obj;
		if (digitalCardNo != other.digitalCardNo)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DigitalCard [digitalCardNo=" + digitalCardNo + ", type=" + type + "]";
	}

}
