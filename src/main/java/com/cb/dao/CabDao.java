package com.cb.dao;

import java.util.List;

import com.cb.model.Cab;

public interface CabDao {

	void save(Cab cab);

	Cab findById(int id);

	List<Cab> findAllCabs();

	void deleteCabById(String id);
}
