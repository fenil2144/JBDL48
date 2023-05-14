package com.example.minorProject1.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class CommonConfig{
	
	@Bean
	PasswordEncoder getPE() {
		return new BCryptPasswordEncoder();
	}
	
	//Student:
//	1) Retrieve/Search Books
//	2) Do Transaction(issue/return)
//	3) View/Update details
//	4) Delete/Deactivate Account
//
	//Admin/Librarian:
//	1) Add/Update/Delete Book
//	2) Search/Retrieve Books
//	3) View Student Details
	

	

}
