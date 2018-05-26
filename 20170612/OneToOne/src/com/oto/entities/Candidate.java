package com.oto.entities;

import java.io.Serializable;
import java.util.Date;

public class Candidate implements Serializable {
	protected int candidateNo;
	protected String candidateName;
	protected Date appearedDate;
	protected String appliedFor;
	protected String contactNo;
	protected String emailAddress;

	public int getCandidateNo() {
		return candidateNo;
	}

	public void setCandidateNo(int candidateNo) {
		this.candidateNo = candidateNo;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public Date getAppearedDate() {
		return appearedDate;
	}

	public void setAppearedDate(Date appearedDate) {
		this.appearedDate = appearedDate;
	}

	public String getAppliedFor() {
		return appliedFor;
	}

	public void setAppliedFor(String appliedFor) {
		this.appliedFor = appliedFor;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appearedDate == null) ? 0 : appearedDate.hashCode());
		result = prime * result + ((appliedFor == null) ? 0 : appliedFor.hashCode());
		result = prime * result + ((candidateName == null) ? 0 : candidateName.hashCode());
		result = prime * result + candidateNo;
		result = prime * result + ((contactNo == null) ? 0 : contactNo.hashCode());
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
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
		Candidate other = (Candidate) obj;
		if (appearedDate == null) {
			if (other.appearedDate != null)
				return false;
		} else if (!appearedDate.equals(other.appearedDate))
			return false;
		if (appliedFor == null) {
			if (other.appliedFor != null)
				return false;
		} else if (!appliedFor.equals(other.appliedFor))
			return false;
		if (candidateName == null) {
			if (other.candidateName != null)
				return false;
		} else if (!candidateName.equals(other.candidateName))
			return false;
		if (candidateNo != other.candidateNo)
			return false;
		if (contactNo == null) {
			if (other.contactNo != null)
				return false;
		} else if (!contactNo.equals(other.contactNo))
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Candidate [candidateNo=" + candidateNo + ", candidateName=" + candidateName + ", appearedDate="
				+ appearedDate + ", appliedFor=" + appliedFor + ", contactNo=" + contactNo + ", emailAddress="
				+ emailAddress + "]";
	}

}
