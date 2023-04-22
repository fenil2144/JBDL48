package com.example.SpringBootDemo.exceptions;

public class BadPersonRequestException extends RuntimeException{
	
	public BadPersonRequestException(String message) {
		super(message);
	}

}
