package com.example.HibernateDemo.exception;

public class PersonNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
//	String appStatCode;
	
	public PersonNotFoundException(String message) {
		super(message);
	}
	
}
