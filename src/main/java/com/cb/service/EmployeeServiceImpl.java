package com.cb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cb.dao.EmployeeDao;
import com.cb.model.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao dao;

	public void save(Employee employee) {
		dao.save(employee);
	}
	
	/*
	 * Since the method is running with Transaction, No need to call hibernate
	 * update explicitly. Just fetch the entity from db and update it with
	 * proper values within transaction. It will be updated in db once
	 * transaction ends.
	 */
	public void updateEmployee(Employee employee) {
		Employee entity = dao.findById(employee.getId());
		if (entity != null) {
			entity.setFullname(employee.getFullname());
			entity.setDesignation(employee.getDesignation());
			entity.setPhone(employee.getPhone());
			entity.setEmail(employee.getEmail());
		}
	}
	
	public List<Employee> findAllEmployees() {
		return dao.findAllEmployees();
	}
	
	public void deleteEmployeeById(String id) {
		dao.deleteEmployeeById(id);
	}
	
	public Employee findById(int id) {
		return dao.findById(id);
	}

}
