package com.gl.prj4.restapi.employeeMgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.prj4.restapi.employeeMgmt.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
