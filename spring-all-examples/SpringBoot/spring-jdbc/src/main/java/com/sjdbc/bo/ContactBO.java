package com.sjdbc.bo;

public class ContactBO {
	protected int contactNo;
	protected String contactName;

	public ContactBO(int contactNo, String contactName) {
		super();
		this.contactNo = contactNo;
		this.contactName = contactName;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	@Override
	public String toString() {
		return "ContactBO [contactNo=" + contactNo + ", contactName=" + contactName + "]";
	}

}
