package com.cb.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cb.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao{

	public void save(Employee employee) {
		persist(employee);
	}

	public Employee findById(int id) {
		return getByKey(id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		
		Criteria criteria = createEntityCriteria();
		List<Employee> employees = (List<Employee>) criteria.list();
		return employees;
	}
	
	
	public void deleteEmployeeById(String id) {
        Query query = getSession().createSQLQuery("delete from Employee where id = :id");
        query.setString("id", id);
        query.executeUpdate();
    }
}
