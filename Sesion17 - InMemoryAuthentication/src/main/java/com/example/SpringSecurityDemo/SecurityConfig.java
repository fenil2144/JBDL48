package com.example.SpringSecurityDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("karan").password("karan123").authorities("dev")
		.and().withUser("sai").password("sai123123").authorities("qa");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeHttpRequests()
		.antMatchers("/developercode/**").hasAuthority("dev")
		.antMatchers("/qacode/**").hasAuthority("qa")
		.antMatchers("/generalcode/**").hasAnyAuthority("dev","qa")
		.antMatchers("/home").permitAll().and().formLogin();

	}
	
	@Bean
	PasswordEncoder getPE() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	//1. Role based Authority - User will have one ROle and antymatchers can have one or more Role
	//2. Access based Authority - User will have multiple accesses and antmatchers will have one access
	//3. Role + Access based - Combination of Role and Access both

}
