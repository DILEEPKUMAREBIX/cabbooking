package com.cb.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookingRequest {

	public String sourceLocation;
	public Date dateTimeOfJourney;
	public int employeeId;

	public String getSourceLocation() {
		return sourceLocation;
	}

	public void setSourceLocation(String sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	public Date getDateTimeOfJourney() {
		return dateTimeOfJourney;
	}

	public void setDateTimeOfJourney(Date dateTimeOfJourney) {
		this.dateTimeOfJourney = dateTimeOfJourney;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

}
