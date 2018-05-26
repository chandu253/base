package com.ser.bean;

import java.io.Serializable;

public class CSubject implements Serializable {
	private static final long serialVersionUID = -7943077654934526972L;
	private int subjectNo;
	private int duration;

	public Object readResolve() {
		Subject subject = null;
		subject = new Subject();
		System.out.println("replacing object while deserializing");
		if (subjectNo == 1) {
			subject.setSubjectCode("Java");
		}
		subject.setDuration(duration);
		return subject;
	}

	public int getSubjectNo() {
		return subjectNo;
	}

	public void setSubjectNo(int subjectNo) {
		this.subjectNo = subjectNo;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "CSubject [subjectNo=" + subjectNo + ", duration=" + duration + "]";
	}

}
