package com.csc.delegate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.context.internal.ManagedSessionContext;

import com.csc.dao.AppointmentDao;
import com.csc.dao.PatientDao;
import com.csc.entities.Appointment;
import com.csc.entities.Patient;
import com.csc.util.SessionFactoryRegistry;

public class AppointmentDelegate {

	public int bookAppointment(Patient patient, Appointment appointment) {
		int patientNo = 0;
		int appointmentNo = 0;
		PatientDao patientDao = null;
		AppointmentDao appointmentDao = null;
		Transaction transaction = null;
		boolean flag = false;
		Session session = null;

		try {
			session = SessionFactoryRegistry.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			ManagedSessionContext.bind(session);
			patientDao = new PatientDao();
			patientNo = patientDao.savePatient(patient);
			patientNo = -1; // non-existing patient

			appointment.setPatientNo(patientNo);
			appointmentDao = new AppointmentDao();
			appointmentNo = appointmentDao.saveAppointment(appointment);
			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			ManagedSessionContext.unbind(SessionFactoryRegistry.getSessionFactory());
		}
		return appointmentNo;
	}
}
