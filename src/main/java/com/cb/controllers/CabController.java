package com.cb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cb.model.Cab;
import com.cb.service.CabService;

@RestController
public class CabController {

	@Autowired
	CabService service;

	@RequestMapping(value = "/cabs/{id}", method = RequestMethod.GET)
	public Cab getCab(@PathVariable("id") int id) {
		return service.findById(id);
	}

/*	@RequestMapping(value = "/cab/", method = RequestMethod.GET)
	public Cab getCab1(@RequestParam int id) {
		return service.findById(id);
	}*/

	@RequestMapping(value = "/cabs", method = RequestMethod.GET)
	public List<Cab> listCabs() {
		return service.findAllCabs();
	}

	@RequestMapping(value = "/cabs", method = RequestMethod.POST)
	public String newCab(@RequestBody Cab cab) {
		service.save(cab);
		return "Success";
	}

	@RequestMapping(value = "/cabs", method = RequestMethod.PUT)
	public String updateCab(@RequestBody Cab cab) {
		service.updateCab(cab);
		return "success";
	}
	
	@RequestMapping(value = "/cabs/{id}/{status}", method = RequestMethod.PUT)
	public String updateCabStatus(@PathVariable int id, @PathVariable String status) {
		service.updateCabStatus(id, status);
		return "success";
	}

	@RequestMapping(value = "/cabs", method = RequestMethod.DELETE)
	public String deleteCab(@RequestBody String id) {
		service.deleteCabById(id);
		return "deleted successfully";
	}

	@RequestMapping("*")
	public String fallbackMethod() {
		return "Bad Request";
	}
}
