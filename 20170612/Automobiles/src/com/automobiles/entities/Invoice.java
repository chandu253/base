package com.automobiles.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Invoice implements java.io.Serializable {

	private int invoiceNo;
	private Jobsheet jobsheet;
	private Date invoiceDt;
	private int invoiceAmount;
	private Set<Bill> bills;
	private Set<RepairsConducted> repairsConducteds;

	public int getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Jobsheet getJobsheet() {
		return this.jobsheet;
	}

	public void setJobsheet(Jobsheet jobsheet) {
		this.jobsheet = jobsheet;
	}

	public Date getInvoiceDt() {
		return this.invoiceDt;
	}

	public void setInvoiceDt(Date invoiceDt) {
		this.invoiceDt = invoiceDt;
	}

	public int getInvoiceAmount() {
		return this.invoiceAmount;
	}

	public void setInvoiceAmount(int invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public Set getBills() {
		return this.bills;
	}

	public void setBills(Set bills) {
		this.bills = bills;
	}

	public Set getRepairsConducteds() {
		return this.repairsConducteds;
	}

	public void setRepairsConducteds(Set repairsConducteds) {
		this.repairsConducteds = repairsConducteds;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + invoiceAmount;
		result = prime * result + ((invoiceDt == null) ? 0 : invoiceDt.hashCode());
		result = prime * result + invoiceNo;
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
		Invoice other = (Invoice) obj;
		if (invoiceAmount != other.invoiceAmount)
			return false;
		if (invoiceDt == null) {
			if (other.invoiceDt != null)
				return false;
		} else if (!invoiceDt.equals(other.invoiceDt))
			return false;
		if (invoiceNo != other.invoiceNo)
			return false;
		return true;
	}

}
