package com.fh.entities;

public class Mechanic {
	protected int mechanicNo;
	protected String firstName;
	protected String lastName;
	protected String specialization;
	protected int experience;
	protected String contactNo;
	protected String emailAddress;

	public int getMechanicNo() {
		return mechanicNo;
	}

	public void setMechanicNo(int mechanicNo) {
		this.mechanicNo = mechanicNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "Mechanic [mechanicNo=" + mechanicNo + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", specialization=" + specialization + ", experience=" + experience + ", contactNo=" + contactNo
				+ ", emailAddress=" + emailAddress + "]";
	}

}
