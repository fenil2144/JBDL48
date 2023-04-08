package com.example.SpringBootDemo.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class User {
	
	public User() {
		System.out.println("Inside User Class Constructor");
	}
	
	
	
	public User(int id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	private int id;
	private String name;
	private String phone;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
	
	

}
