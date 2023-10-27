package com.gl.prj4.restapi.employeeMgmt.service;

import java.util.List;

import com.gl.prj4.restapi.employeeMgmt.entity.Employee;


public interface EmployeeService {
	
	public List<Employee> getEmployees();

	public Employee addNewEmployee(Employee employee);

	public Employee getEmployeeById(long id);

	public Employee updateEmployeeById(Employee employee, long id);

	public void deleteEmployeeById(long id);
	
	public List<Employee> fetchEmployeesSorted(String strDirection, String sortBy);

	public List<Employee> fetchEmployeesByFirstName(String firstName);

}
