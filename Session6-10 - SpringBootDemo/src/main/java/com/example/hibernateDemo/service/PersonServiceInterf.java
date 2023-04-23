package com.example.hibernateDemo.service;

import java.util.List;

import com.example.hibernateDemo.dto.CreatePersonDto;
import com.example.hibernateDemo.model.Person;

public interface PersonServiceInterf {
	
	Person createPersonStatic(CreatePersonDto createPersonDto);
	
	Person getPerson(int id);
	
	Person deletePerson(int id);
	
	List<Person> getAllPersons();

}

