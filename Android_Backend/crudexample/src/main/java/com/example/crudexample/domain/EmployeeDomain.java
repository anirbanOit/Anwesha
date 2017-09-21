package com.example.crudexample.domain;

import java.util.List;

import com.example.crudexample.domain.entity.Employee;

public interface EmployeeDomain {
	
	/**
	 * 
	 * @return List<Employee>
	 */
	List<Employee> getAllUsersProfile();
	
	Employee addUser(Employee employee);
}
