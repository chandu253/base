package com.ci.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ResourceAssignmentPK implements Serializable {
	@Column(name = "RESOURCE_NO")
	protected int resourceNo;
	@Column(name = "PROJECT_NO")
	protected int projectNo;

	public int getResourceNo() {
		return resourceNo;
	}

	public void setResourceNo(int resourceNo) {
		this.resourceNo = resourceNo;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + projectNo;
		result = prime * result + resourceNo;
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
		ResourceAssignmentPK other = (ResourceAssignmentPK) obj;
		if (projectNo != other.projectNo)
			return false;
		if (resourceNo != other.resourceNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResourceAssignmentPK [resourceNo=" + resourceNo + ", projectNo=" + projectNo + "]";
	}

}
