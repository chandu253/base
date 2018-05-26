package com.mtms.entities;

import java.io.Serializable;
import java.util.Set;

public class Job implements Serializable {
	protected int jobNo;
	protected String title;
	protected String description;
	protected int positions;
	protected Set<Member> applicants;

	public int getJobNo() {
		return jobNo;
	}

	public void setJobNo(int jobNo) {
		this.jobNo = jobNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPositions() {
		return positions;
	}

	public void setPositions(int positions) {
		this.positions = positions;
	}

	public Set<Member> getApplicants() {
		return applicants;
	}

	public void setApplicants(Set<Member> applicants) {
		this.applicants = applicants;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + jobNo;
		result = prime * result + positions;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Job other = (Job) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (jobNo != other.jobNo)
			return false;
		if (positions != other.positions)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Job [jobNo=" + jobNo + ", title=" + title + ", description=" + description + ", positions=" + positions
				+ ", applicants=" + applicants + "]";
	}

}
