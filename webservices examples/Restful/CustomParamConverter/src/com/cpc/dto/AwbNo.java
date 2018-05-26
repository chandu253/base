package com.cpc.dto;

public class AwbNo {
	protected int branch;
	protected int refNo;

	public AwbNo(int branch, int refNo) {
		this.branch = branch;
		this.refNo = refNo;
	}

	public int getBranch() {
		return branch;
	}

	public void setBranch(int branch) {
		this.branch = branch;
	}

	public int getRefNo() {
		return refNo;
	}

	public void setRefNo(int refNo) {
		this.refNo = refNo;
	}

}
