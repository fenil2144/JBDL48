package com.example.hibernateDemo.exception;

public class BadPersonRequestException extends RuntimeException{
	
	public BadPersonRequestException(String message) {
		super(message);
	}

}
