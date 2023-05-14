package com.example.minorProject1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Value("${user.authority.admin}")
	String adminAuthority;
	
	@Value("${user.authority.student}")
	String studentAuthority;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().httpBasic().and().authorizeHttpRequests()
		.antMatchers("/savestudent/**").permitAll()
		.antMatchers("/student/**").hasAuthority(studentAuthority)
		.antMatchers("/student_for_admin/**").hasAuthority(adminAuthority)
		.antMatchers(HttpMethod.GET,"/book/**").hasAnyAuthority(studentAuthority,adminAuthority)
		.antMatchers("/book/**").hasAuthority(adminAuthority)
		.antMatchers("/transact/**").hasAnyAuthority(adminAuthority,studentAuthority)
		.antMatchers("/home").permitAll().and().formLogin();

	}
}
