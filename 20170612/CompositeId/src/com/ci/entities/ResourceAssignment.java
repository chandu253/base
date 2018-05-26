package com.ci.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "RESOURCE_ASSIGNMENT")
public class ResourceAssignment implements Serializable {
	@EmbeddedId
	protected ResourceAssignmentPK id;
	@Column(name = "ASSIGNMENT_START_DT")
	protected Date assignmentStartDate;
	@Column(name = "ASSIGNMENT_END_DT")
	protected Date assignmentEndDate;
	protected String role;
	@Column(name = "ALLOCATION_PERCENTAGE")
	protected int allocationPercentage;

	public ResourceAssignmentPK getId() {
		return id;
	}

	public void setId(ResourceAssignmentPK id) {
		this.id = id;
	}

	public Date getAssignmentStartDate() {
		return assignmentStartDate;
	}

	public void setAssignmentStartDate(Date assignmentStartDate) {
		this.assignmentStartDate = assignmentStartDate;
	}

	public Date getAssignmentEndDate() {
		return assignmentEndDate;
	}

	public void setAssignmentEndDate(Date assignmentEndDate) {
		this.assignmentEndDate = assignmentEndDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getAllocationPercentage() {
		return allocationPercentage;
	}

	public void setAllocationPercentage(int allocationPercentage) {
		this.allocationPercentage = allocationPercentage;
	}

	@Override
	public String toString() {
		return "ResourceAssignment [id=" + id + ", assignmentStartDate=" + assignmentStartDate + ", assignmentEndDate="
				+ assignmentEndDate + ", role=" + role + ", allocationPercentage=" + allocationPercentage + "]";
	}

}
