package com.pagination.bo;

import java.io.Serializable;
import java.util.Date;

public class AppointmentBo implements Serializable {
	protected int appointmentNo;
	protected Date appointmentDate;
	protected String doctorName;
	protected String patientName;

	public int getAppointmentNo() {
		return appointmentNo;
	}

	public void setAppointmentNo(int appointmentNo) {
		this.appointmentNo = appointmentNo;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

}
