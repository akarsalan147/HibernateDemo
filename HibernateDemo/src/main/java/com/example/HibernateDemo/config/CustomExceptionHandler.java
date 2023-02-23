package com.example.HibernateDemo.config;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.HibernateDemo.dtos.ErrorResponse;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		
		BindingResult result = ex.getBindingResult();
		List<FieldError> feildErrors = result.getFieldErrors();
		
		List<String> errors = feildErrors.stream()
				.map(x->x.getDefaultMessage())
				.collect(Collectors.toList());
		
		ErrorResponse errorResponse = ErrorResponse.builder()
									.message(errors)
									.devMessage(ex.getMessage())
									.status(HttpStatus.NOT_ACCEPTABLE)
									.AppErrorCode("HBR_501")
									.build();
		
		return new ResponseEntity(errorResponse, HttpStatus.NOT_ACCEPTABLE);
	}
	
}
