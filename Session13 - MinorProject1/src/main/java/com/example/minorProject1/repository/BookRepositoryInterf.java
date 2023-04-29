package com.example.minorProject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.minorProject1.models.Book;

public interface BookRepositoryInterf extends JpaRepository<Book, Integer>{

}
