package com.cb.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cb.dao.BookingDao;
import com.cb.dao.CabDao;
import com.cb.domain.BookingRequest;
import com.cb.model.Cab;
import com.cb.model.Request;

@Service("bookingService")
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	CabDao cabDao;

	@Autowired
	BookingDao bookingDao;

	@Override
	public void bookCab(BookingRequest request) {

		if (checkCabsAvailable() && validateBookingTime(request) && validateBookingDate(request)) {
			Request requestVo = new Request();

			requestVo.setSourceLocation(request.getSourceLocation());
			requestVo.setDateTimeOfJourney(request.getDateTimeOfJourney());
			requestVo.setRequestCreationDate(new Date());
			requestVo.setRequestGenerator(request.getEmployeeId());
			requestVo.setRequestStatus("CONFIRMED");

			bookingDao.saveRequest(requestVo);
		}
	}

	public boolean checkCabsAvailable() {
		List<Cab> allCabs = cabDao.findAllCabs();
		for (Cab cab : allCabs) {
			if (cab.getCabstatus().equals("available")) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	public boolean validateBookingTime(BookingRequest request) {
		long hours = request.getDateTimeOfJourney().getHours();
		long mins = request.getDateTimeOfJourney().getMinutes();

		if ((hours >= 22 && hours <= 24) || hours <= 1)
			return true;
		else
			return false;

	}

	public boolean validateBookingDate(BookingRequest request) {
		long diff = request.getDateTimeOfJourney().getTime() - new Date().getTime();
		long diffHours = diff / (60 * 60 * 1000);
		if (diffHours > 12 && diffHours < 48)
			return true;
		else
			return false;

	}

}
