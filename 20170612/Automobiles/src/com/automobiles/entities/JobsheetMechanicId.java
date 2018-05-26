package com.automobiles.entities;


public class JobsheetMechanicId implements java.io.Serializable {

	private int mechanicNo;
	private int jobsheetNo;

	

	public int getMechanicNo() {
		return this.mechanicNo;
	}

	public void setMechanicNo(int mechanicNo) {
		this.mechanicNo = mechanicNo;
	}

	public int getJobsheetNo() {
		return this.jobsheetNo;
	}

	public void setJobsheetNo(int jobsheetNo) {
		this.jobsheetNo = jobsheetNo;
	}
	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof JobsheetMechanicId))
			return false;
		JobsheetMechanicId castOther = (JobsheetMechanicId) other;

		return (this.getMechanicNo() == castOther.getMechanicNo())
				&& (this.getJobsheetNo() == castOther.getJobsheetNo());
	}
@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getMechanicNo();
		result = 37 * result + this.getJobsheetNo();
		return result;
	}

}
