package com.automobiles.bo;

import java.util.Date;

public class BillBo {
	private int billNo;
	private Date billDate;
	private int amount;

	public BillBo(int billNo, Date billDate, int amount) {
		super();
		this.billNo = billNo;
		this.billDate = billDate;
		this.amount = amount;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "BillBo [billNo=" + billNo + ", billDate=" + billDate + ", amount=" + amount + "]";
	}

}
