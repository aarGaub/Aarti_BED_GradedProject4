package com.gl.prj4.restapi.employeeMgmt.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.gl.prj4.restapi.employeeMgmt.service.MyUserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class MySecurityFilterConfig {

	@Bean
	public UserDetailsService getUserDetailService() {
		return new MyUserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider autheticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(getUserDetailService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;

	}

	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.cors().disable();
		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();

		httpSecurity.authorizeHttpRequests().
				requestMatchers(HttpMethod.GET, "/api/employees/**", "/api/employees**")
				.hasAnyAuthority("USER", "ADMIN")
				.requestMatchers(HttpMethod.POST, "/api/employees**","/api/userRoles/**")
				.hasAuthority("ADMIN")
				.requestMatchers(HttpMethod.PUT, "/api/employees/**")
				.hasAuthority("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/api/employees/**")
				.hasAuthority("ADMIN")
				.anyRequest()
				.authenticated().and().httpBasic()
				.and().authenticationProvider(autheticationProvider())
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		return httpSecurity.build();

	}
}
