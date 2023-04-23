package com.example.hibernateDemo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personTable")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "person_seq")
	@SequenceGenerator(name = "person_seq",sequenceName = "person_seq")
	private Integer id;
	
	@Column(name = "fName",length = 30)
	private String firstName;
	
	private String lastName;
	
	private Integer age;
	
	private String dob;

}

