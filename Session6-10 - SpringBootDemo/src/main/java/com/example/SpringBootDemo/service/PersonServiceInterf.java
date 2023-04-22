package com.example.SpringBootDemo.service;

import java.util.List;

import com.example.SpringBootDemo.dto.CreatePersonDto;
import com.example.SpringBootDemo.model.Person;

public interface PersonServiceInterf {
	
	void createPersonStatic(CreatePersonDto createPersonDto);
	
	Person getPerson(int id);
	
	Person deletePerson(int id);
	
	List<Person> getAllPersons();

}
