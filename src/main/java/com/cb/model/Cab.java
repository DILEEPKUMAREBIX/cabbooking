package com.cb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "cabs", catalog = "cabbooking", uniqueConstraints = { @UniqueConstraint(columnNames = "cabid"),
		@UniqueConstraint(columnNames = "registrationNumber") })
public class Cab {

	private int cabid;
	private String registrationNumber;
	private int driverid;
	private String cabstatus;
	private String comments;
	private int vacancy;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cabid", unique = true, nullable = false)
	public int getCabid() {
		return cabid;
	}

	public void setCabid(int cabid) {
		this.cabid = cabid;
	}

	@Column(name = "registrationNumber", unique = true, nullable = false, length = 45)
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	@Column(name = "driverid", unique = true, nullable = false, length = 15)
	public int getDriverid() {
		return driverid;
	}

	public void setDriverid(int driverid) {
		this.driverid = driverid;
	}

	@Column(name = "cabstatus", nullable = false, length = 45)
	public String getCabstatus() {
		return cabstatus;
	}

	public void setCabstatus(String cabstatus) {
		this.cabstatus = cabstatus;
	}

	@Column(name = "comments", length = 145)
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(name = "vacancy", length = 45)
	public int getVacancy() {
		return vacancy;
	}

	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}

}
