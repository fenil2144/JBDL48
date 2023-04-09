package com.example.SpringBootDemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {
	
	private int id;
	private String name;
	private int price;
	private String author;

}
