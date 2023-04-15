package com.example.SpringBootDemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootDemo.config.CustomConfig;
import com.example.SpringBootDemo.model.User;
import com.example.SpringBootDemo.model.UserCreateRequest;
import com.example.SpringBootDemo.service.UserService;

@RestController
public class UserController {
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private User user;
	
	@Autowired
	private CustomConfig customConfig;
	
	@Autowired
	@Qualifier("userServiceImpl2")
	private UserService userService;
	
	private int a;
	
	@GetMapping("/user")
	public User getUser() {
//		User user = new User();
		logger.info("User Object is : "+user);
		return user;
	}
	
	public UserController(@Value("${custom.value}") int a) {
		this.a = a;
		logger.info("Value of a : "+a);
	}
	
	@Autowired
	public UserController(User user) {
		logger.info("Value of user : "+user);
	}
	
	
	//User@679fe00
	//User@2396fbcd
	
	//User@4c35502b
	//User@4c35502b
	
	@PostMapping("/user")
	public User saveUser() {
		return user;
	}
	
	@GetMapping("/requestParam")
	public void requestParamMethod(@RequestParam(required = false,defaultValue = "1") int id) {
		logger.info("Request Param received with id = "+id);
		
	}
	
	@GetMapping("/pathVariable/{id}/name/{name}")
	public void pathVariableMethod(@PathVariable int id, @PathVariable String name) {
		logger.info("Path Variable received with id = "+id);
		
	}
	
	@GetMapping("/requestBody")
	public void requestBodyMethod(@RequestBody UserCreateRequest user1) {
		logger.info("Request Body received with User = "+user1);
		
	}
	
	@GetMapping("/getTemplate")
	public void getTemplate() {
		logger.info("In UserController : {}",customConfig.getTemplate());
	}

	//RestTemplate@65d57e4e
	//RestTemplate@65d57e4e
	
	//RestTemplate@108a46d6
	//RestTemplate@108a46d6
	
	//RestTemplate@2c2f06f8
	//RestTemplate@2c733eba
}
