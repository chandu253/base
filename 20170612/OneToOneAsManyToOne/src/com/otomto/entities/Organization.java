package com.otomto.entities;

import java.io.Serializable;
import java.util.Date;

public class Organization implements Serializable {
	protected int organizationNo;
	protected String organizationName;
	protected String description;
	protected Date establishedDate;
	protected String businessType;

	public int getOrganizationNo() {
		return organizationNo;
	}

	public void setOrganizationNo(int organizationNo) {
		this.organizationNo = organizationNo;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEstablishedDate() {
		return establishedDate;
	}

	public void setEstablishedDate(Date establishedDate) {
		this.establishedDate = establishedDate;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((businessType == null) ? 0 : businessType.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((establishedDate == null) ? 0 : establishedDate.hashCode());
		result = prime * result + ((organizationName == null) ? 0 : organizationName.hashCode());
		result = prime * result + organizationNo;
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
		Organization other = (Organization) obj;
		if (businessType == null) {
			if (other.businessType != null)
				return false;
		} else if (!businessType.equals(other.businessType))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (establishedDate == null) {
			if (other.establishedDate != null)
				return false;
		} else if (!establishedDate.equals(other.establishedDate))
			return false;
		if (organizationName == null) {
			if (other.organizationName != null)
				return false;
		} else if (!organizationName.equals(other.organizationName))
			return false;
		if (organizationNo != other.organizationNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Organization [organizationNo=" + organizationNo + ", organizationName=" + organizationName
				+ ", description=" + description + ", establishedDate=" + establishedDate + ", businessType="
				+ businessType + "]";
	}

}
