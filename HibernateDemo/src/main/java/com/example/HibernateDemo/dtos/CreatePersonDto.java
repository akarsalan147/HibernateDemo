package com.example.HibernateDemo.dtos;

import javax.validation.constraints.NotBlank;

import com.example.HibernateDemo.model.Person;

import lombok.Data;

@Data
public class CreatePersonDto {

	@NotBlank(message = "First Name should not be empty")
	private String firstName;
	
	private String lastName;
	
	@NotBlank(message = "DOB should not be empty")
	private String dob;
	
	public Person to() {
		return Person.builder()
				.firstName(firstName)
				.lastName(lastName)
				.dob(dob).build();
	}
	
}
