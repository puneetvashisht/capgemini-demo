package com.ust.employeeapp.services;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.ust.employeeapp.entities.Employee;


@Repository
public class EmployeeRepository {
	
	List<Employee> employees = new ArrayList<>();


	@PostConstruct
	public void init(){
//		Address address1 = new Address(23, "gk", "delhi");
		Employee e1 = new Employee(21, "Ravi", 30000.00);
		Employee e2 = new Employee(18, "Priya", 50000.00);
		Employee e3 = new Employee(2, "Amit", 20000.00);
	
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
	}

	public List<Employee> findAllEmployees() {
		return employees;
	}

	public int addEmployee(Employee input) {
		this.employees.add(input);
		System.out.println(employees.size());
		return this.employees.size();
		
	}

	public boolean findById(int id) {
		return this.employees.stream()
		.anyMatch((e)->e.id == id);
	}

	

}

