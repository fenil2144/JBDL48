package com.example.wallet;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	ObjectMapper objectMapper;

	@Override
	public User loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
		return userRepository.findByPhoneNumber(phoneNumber);
	}
	
	public void create(UserCreateRequest userCreateRequest) throws JsonProcessingException {
		User user = userCreateRequest.toUser();
		user.setAuthorities(UserConstants.USER_AUTHORITY);
		user = userRepository.save(user);
		
		//publish the event post user creation which will be listened by consumers
		JSONObject jsonObject = new JSONObject();
		
//		jsonObject.put(CommonConstants.USER_CREATION_TOPIC_USERID, user.getId());
//		jsonObject.put(CommonConstants.USER_CREATION_TOPIC_PHONE_NUMBER,user.getPhoneNumber());
//		jsonObject.put(CommonConstants.USER_CREATION_TOPIC_IDENTIFIER_KEY,user.getUserIdentifier());
//		jsonObject.put(CommonConstants.USER_CREATION_TOPIC_IDENTIFIER_VALUE,user.getIdentifierValue());
//		
//		kafkaTemplate.send(CommonConstants.USER_CREATION_TOPIC,objectMapper.writeValueAsString(jsonObject));
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}


}
