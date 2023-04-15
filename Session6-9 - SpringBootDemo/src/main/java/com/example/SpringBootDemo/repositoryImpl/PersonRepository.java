package com.example.SpringBootDemo.repositoryImpl;

import java.sql.Connection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.SpringBootDemo.model.Person;

@Repository	
public class PersonRepository {
	
	private Connection connection;
	
	public PersonRepository(Connection connection) {
		this.connection = connection;
	}
	
	private static Logger logger = LoggerFactory.getLogger(PersonRepository.class);
	
	public void createPersonStatic(Person person) {
		
	}
	
	public Person getPerson(int id) {
		return null;
	}
	
	public Boolean deletePerson(int id) {
		return null;
	}
	
	public List<Person> getAllPersons(){
		return null;
	}

}
