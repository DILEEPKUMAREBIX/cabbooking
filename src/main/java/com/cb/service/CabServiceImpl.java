package com.cb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cb.dao.CabDao;
import com.cb.model.Cab;

@Service("cabService")
@Transactional
public class CabServiceImpl implements CabService {

	@Autowired
	CabDao dao;

	@Override
	public List<Cab> findAllCabs() {
		return dao.findAllCabs();
	}

	@Override
	public void save(Cab cab) {
		dao.save(cab);

	}

	@Override
	public void updateCab(Cab cab) {
		Cab cabEntity = dao.findById(cab.getCabid());
		if (cabEntity != null) {
			cabEntity.setCabstatus(cab.getCabstatus());
			cabEntity.setComments(cab.getComments());
			cabEntity.setVacancy(cab.getVacancy());
		}

	}

	@Override
	public void deleteCabById(String id) {
		dao.deleteCabById(id);

	}

	@Override
	public Cab findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void updateCabStatus(int id, String status) {
		Cab cabEntity = dao.findById(id);
		if (cabEntity != null) {
			cabEntity.setCabstatus(status);
		}
	}

}
