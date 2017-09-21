package com.example.crudexample.handler;

import java.util.List;

import com.example.crudexample.dto.EmployeeDTO;
import com.example.crudexample.dto.StatusDTO;

public interface EmployeeHandler {
	
	/**
	 * 
	 * @param errorCodePrefix
	 * @return EmployeeDTO
	 */
	List<EmployeeDTO> performGetUsersProfileDetail(String errorCodePrefix);

	StatusDTO performAddUser(String errorCodePrefix, EmployeeDTO employeeDTO);
}
