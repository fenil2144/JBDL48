package com.example.SpringBootDemo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.SpringBootDemo.model.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonDto {
	
	@NotBlank(message = "First Name Should Not Be Empty/Null")
	private String firstName;
	
	@Size(min = 1,max = 45)
	private String lastName;
		
	private String dob;
	
	public Person toPerson() {
		return Person.builder().firstName(firstName).lastName(lastName).dob(dob).build();
	}

}
