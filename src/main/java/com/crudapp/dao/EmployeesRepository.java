package com.crudapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudapp.entity.Employees;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

	Employees findByEmail(String email);

}
