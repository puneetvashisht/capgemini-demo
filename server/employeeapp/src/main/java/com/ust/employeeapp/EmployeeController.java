package com.ust.employeeapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ust.employeeapp.entities.Employee;
import com.ust.employeeapp.services.EmployeeService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	

	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> fetchEmployee(@PathVariable("id")int id){
		System.out.println("In Fetch employee: " + id);
		//service to fetch Employee by id
		//return that employeee
		ResponseEntity<Employee> re = null; 
		Employee employee = employeeService.findEmployeeById(id);
		if(employee==null){
			re = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		else{
			re = new ResponseEntity<>(employee, HttpStatus.OK);
		}
		return re;
		
		
//		Employee input = new Employee(23, "Vaishali", 34343.34);
//		return input;
	}
//	@DeleteMapping("/employees/{id}")
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({EmptyResultDataAccessException.class})
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id){
		
		ResponseEntity<String> re = null;
		try{
			employeeService.deleteEmployee(id);
			re = ResponseEntity.ok().body("employee has been deleted successfully.");
		}
		catch(EmptyResultDataAccessException e){
//			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
//		
		return re;
	}
	
	@GetMapping("/")
	public List<Employee> fetchAllEmployee(){
		return employeeService.fetchAllEmployees();
	}
	
	@PostMapping("/")
	public ResponseEntity<Void> addEmployee(@RequestBody Employee employee){
		if(employeeService.findByName(employee.name)){
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		 employeeService.addEmployee(employee);
		 return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
