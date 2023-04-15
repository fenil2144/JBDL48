package com.example.SpringBootDemo.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootDemo.dto.CreatePersonDto;
import com.example.SpringBootDemo.service.PersonServiceInterf;

@RestController
public class PersonController {
	
	@Autowired
	PersonServiceInterf personServiceInterf;
	
	private static Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@PostMapping("/person")
	public ResponseEntity createPerson(@RequestBody @Valid CreatePersonDto createPersonDto) {
		
//		Person person = new Person();
//		person.setAge(null);
//		person.setDob(null);
//		
//		Person.builder().age(12).firstName("dd").build();
		
//		if(createPersonDto.getFirstName() == null || createPersonDto.getFirstName().isEmpty()) {
//			logger.error("Person FirstName is Missing/Empty");
//			return new ResponseEntity("Person FirstName is Missing/Empty",HttpStatus.BAD_REQUEST);
//		}
//		
//		if(createPersonDto.getLastName() == null || createPersonDto.getLastName().isEmpty()) {
//			logger.error("Person LastName is Missing/Empty");
//			return new ResponseEntity("Person LastName is Missing/Empty",HttpStatus.BAD_REQUEST);
//		}
		
		logger.info(createPersonDto.toString());
		personServiceInterf.createPersonStatic(createPersonDto);
		return new ResponseEntity(HttpStatus.ACCEPTED);
		
	}

}

