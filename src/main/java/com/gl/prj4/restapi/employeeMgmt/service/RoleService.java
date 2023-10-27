package com.gl.prj4.restapi.employeeMgmt.service;

import com.gl.prj4.restapi.employeeMgmt.entity.Role;

public interface RoleService {

	public Role saveRole(Role role);

	public Role getRoleById(Long roleId);

}
