package com.cb.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cb.model.Cab;

@Repository("cabDao")
public class CabDaoImpl extends AbstractDao<Integer, Cab> implements CabDao {

	@Override
	public void save(Cab cab) {
		persist(cab);
	}

	@Override
	public Cab findById(int id) {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cab> findAllCabs() {
		Criteria criteria = createEntityCriteria();
		List<Cab> cabs = (List<Cab>) criteria.list();
		return cabs;
	}

	@Override
	public void deleteCabById(String id) {
		Query query = getSession().createQuery("delete from Cab where cabid=:id");
		query.setString(id, id);
		query.executeUpdate();
	}

}
