package com.ser.bean;

import java.io.Serializable;

public class Subject implements Serializable {
	private static final long serialVersionUID = -7943077654934526972L;
	private String subjectCode;
	private int duration;

	public Object writeReplace() {
		CSubject cSubject = null;

		System.out.println("replacing the original object");
		cSubject = new CSubject();
		if (subjectCode != null) {
			if (subjectCode.equals("Java")) {
				cSubject.setSubjectNo(1);
			}
		}
		cSubject.setDuration(duration);
		return cSubject;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Subject [subjectCode=" + subjectCode + ", duration=" + duration + "]";
	}

}
