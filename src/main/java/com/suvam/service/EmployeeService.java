package com.suvam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suvam.model.Employee;
import com.suvam.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository empRepo;
	
	public List<Employee> getAllEmployees() {
		
		return empRepo.findAll();
	}

	public Employee getEmployeeById(Long empId) throws Exception {
		
		Employee employee= empRepo.findById(empId)
				.orElseThrow(()-> new Exception("no details found for this emp id."));
		return employee;
	}

	public Employee createEmployee(Employee emp) {
		
		return empRepo.save(emp);
	}

	public Employee updateEmployee(Long empId, Employee empData) throws Exception {
		Employee employee= empRepo.findById(empId)
				.orElseThrow(()-> new Exception("no details found for this emp id."));
		employee.setEmail(empData.getEmail());
		employee.setfName(empData.getfName());
		employee.setlName(empData.getlName());
		employee.setGender(empData.getGender());
		//employee.setId(empData.getId());
		return empRepo.save(employee);
	}

	public void deleteEmployee(Long empId) throws Exception {
		Employee employee= empRepo.findById(empId)
				.orElseThrow(()-> new Exception("no details found for this emp id."));
		 empRepo.delete(employee);
	}
}
