package com.automobiles.entities;

import java.util.Date;

import java.util.Set;

public class Jobsheet implements java.io.Serializable {

	private int jobsheetNo;
	private Advisor advisor;
	private Customer customer;
	private ServiceCenter serviceCenter;
	private Vehicle vehicle;
	private Date openedDt;
	private int kilometers;
	private String petrolLevel;
	private String jobSheetType;
	private int estimatedAmount;
	private Date deliveryEta;
	private String status;
	private Set<JobsheetRepairs> jobsheetRepairses;
	private Set<JobsheetSparepart> jobsheetSpareparts;
	private Set<JobsheetMechanic> jobsheetMechanics;
	private Set<Invoice> invoices;

	public int getJobsheetNo() {
		return this.jobsheetNo;
	}

	public void setJobsheetNo(int jobsheetNo) {
		this.jobsheetNo = jobsheetNo;
	}

	public Advisor getAdvisor() {
		return this.advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ServiceCenter getServiceCenter() {
		return this.serviceCenter;
	}

	public void setServiceCenter(ServiceCenter serviceCenter) {
		this.serviceCenter = serviceCenter;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Date getOpenedDt() {
		return this.openedDt;
	}

	public void setOpenedDt(Date openedDt) {
		this.openedDt = openedDt;
	}

	public int getKilometers() {
		return this.kilometers;
	}

	public void setKilometers(int kilometers) {
		this.kilometers = kilometers;
	}

	public String getPetrolLevel() {
		return this.petrolLevel;
	}

	public void setPetrolLevel(String petrolLevel) {
		this.petrolLevel = petrolLevel;
	}

	public String getJobSheetType() {
		return this.jobSheetType;
	}

	public void setJobSheetType(String jobSheetType) {
		this.jobSheetType = jobSheetType;
	}

	public int getEstimatedAmount() {
		return this.estimatedAmount;
	}

	public void setEstimatedAmount(int estimatedAmount) {
		this.estimatedAmount = estimatedAmount;
	}

	public Date getDeliveryEta() {
		return deliveryEta;
	}

	public void setDeliveryEta(Date deliveryEta) {
		this.deliveryEta = deliveryEta;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set getJobsheetRepairses() {
		return this.jobsheetRepairses;
	}

	public void setJobsheetRepairses(Set jobsheetRepairses) {
		this.jobsheetRepairses = jobsheetRepairses;
	}

	public Set getJobsheetSpareparts() {
		return this.jobsheetSpareparts;
	}

	public void setJobsheetSpareparts(Set jobsheetSpareparts) {
		this.jobsheetSpareparts = jobsheetSpareparts;
	}

	public Set getJobsheetMechanics() {
		return this.jobsheetMechanics;
	}

	public void setJobsheetMechanics(Set jobsheetMechanics) {
		this.jobsheetMechanics = jobsheetMechanics;
	}

	public Set getInvoices() {
		return this.invoices;
	}

	public void setInvoices(Set invoices) {
		this.invoices = invoices;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deliveryEta == null) ? 0 : deliveryEta.hashCode());
		result = prime * result + estimatedAmount;
		result = prime * result + ((jobSheetType == null) ? 0 : jobSheetType.hashCode());
		result = prime * result + jobsheetNo;
		result = prime * result + kilometers;
		result = prime * result + ((openedDt == null) ? 0 : openedDt.hashCode());
		result = prime * result + ((petrolLevel == null) ? 0 : petrolLevel.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Jobsheet other = (Jobsheet) obj;
		if (deliveryEta == null) {
			if (other.deliveryEta != null)
				return false;
		} else if (!deliveryEta.equals(other.deliveryEta))
			return false;
		if (estimatedAmount != other.estimatedAmount)
			return false;
		if (jobSheetType == null) {
			if (other.jobSheetType != null)
				return false;
		} else if (!jobSheetType.equals(other.jobSheetType))
			return false;
		if (jobsheetNo != other.jobsheetNo)
			return false;
		if (kilometers != other.kilometers)
			return false;
		if (openedDt == null) {
			if (other.openedDt != null)
				return false;
		} else if (!openedDt.equals(other.openedDt))
			return false;
		if (petrolLevel == null) {
			if (other.petrolLevel != null)
				return false;
		} else if (!petrolLevel.equals(other.petrolLevel))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

}
