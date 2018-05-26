package com.csc.test;

import java.util.Date;

import com.csc.delegate.AppointmentDelegate;
import com.csc.entities.Appointment;
import com.csc.entities.Patient;
import com.csc.util.SessionFactoryRegistry;

public class CSCTest {
	public static void main(String[] args) {
		AppointmentDelegate delegate = null;
		Patient patient = null;
		Appointment appointment = null;

		try {
			patient = new Patient();
			patient.setPatientName("Raghu");
			patient.setContactNo("9199248393");
			patient.setEmailAddress("raghu@gmail.com");
			patient.setAge(23);
			patient.setGender("M");

			appointment = new Appointment();
			appointment.setDoctorName("Ravi");
			appointment.setAppointmentDate(new Date());
			appointment.setComments("Fever");

			delegate = new AppointmentDelegate();
			int appointmentNo = delegate.bookAppointment(patient, appointment);
			System.out.println("appointmentNo : " + appointmentNo);
		} finally {
			SessionFactoryRegistry.closeSessionFactory();
		}
	}
}
