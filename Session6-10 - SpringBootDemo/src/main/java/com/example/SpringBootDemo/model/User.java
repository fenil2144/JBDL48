package com.example.SpringBootDemo.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private int id;
	private String name;
	private String phone;
	
}
