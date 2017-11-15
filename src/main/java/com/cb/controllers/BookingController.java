package com.cb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cb.domain.BookingRequest;
import com.cb.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	BookingService service;
	
	@RequestMapping(value = "/request", method = RequestMethod.POST)
	public String requestBooking(@RequestBody BookingRequest request) {
		service.bookCab(request);
		return "";
	}
}
