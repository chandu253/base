package com.automobiles.entities;

import java.util.Date;


public class JobsheetSparepart implements java.io.Serializable {

	private int sparepartNo;
	private Date sparepartSaleDt;
	private int amount;
	private Jobsheet jobsheet;
	private Sparepart sparepart;
	

	

	public int getSparepartNo() {
		return this.sparepartNo;
	}

	public void setSparepartNo(int sparepartNo) {
		this.sparepartNo = sparepartNo;
	}

	public Jobsheet getJobsheet() {
		return this.jobsheet;
	}

	public void setJobsheet(Jobsheet jobsheet) {
		this.jobsheet = jobsheet;
	}

	public Sparepart getSparepart() {
		return this.sparepart;
	}

	public void setSparepart(Sparepart sparepart) {
		this.sparepart = sparepart;
	}

	public Date getSparepartSaleDt() {
		return this.sparepartSaleDt;
	}

	public void setSparepartSaleDt(Date sparepartSaleDt) {
		this.sparepartSaleDt = sparepartSaleDt;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + sparepartNo;
		result = prime * result + ((sparepartSaleDt == null) ? 0 : sparepartSaleDt.hashCode());
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
		JobsheetSparepart other = (JobsheetSparepart) obj;
		if (amount != other.amount)
			return false;
		if (sparepartNo != other.sparepartNo)
			return false;
		if (sparepartSaleDt == null) {
			if (other.sparepartSaleDt != null)
				return false;
		} else if (!sparepartSaleDt.equals(other.sparepartSaleDt))
			return false;
		return true;
	}

}
