package com.mtms.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class Member implements Serializable {
	@Id
	@Column(name = "member_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int memberNo;
	@Column(name = "first_nm")
	protected String firstName;
	@Column(name = "last_nm")
	protected String lastName;
	protected String qualification;
	protected int experience;

	@ManyToMany
	@JoinTable(name = "job_members", joinColumns = { @JoinColumn(name = "member_no") }, inverseJoinColumns = {
			@JoinColumn(name = "job_no") })
	protected Set<Job> appliedJobs;

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
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

	/*
	 * public Set<Job> getAppliedJobs() { return appliedJobs; }
	 * 
	 * public void setAppliedJobs(Set<Job> appliedJobs) { this.appliedJobs =
	 * appliedJobs; }
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + experience;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + memberNo;
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
		Member other = (Member) obj;
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
		if (memberNo != other.memberNo)
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
		return "Member [memberNo=" + memberNo + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", qualification=" + qualification + ", experience=" + experience + "]";
	}

}
