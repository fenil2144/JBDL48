package com.example.hibernateDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hibernateDemo.model.Person;

public interface PersonRepositoryInterf extends JpaRepository<Person, Integer>{
	
	@Query(value = "select * from person p where p.fName=:firstName",nativeQuery = true)
	List<Person> getPersonbyName(String firstName);
	
	List<Person> findByfirstName(String firstName);

}
