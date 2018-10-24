package com.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.core.Response;
import com.training.model.Employee;
import com.training.service.EmployeeService;

@RestController
//@CrossOrigin(origins = "http://localhost:8083")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping(value="/employeeDetails",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployeeDetails(){
		return employeeService.getEmployeeDetails();/*Response.ok().entity(employeeService.getEmployeeDetails()).header("Access-Control-Allow-Origin", "*")
    			.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
    			.build();*/

	}
	
	@PutMapping(value="/updateData", consumes=MediaType.APPLICATION_JSON_VALUE ,produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee updateEmployeeData(@RequestBody Employee employee){
		return employeeService.updateEmployeeData(employee);
	}
	
	@DeleteMapping(value="/deleteData/{employeeId}")
	public void deleteData(@PathVariable int employeeId){
		employeeService.deleteData(employeeId);
	}
}
