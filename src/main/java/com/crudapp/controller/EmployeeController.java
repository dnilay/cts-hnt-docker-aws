package com.crudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crudapp.dao.EmployeesRepository;
import com.crudapp.entity.Employees;

@RestController
public class EmployeeController {
	
	private EmployeesRepository employeesRepository;
	
	
	@Autowired
	public EmployeeController(EmployeesRepository employeesRepository) {
		this.employeesRepository = employeesRepository;
	}



	@PostMapping("/employees")
	public ResponseEntity<Employees> addUser(@RequestBody Employees employee){
		
		Employees userEntity =  employeesRepository.save(employee);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userEntity);
		
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employees>> getAllEmployees(){
		
		List<Employees> userEntity =  employeesRepository.findAll();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userEntity);
		
	}

}
