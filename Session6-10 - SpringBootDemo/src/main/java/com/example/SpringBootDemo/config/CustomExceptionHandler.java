package com.example.SpringBootDemo.config;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.SpringBootDemo.dto.ErrorResponse;
import com.example.SpringBootDemo.exceptions.BadPersonRequestException;

@Configuration
@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		
		List<String> errors = fieldErrors.stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());
		
		ErrorResponse errorResponse = new ErrorResponse(errors, HttpStatus.NOT_ACCEPTABLE, ex.getMessage(), "ERR_501");
		
		
		return new ResponseEntity(errorResponse,HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(BadPersonRequestException.class)
	public ResponseEntity handleBadPersonRequestException(BadPersonRequestException ex){
				
		List<String> customMessage = new ArrayList<String>();
		customMessage.add("Person with Given Id Doesn't Exists!");
		
		ErrorResponse errorResponse = new ErrorResponse(customMessage, HttpStatus.NOT_ACCEPTABLE, ex.getMessage(), "ERR_502");
		
		
		return new ResponseEntity(errorResponse,HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity handleException(Exception ex){
				
		List<String> customMessage = new ArrayList<String>();
		customMessage.add("Something Unexpected happened!");
		
		ErrorResponse errorResponse = new ErrorResponse(customMessage, HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), "ERR_500");
		
		
		return new ResponseEntity(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
