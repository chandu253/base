package com.automobiles.entities;
// default package

// Generated 7 Nov, 2017 11:55:14 PM by Hibernate Tools 5.2.6.Final

import java.util.HashSet;
import java.util.Set;

public class ServiceCenter implements java.io.Serializable {
	private int serviceCenterNo;
	private String serviceCenterNm;
	private int contactNo;
	private String emailAddress;
	private Address address;
	private Dealer dealer;
	private Set<Jobsheet> jobsheets;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + contactNo;
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((serviceCenterNm == null) ? 0 : serviceCenterNm.hashCode());
		result = prime * result + serviceCenterNo;
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
		ServiceCenter other = (ServiceCenter) obj;
		if (contactNo != other.contactNo)
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (serviceCenterNm == null) {
			if (other.serviceCenterNm != null)
				return false;
		} else if (!serviceCenterNm.equals(other.serviceCenterNm))
			return false;
		if (serviceCenterNo != other.serviceCenterNo)
			return false;
		return true;
	}

	public int getServiceCenterNo() {
		return this.serviceCenterNo;
	}

	public void setServiceCenterNo(int serviceCenterNo) {
		this.serviceCenterNo = serviceCenterNo;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Dealer getDealer() {
		return this.dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public String getServiceCenterNm() {
		return this.serviceCenterNm;
	}

	public void setServiceCenterNm(String serviceCenterNm) {
		this.serviceCenterNm = serviceCenterNm;
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

	public Set getJobsheets() {
		return this.jobsheets;
	}

	public void setJobsheets(Set jobsheets) {
		this.jobsheets = jobsheets;
	}

}
