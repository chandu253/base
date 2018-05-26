package com.automobiles.entities;


public class JobsheetRepairs implements java.io.Serializable {

	private int repairId;
	private Jobsheet jobsheet;
	private String repair;

	

	public int getRepairId() {
		return this.repairId;
	}

	public void setRepairId(int repairId) {
		this.repairId = repairId;
	}

	public Jobsheet getJobsheet() {
		return this.jobsheet;
	}

	public void setJobsheet(Jobsheet jobsheet) {
		this.jobsheet = jobsheet;
	}

	public String getRepair() {
		return this.repair;
	}

	public void setRepair(String repair) {
		this.repair = repair;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((repair == null) ? 0 : repair.hashCode());
		result = prime * result + repairId;
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
		JobsheetRepairs other = (JobsheetRepairs) obj;
		if (repair == null) {
			if (other.repair != null)
				return false;
		} else if (!repair.equals(other.repair))
			return false;
		if (repairId != other.repairId)
			return false;
		return true;
	}

	

}
