package com.example.HibernateDemo.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HibernateDemo.model.Person;

public interface PersonRepositoryInterf extends JpaRepository<Person, Integer>{
	
}
