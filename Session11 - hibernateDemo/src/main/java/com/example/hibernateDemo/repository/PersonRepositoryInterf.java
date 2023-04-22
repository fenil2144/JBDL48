package com.example.hibernateDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hibernateDemo.model.Person;

public interface PersonRepositoryInterf extends JpaRepository<Person, Integer>{

}
