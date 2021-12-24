package com.example.controller;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {


    @Autowired
    private EmployeeService employeeService;



    @GetMapping("/employee")
    public Employee getAllEmployees() {
        return employeeService.getEmployeeByName("John");
    }

}
