package com.gl.prj4.restapi.employeeMgmt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.prj4.restapi.employeeMgmt.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	
    public List<Employee> findByFirstName(String firstName);

}
