package com.gl.prj4.restapi.employeeMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.prj4.restapi.employeeMgmt.dao.RoleRepository;
import com.gl.prj4.restapi.employeeMgmt.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepo;

	@Override
	public Role saveRole(Role role) {

		return this.roleRepo.save(role);
	}

	@Override
	public Role getRoleById(Long roleId) {

		return this.roleRepo.findById(roleId).orElseThrow(() -> new IllegalArgumentException("Invalid Role Id"));

	}

}
