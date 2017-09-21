package com.example.crudexample.feature.employee.bean;

import com.example.crudexample.api.message.response.AbstractResponse;
import com.example.crudexample.dto.EmployeeDTO;

public interface EmployeeBean {
	
	/**
	 * 
	 * @param accessorId
	 * @param sessionToken
	 * @return AbstractResponse - List of all Users
	 */
	AbstractResponse processGetAllUserProfile(String accessorId, String sessionToken);

	AbstractResponse processAddUser(String sessionToken, EmployeeDTO employeeDTO);

	AbstractResponse processDeleteUserProfile(String accessorIdStr, String sessionToken);

	AbstractResponse processGetUserProfile(String accessorIdStr, String sessionToken);
	
}
