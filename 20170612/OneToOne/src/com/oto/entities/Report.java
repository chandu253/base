package com.oto.entities;

import java.io.Serializable;
import java.util.Date;

public class Report implements Serializable {
	protected int candidateNo;
	protected Date reportDate;
	protected String interviewerName;
	protected int rating;
	protected String comments;
	// associated object (representing candidate for which we are creating this
	// report)
	protected Candidate candidate;

	public int getCandidateNo() {
		return candidateNo;
	}

	public void setCandidateNo(int candidateNo) {
		this.candidateNo = candidateNo;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getInterviewerName() {
		return interviewerName;
	}

	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + candidateNo;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((interviewerName == null) ? 0 : interviewerName.hashCode());
		result = prime * result + rating;
		result = prime * result + ((reportDate == null) ? 0 : reportDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Report other = (Report) obj;
		if (candidateNo != other.candidateNo)
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (interviewerName == null) {
			if (other.interviewerName != null)
				return false;
		} else if (!interviewerName.equals(other.interviewerName))
			return false;
		if (rating != other.rating)
			return false;
		if (reportDate == null) {
			if (other.reportDate != null)
				return false;
		} else if (!reportDate.equals(other.reportDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Report [candidateNo=" + candidateNo + ", reportDate=" + reportDate + ", interviewerName="
				+ interviewerName + ", rating=" + rating + ", comments=" + comments + ", candidate=" + candidate + "]";
	}

}
