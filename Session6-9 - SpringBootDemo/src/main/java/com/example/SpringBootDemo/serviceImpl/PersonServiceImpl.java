package com.example.SpringBootDemo.serviceImpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootDemo.dto.CreatePersonDto;
import com.example.SpringBootDemo.exceptions.BadPersonRequestException;
import com.example.SpringBootDemo.model.Person;
import com.example.SpringBootDemo.repositoryImpl.PersonRepository;
import com.example.SpringBootDemo.service.PersonServiceInterf;

@Service
public class PersonServiceImpl implements PersonServiceInterf {
	
	@Autowired
	PersonRepository personRepository;

	@Override
	public void createPersonStatic(CreatePersonDto createPersonDto) {
		
		Person person = createPersonDto.toPerson();
		if(person.getAge() == null) {
			person.setAge(calculateAgeFromDob(person.getDob()));
		}
		
	}

	@Override
	public Person getPerson(int id) {
		return personRepository.getPerson(id);
	}

	@Override
	public Person deletePerson(int id) {
		
		Person person = personRepository.getPerson(id);
		if(person == null) {
			throw new BadPersonRequestException("Person with id "+id+" doesn't exists!");
		}
		Boolean isDeleted = personRepository.deletePerson(id);
		if(isDeleted)
			return person;
		throw new BadPersonRequestException("There was Error while Deleting Person With id "+id);
	}

	@Override
	public List<Person> getAllPersons() {
		return personRepository.getAllPersons();
	}
	
	private Integer calculateAgeFromDob(String dob) {
		if(dob == null)
			return null;
		LocalDate dobDate = LocalDate.parse(dob);
		LocalDate currentDate = LocalDate.now();
		
		return Period.between(dobDate, currentDate).getYears();
	}

}
