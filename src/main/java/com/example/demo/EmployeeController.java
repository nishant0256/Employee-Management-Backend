package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
@CrossOrigin
public class EmployeeController {
	
	@Autowired
	EmployeeService serv;

	@PostMapping("/")
	public void createEmployee(@RequestBody Employee emp) {
		serv.saveEmployee(emp);
	}
	
	@GetMapping("/")
	public List<Employee> getEmplpyeeList(){
		return serv.getList();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable Long id) {
		return serv.getEmployee(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deltEmployee(@PathVariable Long id) {
		serv.deleteEmployee(id);
	}
	
	@PutMapping("/{id}")
	public void updtEmployee(@RequestBody Employee emp, @PathVariable Long id) {
		 serv.updateEmployee(emp,id);
	}
}
