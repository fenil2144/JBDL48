package com.example.SpringBootDemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private Integer age;
	
	private String dob;

}
