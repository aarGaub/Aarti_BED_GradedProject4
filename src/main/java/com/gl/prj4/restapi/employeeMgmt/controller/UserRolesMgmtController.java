package com.gl.prj4.restapi.employeeMgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gl.prj4.restapi.employeeMgmt.entity.Role;
import com.gl.prj4.restapi.employeeMgmt.entity.User;
import com.gl.prj4.restapi.employeeMgmt.service.MyUserDetailsServiceImpl;
import com.gl.prj4.restapi.employeeMgmt.service.RoleServiceImpl;

@RestController
@RequestMapping("/api/userRoles")
public class UserRolesMgmtController {

	@Autowired
	private MyUserDetailsServiceImpl userService;
	@Autowired
	private RoleServiceImpl roleService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@PostMapping("/addRole")
	@ResponseStatus(HttpStatus.CREATED)
	public Role addNewRole(@RequestBody Role role) {
		return this.roleService.saveRole(role);
	}

	@PostMapping("/addUser")
	@ResponseStatus(HttpStatus.CREATED)
	public User addNewUser(@RequestBody User user) {

		user.setPassword(encoder.encode(user.getPassword()));
		return this.userService.addUser(user);
	}

}
