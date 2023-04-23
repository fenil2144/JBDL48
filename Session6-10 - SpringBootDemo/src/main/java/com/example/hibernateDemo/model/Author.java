package com.example.hibernateDemo.model;

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
@Table(name = "authorTable")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "author_seq")
	@SequenceGenerator(name = "author_seq",sequenceName = "author_seq",initialValue = 10,allocationSize = 20)
	private Integer id;
	
	private String name;
	
	

}
