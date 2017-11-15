package com.cb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cb.model.Employee;
import com.cb.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService service;

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<Employee> listEmployees() {
		return service.findAllEmployees();
	}
	
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable("id") int id) {
		return service.findById(id);
	}
	
	@RequestMapping(value ="/employee", method = RequestMethod.POST)
	public String newEmployee(@RequestBody Employee employee) {
		//employee.setJoiningdate(new Date());
		service.save(employee);
		return "success";
	}
	
	@RequestMapping(value ="/employee", method = RequestMethod.PUT)
	public String updateEmployee(@RequestBody Employee employee){
		service.updateEmployee(employee);
		return "success";
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.DELETE)
	public String deleteEmployee(@RequestBody String id) {
		service.deleteEmployeeById(id);
		return "deleted successfully";
	}
	

}
