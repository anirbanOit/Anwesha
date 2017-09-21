package com.example.crudexample.mockdata;

import java.util.ArrayList;
import java.util.List;

import com.example.crudexample.domain.entity.Employee;
import com.example.crudexample.domain.entity.Receipt;
import com.example.crudexample.dto.EmployeeDTO;
import com.example.crudexample.dto.ReceiptDTO;

public class MockData {
	
	//For Employee
	
	public static List<EmployeeDTO> getStubbedEmployeeDTOList() {
		List<EmployeeDTO> employeeDtos = new ArrayList<>();
		employeeDtos.add(getStubbedEmployeeDTO());
		employeeDtos.add(getStubbedEmployeeDTO());
		return employeeDtos;
	}
	
	public static EmployeeDTO getStubbedEmployeeDTO() {
		EmployeeDTO employeeDto = new EmployeeDTO();
		employeeDto.setAddress("testAddress");
		employeeDto.setAge(1);
		employeeDto.setName("testName");
		employeeDto.setZip("100011");
		return employeeDto;
	}
	
	public static List<Employee> getStubbedEmployeeList() {
		List<Employee> employees = new ArrayList<>();
		employees.add(getStubbedEmployee());
		employees.add(getStubbedEmployee());
		return employees;
	}
	
	public static Employee getStubbedEmployee() {
		Employee employee = new Employee();
		employee.setAddress("testAddress");
		employee.setAge(1);
		employee.setName("testName");
		employee.setZip("100011");
		return employee;
	}
	
	//For Receipt
	
	public static List<ReceiptDTO> getStubbedReceiptDTOList() {
		List<ReceiptDTO> receiptDtos = new ArrayList<>();
		receiptDtos.add(getStubbedReceiptDTO());
		receiptDtos.add(getStubbedReceiptDTO());
		return receiptDtos;
	}

	private static ReceiptDTO getStubbedReceiptDTO() {
		
		ReceiptDTO receiptDto=new ReceiptDTO();
		receiptDto.setReceipt_type("testReceiptType");
		receiptDto.setReceipt_amount(200.00);
		receiptDto.setReceipt_date("testDate");
		return receiptDto;
	}
	
	public static List<Receipt> getStubbedReceiptList() {
		List<Receipt> receipts = new ArrayList<>();
		receipts.add(getStubbedReceipt());
		receipts.add(getStubbedReceipt());
		return receipts;
	}

	private static Receipt getStubbedReceipt() {
		Receipt receipt=new Receipt();
		receipt.setEmpid(1);
		receipt.setReceipt_type("testReceiptType");
		receipt.setReceipt_amount(200.00);
		receipt.setReceipt_date("testDate");		
		return receipt;
	}
	
}
