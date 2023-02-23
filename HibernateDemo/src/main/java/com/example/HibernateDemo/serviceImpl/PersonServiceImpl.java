package com.example.HibernateDemo.serviceImpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HibernateDemo.dtos.CreatePersonDto;
import com.example.HibernateDemo.exception.PersonNotFoundException;
import com.example.HibernateDemo.model.Person;
import com.example.HibernateDemo.repository.PersonRepositoryInterf;
import com.example.HibernateDemo.service.PersonServiceInterf;

import antlr.debug.NewLineEvent;

@Service
public class PersonServiceImpl implements PersonServiceInterf {
	
	@Autowired
	PersonRepositoryInterf personRepositoryInterf;

	@Override
	public void createPersonStatic(CreatePersonDto createPersonDto) {
		Person person = createPersonDto.to();
		
		if (person.getAge() == null) {
			person.setAge(calculateAgeFromDOB(person.getDob()));
		}
		personRepositoryInterf.save(person);
	}
	
	private Integer calculateAgeFromDOB(String dob) {
		if(dob == null) {
			return null;
		}
		LocalDate dobDate = LocalDate.parse(dob);
		LocalDate currentDate = LocalDate.now();
		
		return Period.between(dobDate, currentDate).getYears();
	}

	@Override
	public Person getPersonById(int id) {
		return personRepositoryInterf.findById(id).orElseThrow( () -> new PersonNotFoundException("Person with Id "+id+" not found"));
	}

	@Override
	public void deletePerson(int id) {
		personRepositoryInterf.deleteById(id);
	}

	@Override
	public List<Person> getAllPersons() {
		return personRepositoryInterf.findAll();
	}
	
}
