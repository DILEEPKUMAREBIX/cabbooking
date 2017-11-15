package com.cb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "cabrequest", catalog = "cabbooking", uniqueConstraints = {
		@UniqueConstraint(columnNames = "requestid") })
public class Request {

	public int requestId;
	public String requestStatus;
	public String comments;
	public int bookingid;
	public String sourceLocation;
	public Date dateTimeOfJourney;
	public Date requestCreationDate;
	public int requestGenerator;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "requestId", unique = true, nullable = false)
	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	@Column(name = "requestStatus", unique = true, nullable = false, length = 45)
	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	@Column(name = "comments", unique = true, nullable = false, length = 145)
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(name = "bookingid", unique = true, nullable = false, length = 45)
	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	@Column(name = "sourceLocation", unique = true, nullable = false, length = 45)
	public String getSourceLocation() {
		return sourceLocation;
	}

	public void setSourceLocation(String sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "dateTimeOfJourney", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
	public Date getDateTimeOfJourney() {
		return dateTimeOfJourney;
	}

	public void setDateTimeOfJourney(Date dateTimeOfJourney) {
		this.dateTimeOfJourney = dateTimeOfJourney;
	}

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "requestCreationDate", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
	public Date getRequestCreationDate() {
		return requestCreationDate;
	}

	public void setRequestCreationDate(Date requestCreationDate) {
		this.requestCreationDate = requestCreationDate;
	}

	@Column(name = "requestGenerator", unique = true, nullable = false, length = 45)
	public int getRequestGenerator() {
		return requestGenerator;
	}

	public void setRequestGenerator(int requestGenerator) {
		this.requestGenerator = requestGenerator;
	}

}
