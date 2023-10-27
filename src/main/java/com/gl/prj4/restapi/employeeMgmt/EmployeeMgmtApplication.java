package com.gl.prj4.restapi.employeeMgmt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gl.prj4.restapi.employeeMgmt.dao.UserRepository;
import com.gl.prj4.restapi.employeeMgmt.entity.Role;
import com.gl.prj4.restapi.employeeMgmt.entity.User;

@SpringBootApplication
public class EmployeeMgmtApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMgmtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * Role adminRole = new Role(); adminRole.setRoleName("ADMIN"); Role userRole
		 * =new Role(); userRole.setRoleName("USER");
		 * 
		 * List<Role> rolesAdmin= new ArrayList<>(); rolesAdmin.add(adminRole);
		 * 
		 * List<Role> rolesUser= new ArrayList<>(); rolesUser.add(userRole);
		 * 
		 * //Vihaan is admin role, Aarti has user role
		 * 
		 * User admin = new User(); admin.setUserName("Vihaan");
		 * admin.setPassword(getPasswordEncoder().encode("admin123"));
		 * admin.setRoles(rolesAdmin); userRepo.save(admin);
		 * 
		 * User user = new User(); user.setUserName("Aarti");
		 * user.setPassword(getPasswordEncoder().encode("user123"));
		 * user.setRoles(rolesUser); userRepo.save(user);
		 * System.out.println("password for vihaan "+admin.getPassword());
		 * System.out.println("password for aarti "+user.getPassword());
		 */

	}
	/*
	 * 
	 * @Bean PasswordEncoder getPasswordEncoder() { return new
	 * BCryptPasswordEncoder(); //return NoOpPasswordEncoder.getInstance(); }
	 * 
	 * @Autowired UserRepository userRepo;
	 */
}
