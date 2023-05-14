package com.example.minorProject1.repository;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.minorProject1.models.MyUser;

@Repository
public class UserCacheRepository {
	
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	
	private final String USER_KEY_PREFIX = "user::";
	
	public void set(MyUser myUser) {
		String key = getKey(myUser.getUsername());
		redisTemplate.opsForValue().set(key, myUser,30,TimeUnit.MINUTES);
		
	}
	
	public MyUser get(String username) {
		String key = getKey(username);
		return (MyUser) redisTemplate.opsForValue().get(key);
	}
	
	private String getKey(String username) {
		return USER_KEY_PREFIX+username;
	}

}
