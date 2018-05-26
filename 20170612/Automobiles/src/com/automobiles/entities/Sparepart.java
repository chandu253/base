package com.automobiles.entities;

import java.util.Date;

public class Sparepart implements java.io.Serializable {

	private int sparepartNo;
	private String sparepartNm;
	private String modelNo;
	private Date purchaseDt;
	private int price;
	private JobsheetSparepart jobsheetSparepart;

	

	

	public int getSparepartNo() {
		return this.sparepartNo;
	}

	public void setSparepartNo(int sparepartNo) {
		this.sparepartNo = sparepartNo;
	}

	public String getSparepartNm() {
		return this.sparepartNm;
	}

	public void setSparepartNm(String sparepartNm) {
		this.sparepartNm = sparepartNm;
	}

	public String getModelNo() {
		return this.modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public Date getPurchaseDt() {
		return this.purchaseDt;
	}

	public void setPurchaseDt(Date purchaseDt) {
		this.purchaseDt = purchaseDt;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public JobsheetSparepart getJobsheetSparepart() {
		return this.jobsheetSparepart;
	}

	public void setJobsheetSparepart(JobsheetSparepart jobsheetSparepart) {
		this.jobsheetSparepart = jobsheetSparepart;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((modelNo == null) ? 0 : modelNo.hashCode());
		result = prime * result + price;
		result = prime * result + ((purchaseDt == null) ? 0 : purchaseDt.hashCode());
		result = prime * result + ((sparepartNm == null) ? 0 : sparepartNm.hashCode());
		result = prime * result + sparepartNo;
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
		Sparepart other = (Sparepart) obj;
		if (modelNo == null) {
			if (other.modelNo != null)
				return false;
		} else if (!modelNo.equals(other.modelNo))
			return false;
		if (price != other.price)
			return false;
		if (purchaseDt == null) {
			if (other.purchaseDt != null)
				return false;
		} else if (!purchaseDt.equals(other.purchaseDt))
			return false;
		if (sparepartNm == null) {
			if (other.sparepartNm != null)
				return false;
		} else if (!sparepartNm.equals(other.sparepartNm))
			return false;
		if (sparepartNo != other.sparepartNo)
			return false;
		return true;
	}

}
