package com.automobiles.entities;


public class JobsheetMechanic implements java.io.Serializable {

	private int jobsheetMechanicid;
	private Jobsheet jobsheet;
	private Mechanic mechanic;
	private int duration;
	private String comments;

	

	

	public int getJobsheetMechanicid() {
		return jobsheetMechanicid;
	}

	public void setJobsheetMechanicid(int jobsheetMechanicid) {
		this.jobsheetMechanicid = jobsheetMechanicid;
	}

	public Jobsheet getJobsheet() {
		return this.jobsheet;
	}

	public void setJobsheet(Jobsheet jobsheet) {
		this.jobsheet = jobsheet;
	}

	public Mechanic getMechanic() {
		return this.mechanic;
	}

	public void setMechanic(Mechanic mechanic) {
		this.mechanic = mechanic;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + duration;
		result = prime * result + jobsheetMechanicid;
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
		JobsheetMechanic other = (JobsheetMechanic) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (duration != other.duration)
			return false;
		if (jobsheetMechanicid != other.jobsheetMechanicid)
			return false;
		return true;
	}

	

}
