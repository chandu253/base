package com.asf.bo;

import java.util.Date;

public class ConsignmentBo {
	protected int consignmentNo;
	protected Date consignmentDate;
	protected String description;
	protected String shipmentType;
	protected float weight;
	protected float amount;
	protected ContactBo fromContact;
	protected ContactBo toContact;

	public int getConsignmentNo() {
		return consignmentNo;
	}

	public void setConsignmentNo(int consignmentNo) {
		this.consignmentNo = consignmentNo;
	}

	public Date getConsignmentDate() {
		return consignmentDate;
	}

	public void setConsignmentDate(Date consignmentDate) {
		this.consignmentDate = consignmentDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShipmentType() {
		return shipmentType;
	}

	public void setShipmentType(String shipmentType) {
		this.shipmentType = shipmentType;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public ContactBo getFromContact() {
		return fromContact;
	}

	public void setFromContact(ContactBo fromContact) {
		this.fromContact = fromContact;
	}

	public ContactBo getToContact() {
		return toContact;
	}

	public void setToContact(ContactBo toContact) {
		this.toContact = toContact;
	}

}
