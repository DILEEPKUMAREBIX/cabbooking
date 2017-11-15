package com.cb.service;

import java.util.List;

import com.cb.model.Employee;

public interface EmployeeService {

	List<Employee> findAllEmployees();
	void save(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployeeById(String id);
	Employee findById(int id);
}
