package com.suvam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suvam.model.Employee;
import com.suvam.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/demo")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployees() throws Exception {
		return empService.getAllEmployees();
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id")Long empId) throws Exception{
		return ResponseEntity.ok(empService.getEmployeeById(empId));
	}
	
	@PostMapping("/employee")
	private Employee createEmployee(@Valid @RequestBody Employee emp) {
		return empService.createEmployee(emp);
		
	}
	
	@PutMapping("/employee/{id}")
	private ResponseEntity<Employee> updateEmployee(@PathVariable(value="id")Long empId,@Valid @RequestBody Employee empData) throws Exception{
		return ResponseEntity.ok(empService.updateEmployee(empId,empData));
	}
	
	@DeleteMapping("/employee/{id}")
	private Map<String,Boolean> deleteEmployee(@PathVariable(value="id")Long empId) throws Exception {
		 empService.deleteEmployee(empId);
		 Map<String, Boolean> result=new HashMap<>();
		 result.put("deleted", true);
		 return result;
	}
	
}
