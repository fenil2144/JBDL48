package com.example.SpringBootDemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootDemo.dto.CreatePersonDto;
import com.example.SpringBootDemo.model.Person;
import com.example.SpringBootDemo.service.PersonServiceInterf;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonServiceInterf personServiceInterf;
	
	private static Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@PostMapping()
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
	
	@GetMapping("/{personId}")
	public Person getPerson(@PathVariable("personId") int personId) {
		return personServiceInterf.getPerson(personId);
	}
	
	@GetMapping("/all")
	public List<Person> getAllPersons(){
		return personServiceInterf.getAllPersons();
	}
	
	@DeleteMapping("/{personId}")
	public void deletePerson(@PathVariable("personId") int personId) {
		personServiceInterf.deletePerson(personId);
	}
}

