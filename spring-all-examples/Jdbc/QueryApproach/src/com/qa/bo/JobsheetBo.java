package com.qa.bo;

import java.util.Date;

public class JobsheetBo {
	private int jobsheetNo;
	private Date openedDate;
	private String jobSheetType;
	private int kilometers;
	private int petrolLevel;
	private String engineNo;

	public int getJobsheetNo() {
		return jobsheetNo;
	}

	public void setJobsheetNo(int jobsheetNo) {
		this.jobsheetNo = jobsheetNo;
	}

	public Date getOpenedDate() {
		return openedDate;
	}

	public void setOpenedDate(Date openedDate) {
		this.openedDate = openedDate;
	}

	public String getJobSheetType() {
		return jobSheetType;
	}

	public void setJobSheetType(String jobSheetType) {
		this.jobSheetType = jobSheetType;
	}

	public int getKilometers() {
		return kilometers;
	}

	public void setKilometers(int kilometers) {
		this.kilometers = kilometers;
	}

	public int getPetrolLevel() {
		return petrolLevel;
	}

	public void setPetrolLevel(int petrolLevel) {
		this.petrolLevel = petrolLevel;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

}
