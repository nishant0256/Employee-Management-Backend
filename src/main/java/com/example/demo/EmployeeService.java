package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repo;

	public void saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		repo.save(emp);
	}

	public List<Employee> getList() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Employee getEmployee(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);;
	}

	public void updateEmployee(Employee emp, Long id) {
		// TODO Auto-generated method stub
		Employee empl = repo.findById(id).orElse(null);
		if(empl!=null) {
			empl.setName(emp.getName());
			empl.setSalary(emp.getSalary());
			
			 repo.save(empl);
		}else {
			throw new RuntimeException("Employee not found with id "+id);
		}
	}

	

	
}
