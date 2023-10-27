package com.gl.prj4.restapi.employeeMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gl.prj4.restapi.employeeMgmt.dao.UserRepository;
import com.gl.prj4.restapi.employeeMgmt.entity.User;
import com.gl.prj4.restapi.employeeMgmt.security.MyUserDetails;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService, UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.getUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found!!");
		}
		return new MyUserDetails(user);
	}

	@Override
	public User addUser(User user) {

		return this.userRepo.save(user);
	}

}
