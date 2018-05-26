package com.ip.entities;

import java.util.Date;

public class CheckPayment extends Payment {
	protected int checkNo;
	protected String issuedBank;
	protected Date checkDate;

	public int getCheckNo() {
		return checkNo;
	}

	public void setCheckNo(int checkNo) {
		this.checkNo = checkNo;
	}

	public String getIssuedBank() {
		return issuedBank;
	}

	public void setIssuedBank(String issuedBank) {
		this.issuedBank = issuedBank;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((checkDate == null) ? 0 : checkDate.hashCode());
		result = prime * result + checkNo;
		result = prime * result + ((issuedBank == null) ? 0 : issuedBank.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheckPayment other = (CheckPayment) obj;
		if (checkDate == null) {
			if (other.checkDate != null)
				return false;
		} else if (!checkDate.equals(other.checkDate))
			return false;
		if (checkNo != other.checkNo)
			return false;
		if (issuedBank == null) {
			if (other.issuedBank != null)
				return false;
		} else if (!issuedBank.equals(other.issuedBank))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CheckPayment [checkNo=" + checkNo + ", issuedBank=" + issuedBank + ", checkDate=" + checkDate + "]";
	}

}
