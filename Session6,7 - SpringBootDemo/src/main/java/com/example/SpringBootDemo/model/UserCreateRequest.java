package com.example.SpringBootDemo.model;

public class UserCreateRequest {
	
	public String name;
	public String mobile;
	
	
	
	public UserCreateRequest() {
		super();
	}
	public UserCreateRequest(String name, String mobile) {
		super();
		this.name = name;
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "UserCreateRequest [name=" + name + ", mobile=" + mobile + "]";
	}
	
	

}
