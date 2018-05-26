package com.jg.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "project")
public class Project implements Serializable {
	@Id
	@Column(name = "project_no")
	/*
	 * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	 * "advisor_seq_generator")
	 * 
	 * @SequenceGenerator(name = "advisor_seq_generator", sequenceName =
	 * "advisor_seq", initialValue = 1, allocationSize = 1)
	 */
	/*
	 * @GeneratedValue(strategy = GenerationType.TABLE, generator =
	 * "advisor_tab_generator")
	 * 
	 * @TableGenerator(name = "advisor_tab_generator", table = "advisor_unique",
	 * pkColumnName = "advisor_no", pkColumnValue = "advisor", valueColumnName =
	 * "next_advisor_no")
	 */

	@GeneratedValue(generator = "hilo_generator")
	@GenericGenerator(name = "hilo_generator", strategy = "hilo", parameters = {
			@Parameter(name = "max_lo", value = "10") })
	protected int projectNo;
	protected String title;
	protected String description;
	protected String domain;
	protected int duration;

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		result = prime * result + duration;
		result = prime * result + projectNo;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Project other = (Project) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (domain == null) {
			if (other.domain != null)
				return false;
		} else if (!domain.equals(other.domain))
			return false;
		if (duration != other.duration)
			return false;
		if (projectNo != other.projectNo)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Project [projectNo=" + projectNo + ", title=" + title + ", description=" + description + ", domain="
				+ domain + ", duration=" + duration + "]";
	}

}
