package com.example.hibernateDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hibernateDemo.model.Author;

public interface AuthorRepositoryInterf extends JpaRepository<Author, Integer>{

}
