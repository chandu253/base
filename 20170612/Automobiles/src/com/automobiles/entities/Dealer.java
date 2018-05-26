package com.automobiles.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Dealer implements java.io.Serializable {

	private int dealerCode;
	
	private String dealerNm;
	private Date registrationDt;
	private int contactNo;
	private String emailAddress;
	private Set<ServiceCenter> serviceCenters ;
	private Address address;
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + contactNo;
		result = prime * result + dealerCode;
		result = prime * result + ((dealerNm == null) ? 0 : dealerNm.hashCode());
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((registrationDt == null) ? 0 : registrationDt.hashCode());
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
		Dealer other = (Dealer) obj;
		if (contactNo != other.contactNo)
			return false;
		if (dealerCode != other.dealerCode)
			return false;
		if (dealerNm == null) {
			if (other.dealerNm != null)
				return false;
		} else if (!dealerNm.equals(other.dealerNm))
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (registrationDt == null) {
			if (other.registrationDt != null)
				return false;
		} else if (!registrationDt.equals(other.registrationDt))
			return false;
		return true;
	}

	public int getDealerCode() {
		return this.dealerCode;
	}

	public void setDealerCode(int dealerCode) {
		this.dealerCode = dealerCode;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDealerNm() {
		return this.dealerNm;
	}

	public void setDealerNm(String dealerNm) {
		this.dealerNm = dealerNm;
	}

	public Date getRegistrationDt() {
		return this.registrationDt;
	}

	public void setRegistrationDt(Date registrationDt) {
		this.registrationDt = registrationDt;
	}

	public int getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Set getServiceCenters() {
		return this.serviceCenters;
	}

	public void setServiceCenters(Set serviceCenters) {
		this.serviceCenters = serviceCenters;
	}

}
