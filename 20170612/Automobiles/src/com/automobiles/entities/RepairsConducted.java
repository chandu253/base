package com.automobiles.entities;


public class RepairsConducted implements java.io.Serializable {

	private int repairConductedNo;
	
	private String repairConducted;
	private int repairCharges;
	private Invoice invoice;
	

	

	public int getRepairConductedNo() {
		return this.repairConductedNo;
	}

	public void setRepairConductedNo(int repairConductedNo) {
		this.repairConductedNo = repairConductedNo;
	}

	public Invoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public String getRepairConducted() {
		return this.repairConducted;
	}

	public void setRepairConducted(String repairConducted) {
		this.repairConducted = repairConducted;
	}

	public int getRepairCharges() {
		return this.repairCharges;
	}

	public void setRepairCharges(int repairCharges) {
		this.repairCharges = repairCharges;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + repairCharges;
		result = prime * result + ((repairConducted == null) ? 0 : repairConducted.hashCode());
		result = prime * result + repairConductedNo;
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
		RepairsConducted other = (RepairsConducted) obj;
		if (repairCharges != other.repairCharges)
			return false;
		if (repairConducted == null) {
			if (other.repairConducted != null)
				return false;
		} else if (!repairConducted.equals(other.repairConducted))
			return false;
		if (repairConductedNo != other.repairConductedNo)
			return false;
		return true;
	}

}
