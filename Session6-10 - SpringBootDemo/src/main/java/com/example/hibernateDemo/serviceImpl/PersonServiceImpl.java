package com.example.hibernateDemo.serviceImpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hibernateDemo.dto.CreatePersonDto;
import com.example.hibernateDemo.exception.BadPersonRequestException;
import com.example.hibernateDemo.model.Person;
import com.example.hibernateDemo.repository.PersonRepositoryInterf;
import com.example.hibernateDemo.service.PersonServiceInterf;

@Service
public class PersonServiceImpl implements PersonServiceInterf {
	
	@Autowired
	PersonRepositoryInterf personRepositoryInterf;

	@Override
	public Person createPersonStatic(CreatePersonDto createPersonDto) {
		
		Person person = createPersonDto.toPerson();
		if(person.getAge() == null) {
			person.setAge(calculateAgeFromDob(person.getDob()));
		}
		Person person1 =  personRepositoryInterf.save(person);
		person1.setAge(30);
		return person1;
		
	}

	@Override
	public Person getPerson(int personId) {
		return personRepositoryInterf.findById(personId).orElseThrow(
				() -> new BadPersonRequestException("Person with id "+personId+" doesn't exists!"));
	}

	@Override
	public Person deletePerson(int id) {
		
		Person person = personRepositoryInterf.findById(id).orElseThrow(
				() -> new BadPersonRequestException("Person with id "+id+" doesn't exists!"));
		
		personRepositoryInterf.deleteById(id);
		return person;
	}

	@Override
	public List<Person> getAllPersons() {
		return personRepositoryInterf.findAll();
	}
	
	private Integer calculateAgeFromDob(String dob) {
		if(dob == null)
			return null;
		LocalDate dobDate = LocalDate.parse(dob);
		LocalDate currentDate = LocalDate.now();
		
		return Period.between(dobDate, currentDate).getYears();
	}

}
