package com.training.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dao.EmployeeDao;
import com.training.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	
	public List<Employee> getEmployeeDetails(){
		return employeeDao.getEmployeeDetails();
	}
	
	public Employee updateEmployeeData(Employee employee){
		return employeeDao.updateEmployeeData(employee);
	}
	
	public void deleteData(int employeeId){
		employeeDao.deteleData(employeeId);
	}
	
	
}
