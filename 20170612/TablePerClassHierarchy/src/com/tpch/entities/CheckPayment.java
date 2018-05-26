package com.tpch.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("check")
public class CheckPayment extends Payment {
	@Column(name = "CHECK_NO")
	protected int checkNo;
	@Column(name = "ISSUED_BANK")
	protected String issuedBank;
	@Column(name = "CHECK_DT")
	protected Date checkDate;
	@Column(name = "ISSUER_ACCOUNT_NO")
	protected String issuerAccountNo;

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

	public String getIssuerAccountNo() {
		return issuerAccountNo;
	}

	public void setIssuerAccountNo(String issuerAccountNo) {
		this.issuerAccountNo = issuerAccountNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((checkDate == null) ? 0 : checkDate.hashCode());
		result = prime * result + checkNo;
		result = prime * result + ((issuedBank == null) ? 0 : issuedBank.hashCode());
		result = prime * result + ((issuerAccountNo == null) ? 0 : issuerAccountNo.hashCode());
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
		if (issuerAccountNo == null) {
			if (other.issuerAccountNo != null)
				return false;
		} else if (!issuerAccountNo.equals(other.issuerAccountNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CheckPayment [checkNo=" + checkNo + ", issuedBank=" + issuedBank + ", checkDate=" + checkDate
				+ ", issuerAccountNo=" + issuerAccountNo + "]";
	}

}
