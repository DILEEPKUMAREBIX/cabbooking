package com.cb.dao;

import org.springframework.stereotype.Repository;

import com.cb.model.Request;

@Repository("bookingDao")
public class BookingDaoImpl extends AbstractDao<Integer, Request> implements BookingDao {

	@Override
	public int saveRequest(Request request) {

		int i = (int) getSession().save(request);
		return i;
	}

}
