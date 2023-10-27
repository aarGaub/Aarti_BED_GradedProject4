package com.gl.prj4.restapi.employeeMgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gl.prj4.restapi.employeeMgmt.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.userName = ?1")
    public User getUserByUsername(String username);
}
