package com.example.minorProject1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.minorProject1.requestDto.BookCreateRequest;
import com.example.minorProject1.service.BookServiceInterf;


@RestController
public class BookController {
	
	@Autowired
	BookServiceInterf bookServiceInterf;
	
	@PostMapping("/book")
	public ResponseEntity saveBook(@RequestBody @Valid BookCreateRequest bookCreateRequest) {
		return new ResponseEntity(bookServiceInterf.create(bookCreateRequest),HttpStatus.CREATED);
	}

}
