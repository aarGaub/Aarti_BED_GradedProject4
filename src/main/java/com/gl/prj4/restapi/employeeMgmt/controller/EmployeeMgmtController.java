package com.gl.prj4.restapi.employeeMgmt.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gl.prj4.restapi.employeeMgmt.entity.Employee;
import com.gl.prj4.restapi.employeeMgmt.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/employees")
public class EmployeeMgmtController {

	@Autowired
	private EmployeeServiceImpl empSrvc;

	@GetMapping("/{empId}")
	public Employee fetchEmployeeById(@PathVariable("empId") long empId) {
		return this.empSrvc.getEmployeeById(empId);
	}

	@GetMapping("/search/{firstName}")
	public List<Employee> fetchEmployeesByName(@PathVariable("firstName") String firstName) {
		return this.empSrvc.fetchEmployeesByFirstName(firstName);
	}

	@GetMapping
	public List<Employee> fetchAllEmployees() {
		return this.empSrvc.getEmployees();
	}

	@GetMapping("/sort")
	public List<Employee> fetchEmployees(
			@RequestParam(name = "order", required = false, defaultValue = "asc") String strDirection,
			@RequestParam(name = "field", required = false, defaultValue = "firstName") String sortBy) {
		return this.empSrvc.fetchEmployeesSorted(strDirection, sortBy);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Employee saveEmployee(@RequestBody Employee emp) {
		return empSrvc.addNewEmployee(emp);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Employee updateEmployeeById(@RequestBody Employee employee, @PathVariable("id") long id) {
		return this.empSrvc.updateEmployeeById(employee, id);
	}

	@DeleteMapping("/{id}")
	// @ResponseStatus(HttpStatus.NO_CONTENT)
	public String deleteEmployeeById(@PathVariable long id) {
		this.empSrvc.deleteEmployeeById(id);
		return "Deleted Employee Id : " + id + ".";
	}

}
