package com.example.HibernateDemo.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.HibernateDemo.dtos.CreatePersonDto;
import com.example.HibernateDemo.model.Person;
import com.example.HibernateDemo.serviceImpl.PersonServiceImpl;

@RestController
public class PersonController {

	private static Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	PersonServiceImpl personInterf;
	
	@GetMapping("/person")
	public Person getPersonById(@RequestParam("id") int id) {
		return personInterf.getPersonById(id);
	}
	
	@GetMapping("/persons")
	public List<Person> getAllPerson(){
		return personInterf.getAllPersons();
	}
	
	@PostMapping("/person")
	public ResponseEntity createPerson(@RequestBody @Valid CreatePersonDto createPersonDto) {
		
		personInterf.createPersonStatic(createPersonDto);
		
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deletePerson/{id}")
	public void deletePerson(@PathVariable("id") int id) {
		personInterf.deletePerson(id);
	}

}
