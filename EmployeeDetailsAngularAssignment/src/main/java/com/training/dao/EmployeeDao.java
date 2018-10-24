package com.training.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.training.model.Employee;

@Repository
public class EmployeeDao {
	
	@PersistenceContext 
	EntityManager entityManager;
	
	public List<Employee> getEmployeeDetails(){
		Query query = entityManager.createQuery("from Employee");
		List<Employee> employeeList = query.getResultList();
		return employeeList;
	}
	
	@Transactional
	public Employee updateEmployeeData(Employee employee){
		Employee e = entityManager.merge(employee);
		return e;
	}
	
	@Transactional
	public void deteleData(int employeeId){
		Employee employee = entityManager.find(Employee.class, employeeId);
		entityManager.remove(employee);
	}

}
