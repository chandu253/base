package com.slc.entities;

import java.io.Serializable;

public class Advisor implements Serializable {
	protected int advisorNo;
	protected String firstName;
	protected String lastName;
	protected String qualification;
	protected int experience;
	protected int contactNo;
	protected String emailAddress;

	public int getAdvisorNo() {
		return advisorNo;
	}

	public void setAdvisorNo(int advisorNo) {
		this.advisorNo = advisorNo;
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

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + advisorNo;
		result = prime * result + contactNo;
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + experience;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((qualification == null) ? 0 : qualification.hashCode());
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
		Advisor other = (Advisor) obj;
		if (advisorNo != other.advisorNo)
			return false;
		if (contactNo != other.contactNo)
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (experience != other.experience)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (qualification == null) {
			if (other.qualification != null)
				return false;
		} else if (!qualification.equals(other.qualification))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Advisor [advisorNo=" + advisorNo + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", qualification=" + qualification + ", experience=" + experience + ", contactNo=" + contactNo
				+ ", emailAddress=" + emailAddress + "]";
	}

}
