package com.cb.service;

import java.util.List;

import com.cb.model.Cab;

public interface CabService {

	List<Cab> findAllCabs();
	void save(Cab cab);
	void updateCab(Cab cab);
	void deleteCabById(String id);
	Cab findById(int id);
	void updateCabStatus(int id, String status);
}
