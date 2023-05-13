package com.example.SpringSecurityDemo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityDemoApplication implements CommandLineRunner{
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		MyUser user1 = MyUser.builder().name("sai").email("sai@gmail.com").password(passwordEncoder.encode("sai123"))
//				.authority("qa").build();
//		
//		MyUser user2 = MyUser.builder().name("karan").email("karan@gmail.com").password(passwordEncoder.encode("karan123"))
//				.authority("dev").build();
//		
//		userRepository.saveAll(Arrays.asList(user1,user2));
		
	}

}
