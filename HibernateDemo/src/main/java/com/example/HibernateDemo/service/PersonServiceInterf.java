package com.example.HibernateDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.HibernateDemo.dtos.CreatePersonDto;
import com.example.HibernateDemo.model.Person;

public interface PersonServiceInterf {
	
	void createPersonStatic(CreatePersonDto createPersonDto);
	
	Person getPersonById(int id);
	
	void deletePerson(int id);
	
	List<Person> getAllPersons();

}
