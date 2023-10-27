package com.gl.prj4.restapi.employeeMgmt.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gl.prj4.restapi.employeeMgmt.dao.EmployeeRepository;
import com.gl.prj4.restapi.employeeMgmt.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	@Override
	public List<Employee> getEmployees() {
		return empRepo.findAll();
	}

	@Override
	public Employee addNewEmployee(Employee employee) {
		return empRepo.save(employee);

	}

	@Override
	public Employee getEmployeeById(long id) {
		return this.empRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Ticket Id"));

	}

	@Override
	public Employee updateEmployeeById(Employee employee, long id) {
		Employee e = this.getEmployeeById(id);
		e.setFirstName(employee.getFirstName());
		e.setLastName(employee.getLastName());
		e.setEmail(employee.getEmail());
		empRepo.save(e);

		return e;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.empRepo.deleteById(id);

	}

	@Override
	public List<Employee> fetchEmployeesSorted(String strDirection, String sortBy) {

		Sort sort = strDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		return empRepo.findAll(sort);

	}

	@Override
	public List<Employee> fetchEmployeesByFirstName(String firstName) {

		return empRepo.findByFirstName(firstName);

	}

}
