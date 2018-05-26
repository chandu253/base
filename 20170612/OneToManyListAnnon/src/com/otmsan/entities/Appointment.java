package com.otmsan.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment implements Serializable {
	@Id
	@Column(name = "appointment_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int appointmentNo;
	@Column(name = "doctor_nm")
	protected String doctorName;

	@ManyToOne
	@JoinColumn(name = "patient_no")
	protected Patient patient;

	public int getAppointmentNo() {
		return appointmentNo;
	}

	public void setAppointmentNo(int appointmentNo) {
		this.appointmentNo = appointmentNo;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
