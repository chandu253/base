package com.otmsan.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "patient")
public class Patient implements Serializable {
	@Id
	@Column(name = "patient_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int patientNo;
	@Column(name = "patient_nm")
	protected String patientName;

	@OneToMany
	@JoinColumn(name = "PATIENT_NO")
	@IndexColumn(name = "appointment_order")
	protected List<Appointment> appointments;

	public int getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(int patientNo) {
		this.patientNo = patientNo;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

}
