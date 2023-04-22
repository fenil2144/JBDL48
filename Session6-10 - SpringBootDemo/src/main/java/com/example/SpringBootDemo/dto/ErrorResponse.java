package com.example.SpringBootDemo.dto;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	
	private List<String> message;
	private HttpStatus status;
	private String devMessage;
	private String errorCode;

}
