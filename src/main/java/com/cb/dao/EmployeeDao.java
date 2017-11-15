package com.cb.dao;

import java.util.List;

import com.cb.model.Employee;

public interface EmployeeDao {

	void save(Employee employee);
	
	Employee findById(int id);
	
	List<Employee> findAllEmployees();
	
	void deleteEmployeeById(String id);
}
